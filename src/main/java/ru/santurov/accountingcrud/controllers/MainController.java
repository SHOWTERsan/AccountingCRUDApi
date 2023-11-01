package ru.santurov.accountingcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.santurov.accountingcrud.models.*;
import ru.santurov.accountingcrud.services.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {
    private final CorpusService corpusService;
    private final DepartmentService departmentService;
    private final FloorService floorService;


    @GetMapping("corps")
    public List<Corpus> getCorps() {
        return corpusService.getCorps();
    }

    @GetMapping("departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }



    @GetMapping("floors")
    public List<Floor> getFloors() {
        return floorService.getFloors();
    }


}
