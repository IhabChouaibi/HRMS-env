package pfa.dev.leaveservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pfa.dev.leaveservice.enities.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {
}
