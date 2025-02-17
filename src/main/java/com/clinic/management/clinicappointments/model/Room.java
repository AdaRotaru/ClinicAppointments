package com.clinic.management.clinicappointments.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {

    @Id
    private Long id;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "id", nullable = true)
    private Clinic clinic;
}
