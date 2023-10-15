package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.santurov.accountingcrud.models.Department;
import ru.santurov.accountingcrud.repositories.DepartmentRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        return StreamSupport.stream(departmentRepository.findAll().spliterator(),false).toList();
    }
 }
