package ru.santurov.accountingcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.santurov.accountingcrud.models.*;
import ru.santurov.accountingcrud.services.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {
    private final CorpusService corpusService;
    private final DepartmentService departmentService;
    private final FacultyService facultyService;
    private final FloorService floorService;
    private final RoomService roomService;

    @GetMapping("corps")
    public List<Corpus> getCorps() {
        return corpusService.getCorps();
    }

    @GetMapping("departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("faculties")
    public List<Faculty> getFaculties() {
        return facultyService.getFaculties();
    }

    @GetMapping("floors")
    public List<Floor> getFloors() {
        return floorService.getFloors();
    }

    @GetMapping("rooms")
    public ResponseEntity<Page<Room>> getLimitRooms(@PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Room> page = roomService.getRooms(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
