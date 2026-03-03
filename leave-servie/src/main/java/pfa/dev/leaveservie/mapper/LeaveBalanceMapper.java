package pfa.dev.leaveservice.mapper;

import org.mapstruct.Mapper;
import pfa.dev.leaveservice.dto.LeaveBalanceDto;
import pfa.dev.leaveservice.enities.LeaveBalance;

@Mapper(componentModel ="spring")
public interface LeaveBalanceMapper {
    LeaveBalanceDto toDto(LeaveBalance leaveBalance);
    LeaveBalance toEntity(LeaveBalanceDto leaveBalanceDto);

}
