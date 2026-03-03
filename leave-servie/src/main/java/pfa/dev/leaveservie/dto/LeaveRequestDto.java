package pfa.dev.leaveservice.dto;

import jakarta.persistence.*;
import lombok.*;
import pfa.dev.leaveservice.enities.LeaveStatus;
import pfa.dev.leaveservice.enities.LeaveType;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@Builder

public class LeaveRequestDto {

    private Long id;

    private Long employeeId;

    private LeaveType leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer totalDays;

    private LeaveStatus status;


    private String reason;



}
