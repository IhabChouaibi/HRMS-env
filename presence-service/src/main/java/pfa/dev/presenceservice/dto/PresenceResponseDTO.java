package pfa.dev.presenceservice.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PresenceResponseDTO {

    private Long id;

    private Long employeeId;

    private LocalDate date;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private Integer workedMinutes;

    private Integer lateMinutes;

    private String status;

    private Boolean validated;

}