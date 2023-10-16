package ru.santurov.accountingcrud.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "faculty")
@Data
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique=true, nullable = false)
    private String name;
}
