package com.clinic.management.clinicappointments.repository;

import com.clinic.management.clinicappointments.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE d.specialty.name = :spec")
    List<Doctor> findBySpecialtyName(@Param("spec") String spec);
}
