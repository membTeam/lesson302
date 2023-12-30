package ru.hogwarts.school.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculty")
public class FacultyController {

    private FacultyService facultyServ;

    @GetMapping("{id}")
    public ResponseEntity<Faculty> read(@PathVariable Long id) {
        return ResponseEntity.ok(facultyServ.read(id));
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyServ.add(faculty));
    }

    @PutMapping
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyServ.update(faculty));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> delete(@PathVariable Long id) {
        return ResponseEntity.ok(facultyServ.delete(id));
    }
}
