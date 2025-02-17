package com.clinic.management.clinicappointments.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Clinic Appointments API")
                        .version("1.0")
                        .description("Documentația API-ului pentru gestionarea clinicilor, doctorilor și programărilor"));
    }
}
