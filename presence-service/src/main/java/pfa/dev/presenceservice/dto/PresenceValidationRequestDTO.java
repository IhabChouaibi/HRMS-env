package pfa.dev.presenceservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenceValidationRequestDTO {
    private boolean validated;
    private String note;
}
