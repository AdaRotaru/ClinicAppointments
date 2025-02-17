package com.clinic.management.clinicappointments.controller;

import com.clinic.management.clinicappointments.model.Patient;
import com.clinic.management.clinicappointments.repository.PatientRepository;
import com.clinic.management.clinicappointments.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private PatientService patientService;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository, PatientService patientService) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }

    @Operation(summary = "Obține lista pacienților", description = "Returnează toți pacienții din baza de date")
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @Operation(summary = "Caută pacienți după id", description = "Returnează pacienții dupa id.")
    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @Operation(summary = "Adaugă un pacient nou", description = "Creează un nou pacient și îl salvează în baza de date")
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @Operation(summary = "Șterge un pacient", description = "Șterge pacientul cu ID-ul specificat")
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @Operation(summary = "Caută pacienți după nume", description = "Returnează pacienții dupa nume sau dupa e-mail")
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam String keyword) {
        List<Patient> patients = patientRepository.searchPatients(keyword);
        return ResponseEntity.ok(patients);
    }
}
