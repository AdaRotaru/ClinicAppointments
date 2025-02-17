package com.clinic.management.clinicappointments.service;

import com.clinic.management.clinicappointments.model.Room;
import com.clinic.management.clinicappointments.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
