package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.santurov.accountingcrud.models.Faculty;
import ru.santurov.accountingcrud.repositories.FacultyRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public List<Faculty> getFaculties() {
        return StreamSupport.stream(facultyRepository.findAll().spliterator(),false).toList();
    }

    public Faculty updateFaculty(long id, Faculty facultyDetails) {
        return facultyRepository.findById(id)
                .map(faculty -> {
                    faculty.setName(facultyDetails.getName());
                    return facultyRepository.save(faculty);
                }).orElseThrow(() -> new ResourceNotFoundException("Faculty not found with id " + id));
    }

    public Faculty saveFaculty(Faculty newFaculty) {
        return facultyRepository.save(newFaculty);
    }

    public void deleteById(long id) {
        facultyRepository.deleteById(id);
    }
}
