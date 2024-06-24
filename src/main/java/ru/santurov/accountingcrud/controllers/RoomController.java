package ru.santurov.accountingcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.santurov.accountingcrud.dto.RoomDTO;
import ru.santurov.accountingcrud.models.Room;
import ru.santurov.accountingcrud.services.RoomService;


@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<Page<Room>> getLimitRooms(@PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Room> page = roomService.getRooms(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
//Средний (5)
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody RoomDTO newRoom) {
        if (newRoom.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Room room = roomService.saveRoom(roomService.toNormal(newRoom));
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }
//Высокий (6)
    @PatchMapping("{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id, @RequestBody Room newRoom) {
        Room room = roomService.updateRoom(id, newRoom);
        if (room == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(room);
        }
    }
//Высокий (6)
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable(value = "id") Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
