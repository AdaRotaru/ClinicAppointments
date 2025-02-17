package com.clinic.management.clinicappointments.controller;

import com.clinic.management.clinicappointments.model.Room;
import com.clinic.management.clinicappointments.repository.RoomRepository;
import com.clinic.management.clinicappointments.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomRepository roomRepository;

    @Operation(summary = "Obține lista camerelor", description = "Returnează toate camerele disponibile")
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}
