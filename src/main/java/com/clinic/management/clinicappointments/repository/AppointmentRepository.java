package com.clinic.management.clinicappointments.repository;

import com.clinic.management.clinicappointments.model.Appointment;
import com.clinic.management.clinicappointments.model.Doctor;
import com.clinic.management.clinicappointments.model.Patient;
import com.clinic.management.clinicappointments.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.patient = :patient " +
            "AND a.startDate <= :endDate AND a.endDate >= :startDate AND a.doctor <> :doctor")
    long countOverlappingAppointments(@Param("patient") Patient patient,
                                      @Param("endDate") LocalDateTime endDate,
                                      @Param("startDate") LocalDateTime startDate,
                                      @Param("doctor") Doctor doctor);

    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :patientId")
    List<Appointment> findByPatientId(@Param("patientId") Long patientId);
//    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND FUNCTION('TRUNC', a.startDate) = :date")
//    List<Appointment> findByDoctorIdAndDate(@Param("doctorId") Long doctorId, @Param("date") LocalDate date);
//


}

