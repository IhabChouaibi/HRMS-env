package pfa.dev.presenceservice.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckInRequestDTO {


    private Long employeeId;

}