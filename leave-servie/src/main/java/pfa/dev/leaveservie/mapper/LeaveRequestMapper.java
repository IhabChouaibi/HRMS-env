package pfa.dev.leaveservice.mapper;

import org.mapstruct.Mapper;
import pfa.dev.leaveservice.dto.LeaveRequestDto;
import pfa.dev.leaveservice.enities.LeaveRequest;

@Mapper(componentModel ="spring")

public interface LeaveRequestMapper {
    LeaveRequestDto toDto(LeaveRequest leaveRequest);
    LeaveRequest toEntity(LeaveRequestDto leaveRequestDto);

}
