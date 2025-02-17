package com.clinic.management.clinicappointments.service;

import com.clinic.management.clinicappointments.model.Clinic;
import com.clinic.management.clinicappointments.model.Doctor;
import com.clinic.management.clinicappointments.model.Specialty;
import com.clinic.management.clinicappointments.repository.ClinicRepository;
import com.clinic.management.clinicappointments.repository.DoctorRepository;
import com.clinic.management.clinicappointments.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ClinicRepository clinicRepository;
    private final SpecialtyRepository specialtyRepository;

    public DoctorService(DoctorRepository doctorRepository, ClinicRepository clinicRepository, SpecialtyRepository specialtyRepository) {
        this.doctorRepository = doctorRepository;
        this.clinicRepository = clinicRepository;
        this.specialtyRepository = specialtyRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setUsername(doctorDetails.getUsername());
            doctor.setFirstName(doctorDetails.getFirstName());
            doctor.setLastName(doctorDetails.getLastName());
            doctor.setHireDate(doctorDetails.getHireDate());

            // Caută clinica completă după ID și setează-o
            Clinic clinic = clinicRepository.findById(doctorDetails.getClinic().getId())
                    .orElseThrow(() -> new RuntimeException("Clinic not found"));
            doctor.setClinic(clinic);

            // Caută specializarea completă
            Specialty specialty = specialtyRepository.findById(doctorDetails.getSpecialty().getId())
                    .orElseThrow(() -> new RuntimeException("Specialty not found"));
            doctor.setSpecialty(specialty);

            return doctorRepository.save(doctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }
    public List<Doctor> searchDoctorsBySpec(String spec) {
        return doctorRepository.findBySpecialtyName(spec);
    }

}
