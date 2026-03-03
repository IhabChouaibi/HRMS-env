package pfa.dev.presenceservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfa.dev.presenceservice.dto.CheckInRequestDTO;
import pfa.dev.presenceservice.dto.CheckOutRequestDTO;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;
import pfa.dev.presenceservice.service.PresenceService;

import java.util.List;

@RestController
@RequestMapping("/presences")
@RequiredArgsConstructor
public class PresenceController {

    private final PresenceService presenceService;

    @PostMapping("/check-in")
    public ResponseEntity<PresenceResponseDTO>
    checkIn( @RequestBody CheckInRequestDTO request) {

        return ResponseEntity.ok(
                presenceService.checkIn(request)
        );
    }

    @PostMapping("/check-out")
    public ResponseEntity<PresenceResponseDTO>
    checkOut( @RequestBody CheckOutRequestDTO request) {

        return ResponseEntity.ok(
                presenceService.checkOut(request)
        );
    }


    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<PresenceResponseDTO>>
    getEmployeeHistory(@PathVariable Long employeeId) {

        return ResponseEntity.ok(
                presenceService.getEmployeeHistory(employeeId)
        );
    }
}