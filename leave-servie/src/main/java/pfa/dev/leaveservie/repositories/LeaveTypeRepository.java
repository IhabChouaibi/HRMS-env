package pfa.dev.leaveservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.dev.leaveservice.enities.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType,Long> {
}
