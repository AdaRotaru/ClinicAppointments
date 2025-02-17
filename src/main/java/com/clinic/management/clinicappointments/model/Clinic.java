package com.clinic.management.clinicappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "clinic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clinic {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctors;
}
