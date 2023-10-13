package ru.santurov.accountingcrud.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Corps")
@Data
public class Corps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "floor_number")
    private int floorNumber;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "length")
    private BigDecimal length;

    @ManyToOne
    @JoinColumn(name = "parent_department_id")
    private Department parentDepartment;
}
