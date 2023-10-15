package ru.santurov.accountingcrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.santurov.accountingcrud.models.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
}
