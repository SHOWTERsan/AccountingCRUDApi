package ru.santurov.accountingcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.santurov.accountingcrud.models.Department;
import ru.santurov.accountingcrud.services.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Department> updateFaculty(@PathVariable(name = "id") long id, @RequestBody Department departmentDetails) {
        Department department = departmentService.updateDepartment(id,departmentDetails);

        if (department == null) {
            return ResponseEntity.notFound().build();
        }
        else return ResponseEntity.ok(department);
    }

    @PostMapping("")
    public ResponseEntity<Department> createDepartment(@RequestBody Department newDepartment) {
        if (newDepartment.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Department department = departmentService.createDepartment(newDepartment);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable(name = "id") long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
