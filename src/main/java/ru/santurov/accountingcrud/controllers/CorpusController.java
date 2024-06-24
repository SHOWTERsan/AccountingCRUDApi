package ru.santurov.accountingcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.santurov.accountingcrud.models.Corpus;
import ru.santurov.accountingcrud.services.CorpusService;

import java.util.List;

@RestController
@RequestMapping("/api/corps")
@RequiredArgsConstructor
public class CorpusController {
    private final CorpusService corpusService;

    @GetMapping("")
    public List<Corpus> getCorps() {
        return corpusService.getCorps();
    }
    // низкий 3
    @PatchMapping("{id}")
    public ResponseEntity<Corpus> updateCorpus(@PathVariable(name = "id") long id, @RequestBody Corpus corpusDetails) {
        Corpus corpus = corpusService.updateCorpus(id,corpusDetails);

        if (corpus == null) {
            return ResponseEntity.notFound().build();
        }
        else return ResponseEntity.ok(corpus);
    }
    // низкий 3

    @PostMapping()
    public ResponseEntity<Corpus> createCorpus(@RequestBody Corpus newCorpus) {
        if(newCorpus.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Corpus corpus = corpusService.createCorpus(newCorpus);
        return new ResponseEntity<>(corpus, HttpStatus.CREATED);
    }
    // низкий 3
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCorpus(@PathVariable(name = "id") long id) {
        corpusService.deleteCorpus(id);
        return ResponseEntity.noContent().build();
    }
 }