package ru.hogwarts.school.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hogwarts.school.exception.ErrBadRequestException;
import ru.hogwarts.school.model.Student;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void add() {
        var student = new Student();
        student.setFaculty("Gryffindor");
        student.setName("nameStudent");
        student.setAge(18);

        var res = studentService.add(student);

        assertNotNull(res);
    }

    @Test
    public void add_withErr() {
        var student = new Student();
        student.setFaculty("Gryffind");
        student.setName("nameStudent");
        student.setAge(18);

        assertThrows(ErrBadRequestException.class, ()-> studentService.add(student) );

    }

    @Test
    public void read() {
        var res = studentService.read(10L);

        assertNotNull(res);
    }

    @Test
    public void read_withErr() {
        assertThrows(ErrBadRequestException.class, ()-> studentService.read(100L));

    }

    @Test
    public void update() {

        var student = studentService.read(3L);
        student.setName("modifyName");

        var res = studentService.update(student);

        assertEquals("modifyName", res.getName());

    }

    @Test
    public void update_withErr() {

        var student = studentService.read(2L);
        student.setFaculty("any");

        assertThrows(ErrBadRequestException.class, ()-> studentService.update(student));

    }

    @Test
    public void delete() {
        var res = studentService.delete(1L);

        assertNotNull(res);
        assertThrows(ErrBadRequestException.class, ()-> studentService.read(1l));

    }

}
