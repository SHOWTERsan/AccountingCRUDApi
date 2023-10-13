package ru.santurov.accountingcrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.santurov.accountingcrud.models.Room;

@RepositoryRestResource( path = "rooms")
public interface RoomRepository extends CrudRepository<Room, Long> {
}
