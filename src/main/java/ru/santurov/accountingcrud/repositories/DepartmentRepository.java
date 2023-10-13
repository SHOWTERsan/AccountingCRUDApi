package ru.santurov.accountingcrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.santurov.accountingcrud.models.Department;

@RepositoryRestResource(path = "departments")
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
