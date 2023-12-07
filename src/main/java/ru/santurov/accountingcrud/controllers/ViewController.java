package ru.santurov.accountingcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/views")
public class ViewController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<List<Map<String, Object>>> getView(@PathVariable("id") int id) {
        String viewName = "view" + id; // предполагается, что имена представлений в базе данных имеют вид "view1", "view2" и т.д.
        String sql = "SELECT * FROM " + viewName;
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return ResponseEntity.ok(result);
    }
}