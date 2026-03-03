package pfa.dev.presenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;
import pfa.dev.presenceservice.entity.Presence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PresenceRepository
        extends JpaRepository<Presence, Long> {

    Optional<Presence> findByEmployeeIdAndDate(
            Long employeeId,
            LocalDate date
    );



    List<Presence> findAllByEmployeeId(Long employeeId);
}