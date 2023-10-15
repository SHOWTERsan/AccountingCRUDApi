package ru.santurov.accountingcrud.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Entity
@Table(name = "room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "corps_id")
    private Corpus corps;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "floor_number")
    private String floorNumber;
}
