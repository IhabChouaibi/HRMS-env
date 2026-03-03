package pfa.dev.presenceservice.service;

import pfa.dev.presenceservice.dto.CheckInRequestDTO;
import pfa.dev.presenceservice.dto.CheckOutRequestDTO;
import pfa.dev.presenceservice.dto.PresenceResponseDTO;

import java.util.List;

public interface PresenceService {

    PresenceResponseDTO checkIn(CheckInRequestDTO request);

    PresenceResponseDTO checkOut(CheckOutRequestDTO request);

    List<PresenceResponseDTO> getEmployeeHistory(Long employeeId);

}