package pfa.dev.leaveservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pfa.dev.leaveservice.enities.LeaveType;
@Getter
@Setter
@ToString
@Builder
public class LeaveBalanceDto {

    private Long id;

    private Long employeeId;

    private LeaveType leaveType;

    private Integer remainingDays;


    private Integer usedDays;
}
