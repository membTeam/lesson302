package ru.hogwarts.school.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private FacultyService facultyServ;

    public FacultyController(FacultyService facultyServ) {
        this.facultyServ = facultyServ;
    }

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

    @GetMapping("color/{color}")
    public Iterable<Faculty> color(@PathVariable String color) {
        return facultyServ.color(color);
    }

    @GetMapping("all")
    public Iterable<Faculty> all() {
        return facultyServ.all();
    }

}
