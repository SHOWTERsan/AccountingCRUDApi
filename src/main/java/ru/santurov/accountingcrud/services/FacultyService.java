package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.santurov.accountingcrud.models.Faculty;
import ru.santurov.accountingcrud.repositories.FacultyRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public List<Faculty> getFaculties() {
        return StreamSupport.stream(facultyRepository.findAll().spliterator(),false).toList();
    }
}
