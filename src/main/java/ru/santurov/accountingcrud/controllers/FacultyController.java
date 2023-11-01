package ru.santurov.accountingcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.santurov.accountingcrud.models.Faculty;
import ru.santurov.accountingcrud.services.FacultyService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/faculties")
public class FacultyController {
    private final FacultyService facultyService;
    @GetMapping("")
    public List<Faculty> getFaculties() {
        return facultyService.getFaculties();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable(value = "id") long id, @RequestBody Faculty facultyDetails) {
        Faculty faculty = facultyService.updateFaculty(id, facultyDetails);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(faculty);
        }
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty newFaculty) {
        if (newFaculty.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        Faculty faculty = facultyService.saveFaculty(newFaculty);
        return new ResponseEntity<>(faculty, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable(value = "id") long id) {
        facultyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
