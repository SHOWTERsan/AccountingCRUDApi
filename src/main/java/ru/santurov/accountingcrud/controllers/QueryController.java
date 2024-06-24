package ru.santurov.accountingcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/query")
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<List<Map<String, Object>>> executeQuery(@PathVariable("id") int id) {
        switch(id) {
            case 1:
                String sql2 = "SELECT number as Номер, room.name as Название, corpus.name as 'Название корпуса', length as Длина, width as Ширина, floor_number as Этаж FROM room JOIN corpus on room.corpus_id=corpus.id";
                List<Map<String, Object>> result2 = jdbcTemplate.queryForList(sql2);
                return ResponseEntity.ok(result2);
                //Высокий (7)
            case 2:
                String sql4 = "SELECT F.name as 'Название факультета', COUNT(C.id) AS 'Количество корпусов' FROM faculty AS F LEFT JOIN corpus AS C ON F.id = C.faculty_id GROUP BY F.name";
                List<Map<String, Object>> result4 = jdbcTemplate.queryForList(sql4);
                return ResponseEntity.ok(result4);
                //Низкий (4)
            case 3:
                String sql5 = "SELECT R.number as Номер, R.name as Название FROM room AS R INNER JOIN corpus AS C ON R.corpus_id = C.id WHERE C.name = 'Корпус А'";
                List<Map<String, Object>> result5 = jdbcTemplate.queryForList(sql5);
                return ResponseEntity.ok(result5);
                //Средний (5)
            case 4:
                String sql7 = "SELECT f.name AS 'Название факультета', (SELECT COUNT(*) FROM department WHERE faculty_id = f.id) AS 'Количество кафедр', (SELECT COUNT(*) FROM corpus WHERE faculty_id = f.id) AS 'Количество корпусов', (SELECT COUNT(*) FROM room WHERE corpus_id IN (SELECT id FROM corpus WHERE faculty_id = f.id)) AS 'Количество комнат' FROM faculty f";
                List<Map<String, Object>> result7 = jdbcTemplate.queryForList(sql7);
                return ResponseEntity.ok(result7);
                //Средний (5)
            case 5:
                String sql9 = "SELECT R.number as Номер, R.name as Название, R.floor_number as Этаж FROM room AS R WHERE R.floor_number IN (SELECT F.id FROM floor AS F WHERE F.height > 2.99)";
                List<Map<String, Object>> result9 = jdbcTemplate.queryForList(sql9);
                return ResponseEntity.ok(result9);
                //Средний (5)
            case 6:
                String sql10 = "SELECT c.name AS Название, CAST(SUM(r.width * r.length) AS DECIMAL(10,2)) AS 'Общая площадь' FROM room r INNER JOIN corpus c ON r.corpus_id = c.id GROUP BY c.name";
                List<Map<String, Object>> result10 = jdbcTemplate.queryForList(sql10);
                return ResponseEntity.ok(result10);
                //Средний (5)
            default:
                return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/7")
    public ResponseEntity updateSeven(@RequestBody Map<String, Integer> payload) {
        Integer roomNumber = payload.get("roomNumber");
        if (roomNumber != null) {
            String sql6 = "UPDATE room SET corpus_id = NULL WHERE number = ?";
            jdbcTemplate.update(sql6, roomNumber);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Room number is missing in the request body");
        }
    }
    //Средний (4)
    @PutMapping("/8")
    public ResponseEntity updateEight() {
        String sql1 = "UPDATE department SET faculty_id = 2 WHERE faculty_id = 1;";
        jdbcTemplate.update(sql1);
        return ResponseEntity.ok().build();
    }
    // низкий 3
}
