package ru.santurov.accountingcrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.santurov.accountingcrud.models.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
