package pfa.dev.leaveservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pfa.dev.leaveservice.dto.LeaveTypeDto;
import pfa.dev.leaveservice.enities.LeaveType;

@Mapper(componentModel ="spring")

public interface LeaveTypeMapper {

    @Mappings(
            {

            }
    )
    LeaveTypeDto toDto(LeaveType leaveType);
    LeaveType toEntity(LeaveTypeDto leaveTypeDto);

}
