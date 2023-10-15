package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.santurov.accountingcrud.models.Room;
import ru.santurov.accountingcrud.repositories.RoomRepository;


@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public Page<Room> getRooms(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }
}
