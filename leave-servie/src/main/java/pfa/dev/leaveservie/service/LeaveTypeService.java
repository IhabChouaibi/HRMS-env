package pfa.dev.leaveservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pfa.dev.leaveservice.dto.LeaveTypeDto;
import pfa.dev.leaveservice.enities.LeaveType;

public interface LeaveTypeService {
    LeaveTypeDto  createLeaveType(LeaveTypeDto leaveTypeDto);
    LeaveTypeDto updateLeaveType(LeaveTypeDto leaveTypeDto, Long id);
    LeaveTypeDto findLeaveTypeById(Long id);
    Page<LeaveTypeDto> findLeaveTypeByPage(Pageable pageable);
    void deleteLeaveTypeById(Long id);
}
