package pfa.dev.presenceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pfa.dev.presenceservice.dto.CheckInRequestDTO;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;
import pfa.dev.presenceservice.entity.Presence;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PresenceMapper {

    @Mapping(target = "status",
            expression = "java(presence.getStatus() != null ? presence.getStatus().name() : null)")
    PresenceResponseDTO toDTO(Presence presence);
    List<PresenceResponseDTO> toDTOList(List<Presence> presences);


    Presence toEntity(CheckInRequestDTO dto);

}