package ru.santurov.accountingcrud.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    public Corpus updateCorpus(long id, Corpus corpusDetails) {
        return corpusRepository.findById(id)
                .map(corpus -> {
                    corpus.setName(corpusDetails.getName());
                    corpus.setLocation(corpusDetails.getLocation());
                    corpus.setParentFaculty(corpusDetails.getParentFaculty());

                    return corpusRepository.save(corpus);
                }).orElseThrow(() -> new ResourceNotFoundException("Department not found with id" + id));
    }

    public Corpus createCorpus(Corpus newCorpus) {
        return  corpusRepository.save(newCorpus);
    }


    public void deleteCorpus(long id) {
        corpusRepository.deleteById(id);
    }
}
