package com.clinic.management.clinicappointments.controller;

import com.clinic.management.clinicappointments.model.Patient;
import com.clinic.management.clinicappointments.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(PatientController.class)
@AutoConfigureMockMvc
class PatientControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//   @Mock
//    private PatientService patientService;
//
//    @BeforeEach
//    void setup() {
//        patientService = Mockito.mock(PatientService.class);
//    }
//
//    @Test
//    void testgetAllPatients() throws Exception {
//        List<Patient> patients = List.of(
//                new Patient(1L, "ion_popescu", "Ion", "Popescu", null, "ion@email.com", "0723123456", "1234567890123"),
//                new Patient(2L, "maria_ionescu", "Maria", "Ionescu", null, "maria@email.com", "0723987654", "9876543210987")
//        );
//
//        when(patientService.getAllPatients()).thenReturn(patients);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/patients"))
//                .andExpect(status().isOk()) // Verificăm că răspunsul este 200 OK
//                .andExpect(jsonPath("$.length()").value(2)) // Verificăm că sunt 2 pacienți
//                .andExpect(jsonPath("$[0].firstName").value("Ion")) // Verificăm primul pacient
//                .andExpect(jsonPath("$[1].firstName").value("Maria")); // Verificăm al doilea pacient
//    }
}
