package ru.santurov.accountingcrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.santurov.accountingcrud.models.Floor;

@Repository
public interface FloorRepository extends CrudRepository<Floor, Long> {
}
