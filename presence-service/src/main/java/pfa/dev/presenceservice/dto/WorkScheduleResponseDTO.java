package pfa.dev.presenceservice.dto;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkScheduleResponseDTO {

    private Long id;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer toleranceMinutes;

}