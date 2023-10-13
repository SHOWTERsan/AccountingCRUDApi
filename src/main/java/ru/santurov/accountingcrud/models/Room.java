package ru.santurov.accountingcrud.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Entity
@Table(name = "Rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "room_name")
    private String roomName;

    @ManyToOne
    @JoinColumn(name = "corps_id")
    private Corps corps;

    @Column(name = "height")
    private BigDecimal height;
}
