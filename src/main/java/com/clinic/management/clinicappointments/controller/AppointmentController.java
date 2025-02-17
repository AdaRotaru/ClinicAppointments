package com.clinic.management.clinicappointments.controller;

import com.clinic.management.clinicappointments.model.Appointment;
import com.clinic.management.clinicappointments.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Operation(summary = "Obține lista programărilor", description = "Returnează toate programările înregistrate")
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @Operation(summary = "Creează o nouă programare", description = "Adaugă o nouă programare")
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }
    @Operation(summary = "Pacientii își pot vedea programările", description = "Returnează toate programarile unui anumit pacient")
    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsForPatient(patientId);
    }
//    @GetMapping("/doctor/{doctorId}/date")
//    public List<Appointment> getAppointmentsForDoctorByDate(@PathVariable Long doctorId, @RequestParam String date) {
//        LocalDate parsedDate = LocalDate.parse(date);
//        return appointmentService.getAppointmentsForDoctorByDate(doctorId, parsedDate);
//    }

}
