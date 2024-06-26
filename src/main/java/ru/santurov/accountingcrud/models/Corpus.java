package ru.santurov.accountingcrud.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "corpus")
@Data
public class Corpus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty parentFaculty;
}
