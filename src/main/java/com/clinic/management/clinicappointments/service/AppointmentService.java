package com.clinic.management.clinicappointments.service;

import com.clinic.management.clinicappointments.model.Appointment;
import com.clinic.management.clinicappointments.model.Room;
import com.clinic.management.clinicappointments.repository.AppointmentRepository;
import com.clinic.management.clinicappointments.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        if (appointment.getStartDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Nu poți crea o programare în trecut!");
        }

        if (appointment.getStartDate().isAfter(appointment.getEndDate())) {
            throw new RuntimeException("Data de început trebuie să fie înainte de data de sfârșit.");
        }

        long overlappingAppointments = appointmentRepository.countOverlappingAppointments(
                appointment.getPatient(), appointment.getEndDate(), appointment.getStartDate(), appointment.getDoctor());

        if (overlappingAppointments > 0) {
            throw new RuntimeException("Pacientul are deja o programare activă cu un alt doctor.");
        }

        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
//    public List<Appointment> getAppointmentsForDoctorByDate(Long doctorId, LocalDate date) {
//        return appointmentRepository.findByDoctorIdAndDate(doctorId, date);
//    }



}
