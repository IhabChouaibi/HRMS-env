package pfa.dev.presenceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pfa.dev.presenceservice.dto.CheckInRequestDTO;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;
import pfa.dev.presenceservice.entity.Presence;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PresenceMapper {

    // =============================
    // ENTITY → RESPONSE DTO
    // =============================
    @Mapping(target = "status",
            expression = "java(presence.getStatus() != null ? presence.getStatus().name() : null)")
    PresenceResponseDTO toDTO(Presence presence);

    List<PresenceResponseDTO> toDTOList(List<Presence> presences);


    // =============================
    // REQUEST DTO → ENTITY
    // =============================
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "checkIn", ignore = true)
    @Mapping(target = "checkOut", ignore = true)
    @Mapping(target = "workedMinutes", ignore = true)
    @Mapping(target = "lateMinutes", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "validated", ignore = true)
    Presence toEntity(CheckInRequestDTO dto);

}