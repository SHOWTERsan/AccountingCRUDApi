package ru.santurov.accountingcrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.santurov.accountingcrud.models.Corpus;

@Repository
public interface CorpusRepository extends CrudRepository<Corpus, Long> {
}
