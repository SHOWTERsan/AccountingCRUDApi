package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    public Department updateDepartment(long id, Department departmentDetails) {
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setName(departmentDetails.getName());
                    department.setParentFaculty(departmentDetails.getParentFaculty());
                    return departmentRepository.save(department);
                }).orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));
    }

    public Department createDepartment(Department newDepartment) {
        return departmentRepository.save(newDepartment);
    }

    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }
}
