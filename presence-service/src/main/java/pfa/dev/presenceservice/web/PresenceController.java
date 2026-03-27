package pfa.dev.presenceservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pfa.dev.presenceservice.dto.CheckInRequestDTO;
import pfa.dev.presenceservice.dto.CheckOutRequestDTO;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;
import pfa.dev.presenceservice.dto.PresenceValidationRequestDTO;
import pfa.dev.presenceservice.service.PresenceService;

import java.util.List;

@RestController
@RequestMapping("/presences")
@RequiredArgsConstructor
public class PresenceController {

    private final PresenceService presenceService;
    @PreAuthorize("hasRole('EMPLOYEE')")

    @PostMapping("/check-in")
    public ResponseEntity<PresenceResponseDTO>
    checkIn( @RequestBody CheckInRequestDTO request) {

        return ResponseEntity.ok(
                presenceService.checkIn(request)
        );
    }
    @PreAuthorize("hasAnyRole('HR', 'EMPLOYEE')")

    @PostMapping("/check-out")
    public ResponseEntity<PresenceResponseDTO>
    checkOut( @RequestBody CheckOutRequestDTO request) {

        return ResponseEntity.ok(
                presenceService.checkOut(request)
        );
    }
    @PreAuthorize("hasAnyRole('HR', 'EMPLOYEE')")


    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<PresenceResponseDTO>>
    getEmployeeHistory(@PathVariable Long employeeId) {

        return ResponseEntity.ok(
                presenceService.getEmployeeHistory(employeeId)
        );
    }
    @PreAuthorize("hasAnyRole('HR', 'EMPLOYEE')")


    @GetMapping("/employee/{employeeId}/history")
    public ResponseEntity<Page<PresenceResponseDTO>> getEmployeeHistoryPaged(
            @PathVariable Long employeeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(
                presenceService.getEmployeeHistoryPaged(employeeId, PageRequest.of(page, size))
        );
    }

    @PreAuthorize("hasRole('HR')")

    @GetMapping("/getall")
    public ResponseEntity<Page<PresenceResponseDTO>> getAllPresences(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(
                presenceService.getAllPresences(PageRequest.of(page, size))
        );
    }

    @PreAuthorize("hasRole('HR')")
    @GetMapping("/pending-validation")
    public ResponseEntity<Page<PresenceResponseDTO>> getPendingValidation(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(
                presenceService.getPendingValidation(PageRequest.of(page, size))
        );
    }

    @PreAuthorize("hasRole('HR')")
    @PutMapping("/{id}/validate")
    public ResponseEntity<PresenceResponseDTO> validatePresence(
            @PathVariable Long id,
            @RequestBody PresenceValidationRequestDTO request
    ) {
        return ResponseEntity.ok(presenceService.validatePresence(id, request));
    }
}
