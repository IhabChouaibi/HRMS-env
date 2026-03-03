package pfa.dev.leaveservice.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LeaveTypeDto {


    private Long id;

    private String name;

    private String paid;

    private String requiresApproval;

    private String requiresDocument;

    private Integer maxDaysPerYear;

    private boolean deductFromBalance;
}
