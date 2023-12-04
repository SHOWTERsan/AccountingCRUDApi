package ru.santurov.accountingcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.santurov.accountingcrud.models.Floor;
import ru.santurov.accountingcrud.services.FloorService;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
@RequiredArgsConstructor
public class FloorController {
    private final FloorService floorService;

    @GetMapping("")
    public List<Floor> getFloors() {
        return floorService.getFloors();
    }
}
