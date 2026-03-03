package pfa.dev.presenceservice.mapper;

import org.mapstruct.Mapper;
import pfa.dev.presenceservice.dto.WorkScheduleResponseDTO;
import pfa.dev.presenceservice.entity.WorkSchedule;

@Mapper(componentModel = "spring")
public interface WorkScheduleMapper {

    WorkScheduleResponseDTO toDTO(WorkSchedule schedule);


}