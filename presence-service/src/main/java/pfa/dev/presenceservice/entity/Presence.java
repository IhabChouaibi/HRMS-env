package pfa.dev.presenceservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "presences",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"employee_id", "date"})
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private LocalDate date;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private Integer workedMinutes;

    private Integer lateMinutes;

    @Enumerated(EnumType.STRING)
    private PresenceStatus status;

    private Boolean validated;
}