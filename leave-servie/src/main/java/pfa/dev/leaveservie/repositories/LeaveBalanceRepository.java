package pfa.dev.leaveservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.dev.leaveservice.enities.LeaveBalance;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance,Long> {
}
