package ru.santurov.accountingcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.santurov.accountingcrud.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
