package pfa.dev.presenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.dev.presenceservice.entity.WorkSchedule;

import java.util.Optional;

public interface WorkScheduleRepository
        extends JpaRepository<WorkSchedule, Long> {

    Optional<WorkSchedule> findByActiveTrue();

}