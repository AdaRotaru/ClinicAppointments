package com.clinic.management.clinicappointments.repository;

import com.clinic.management.clinicappointments.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Patient> searchPatients(@Param("keyword") String keyword);
}
