package com.clinic.management.clinicappointments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(title = "Clinic API", version = "1.0", description = "API pentru gestionarea clinicilor și programărilor")
)
@SpringBootApplication
@EnableJpaRepositories("com.clinic.management.clinicappointments.repository")
public class ClinicAppointmentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClinicAppointmentsApplication.class, args);
    }
}

