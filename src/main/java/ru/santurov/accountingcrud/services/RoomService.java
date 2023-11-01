package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.santurov.accountingcrud.dto.RoomDTO;
import ru.santurov.accountingcrud.models.Corpus;
import ru.santurov.accountingcrud.models.Floor;
import ru.santurov.accountingcrud.models.Room;
import ru.santurov.accountingcrud.repositories.CorpusRepository;
import ru.santurov.accountingcrud.repositories.FloorRepository;
import ru.santurov.accountingcrud.repositories.RoomRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final CorpusRepository corpusRepository;
    private final FloorRepository floorRepository;

    public Page<Room> getRooms(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    public Room saveRoom(Room newRoom) {
        return roomRepository.save(newRoom);
    }

    public Room toNormal(RoomDTO room) {
        Optional<Corpus> corpus = corpusRepository.findById(room.getCorps());
        Optional<Floor> floor = floorRepository.findById(room.getFloorNumber());
        Room newRoom = new Room();
        newRoom.setNumber(room.getNumber());
        newRoom.setName(room.getName());
        newRoom.setLength(room.getLength());
        newRoom.setWidth(room.getWidth());
        newRoom.setCorps(corpus.get());
        newRoom.setFloorNumber(floor.get());

        return newRoom;
    }
    public Room updateRoom(Long id, Room roomDetails) {
        return roomRepository.findById(id)
                .map(room -> {
                    room.setName(roomDetails.getName());
                    room.setNumber(room.getNumber());
                    room.setCorps(roomDetails.getCorps());
                    room.setLength(room.getLength());
                    room.setWidth(room.getWidth());
                    room.setFloorNumber(roomDetails.getFloorNumber());

                    return roomRepository.save(room);
                }).orElseThrow(() -> new ResourceNotFoundException("Room  not found with id: " + id));
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
