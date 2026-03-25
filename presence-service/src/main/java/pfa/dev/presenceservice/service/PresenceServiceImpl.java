package pfa.dev.presenceservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfa.dev.presenceservice.dto.CheckInRequestDTO;
import pfa.dev.presenceservice.dto.CheckOutRequestDTO;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;
import pfa.dev.presenceservice.entity.Presence;
import pfa.dev.presenceservice.entity.PresenceStatus;
import pfa.dev.presenceservice.entity.WorkSchedule;
import pfa.dev.presenceservice.mapper.PresenceMapper;
import pfa.dev.presenceservice.repositories.PresenceRepository;
import pfa.dev.presenceservice.repositories.WorkScheduleRepository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PresenceServiceImpl
        implements PresenceService {

    private final PresenceRepository presenceRepository;
    private final WorkScheduleRepository workScheduleRepository;
    private final PresenceMapper presenceMapper;

    @Override
    public PresenceResponseDTO checkIn(
            CheckInRequestDTO request) {

        Long employeeId = request.getEmployeeId();
        LocalDate today = LocalDate.now();

        // 1️⃣ Check if already checked-in
        presenceRepository
                .findByEmployeeIdAndDate(employeeId, today)
                .ifPresent(p -> {
                    throw new RuntimeException(
                            "Employee already checked in today");
                });

        // 2️⃣ Load active schedule
        WorkSchedule schedule =
                workScheduleRepository.findByActiveTrue()
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Active schedule not found"));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime officialStart =
                LocalDateTime.of(today, schedule.getStartTime());

        int lateMinutes = 0;
        PresenceStatus status = PresenceStatus.PRESENT;

        if (now.isAfter(
                officialStart.plusMinutes(
                        schedule.getToleranceMinutes()))) {

            lateMinutes = (int) Duration
                    .between(officialStart, now)
                    .toMinutes();

            status = PresenceStatus.LATE;
        }

        // 4️⃣ Create presence
        Presence presence = Presence.builder()
                .employeeId(employeeId)
                .date(today)
                .checkIn(now)
                .lateMinutes(lateMinutes)
                .status(status)
                .validated(false)
                .build();

        presenceRepository.save(presence);

        return presenceMapper.toDTO(presence);
    }

    @Override
    public PresenceResponseDTO checkOut(
            CheckOutRequestDTO request) {

        Long employeeId = request.getEmployeeId();
        LocalDate today = LocalDate.now();

        Presence presence =
                presenceRepository
                        .findByEmployeeIdAndDate(employeeId, today)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "No check-in found for today"));

        if (presence.getCheckOut() != null) {
            throw new RuntimeException(
                    "Employee already checked out");
        }

        LocalDateTime now = LocalDateTime.now();
        presence.setCheckOut(now);

        // 1️⃣ Calculate worked minutes
        int workedMinutes = (int) Duration
                .between(presence.getCheckIn(), now)
                .toMinutes();

        presence.setWorkedMinutes(workedMinutes);

        presenceRepository.save(presence);

        return presenceMapper.toDTO(presence);
    }


    @Override
    @Transactional(readOnly = true)
    public List<PresenceResponseDTO>
    getEmployeeHistory(Long employeeId) {

        List<Presence> presences =
                presenceRepository
                        .findAllByEmployeeId(employeeId);

        return presenceMapper.toDTOList(presences);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PresenceResponseDTO> getEmployeeHistoryPaged(Long employeeId, Pageable pageable) {
        return presenceRepository
                .findAllByEmployeeId(employeeId, pageable)
                .map(presenceMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PresenceResponseDTO> getAllPresences(Pageable pageable) {
        return presenceRepository.findAll(pageable)
                .map(presenceMapper::toDTO);
    }

}
