package ru.santurov.accountingcrud.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "floor")
@Data
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "height")
    private String height;
}
