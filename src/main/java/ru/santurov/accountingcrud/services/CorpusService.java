package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.santurov.accountingcrud.models.Corpus;
import ru.santurov.accountingcrud.repositories.CorpusRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CorpusService {
    private final CorpusRepository corpusRepository;

    public List<Corpus> getCorps() {
        return StreamSupport.stream(corpusRepository.findAll().spliterator(),false).toList();
    }
}
