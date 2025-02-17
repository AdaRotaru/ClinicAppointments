package com.clinic.management.clinicappointments.controller;

import com.clinic.management.clinicappointments.model.Doctor;
import com.clinic.management.clinicappointments.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Operation(summary = "Obține lista doctorilor", description = "Returnează toți doctorii înregistrați")
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @Operation(summary = "Cauta doctori dupa ID", description = "Returnează doctorul cu un anumit ID specificat")
    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @Operation(summary = "Adaugă un doctor nou", description = "Creează un doctor nou și îl salvează în baza de date")
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @Operation(summary = "Șterge un doctor", description = "Șterge doctorul specificat prin ID")
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    @Operation(summary = "Editează un doctor", description = "Modifică datele unui doctor existent")
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
        return ResponseEntity.ok(updatedDoctor);
    }
    @Operation(summary = "Caută doctori după specializare", description = "Returnează toți doctorii care au specializarea specificată")
    @GetMapping("/search")
    public List<Doctor> searchDoctors(@RequestParam("spec") String spec) {
        return doctorService.searchDoctorsBySpec(spec);
    }
}

