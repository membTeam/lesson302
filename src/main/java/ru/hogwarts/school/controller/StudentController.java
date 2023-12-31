package ru.hogwarts.school.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private StudentService studentServ;

    public StudentController(StudentService studentServ) {
        this.studentServ = studentServ;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> read(@PathVariable Long id) {
        return ResponseEntity.ok(studentServ.read(id));
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(studentServ.add(student));
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(studentServ.update(student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        return ResponseEntity.ok(studentServ.delete(id));
    }

    @GetMapping("/age/{age}")
    public Iterable<Student> age(@PathVariable Integer age) {
        return studentServ.age(age);
    }

}
