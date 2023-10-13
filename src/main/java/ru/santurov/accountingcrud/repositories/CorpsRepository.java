package ru.santurov.accountingcrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.santurov.accountingcrud.models.Corps;

@RepositoryRestResource(path = "corps")
public interface CorpsRepository extends CrudRepository<Corps, Long> {

}
