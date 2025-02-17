package com.clinic.management.clinicappointments.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {

    @Id
    private Long id;  // ID trebuie trimis manual în request

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;  // Nou câmp adăugat (Data Nașterii)

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "PHONE", nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String cnp;

}
