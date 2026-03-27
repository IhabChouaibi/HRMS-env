package pfa.dev.presenceservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pfa.dev.presenceservice.dto.CheckInRequestDTO;
import pfa.dev.presenceservice.dto.CheckOutRequestDTO;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;
import pfa.dev.presenceservice.dto.PresenceValidationRequestDTO;

import java.util.List;

public interface PresenceService {

    PresenceResponseDTO checkIn(CheckInRequestDTO request);

    PresenceResponseDTO checkOut(CheckOutRequestDTO request);

    List<PresenceResponseDTO> getEmployeeHistory(Long employeeId);

    Page<PresenceResponseDTO> getEmployeeHistoryPaged(Long employeeId, Pageable pageable);

    Page<PresenceResponseDTO> getAllPresences(Pageable pageable);

    Page<PresenceResponseDTO> getPendingValidation(Pageable pageable);

    PresenceResponseDTO validatePresence(Long id, PresenceValidationRequestDTO request);

}
