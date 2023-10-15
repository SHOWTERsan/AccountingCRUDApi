package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.santurov.accountingcrud.models.Floor;
import ru.santurov.accountingcrud.repositories.FloorRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class FloorService {
    private final FloorRepository floorRepository;

    public List<Floor> getFloors() {
        return StreamSupport.stream(floorRepository.findAll().spliterator(),false).toList();
    }
}
