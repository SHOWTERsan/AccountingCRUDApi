package ru.santurov.accountingcrud.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_department_id")
    private Department parentDepartment;
}
