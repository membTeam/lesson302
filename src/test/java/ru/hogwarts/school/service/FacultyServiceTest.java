package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hogwarts.school.exception.ErrBadRequestException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ru.hogwarts.school.model.Faculty;

@SpringBootTest
public class FacultyServiceTest {

    @Autowired
    private FacultyService facultyService;

    @Test
    public void add() {
        var faculty = new Faculty();
        faculty.setName("nameFaculty");
        faculty.setColor("color");

        var res = facultyService.add(faculty);

        assertNotNull(res);
    }

    @Test
    public void read() {
        var res = facultyService.read(1L);

        assertNotNull(res);
    }

    @Test
    public void read_withErr() {
        assertThrows(ErrBadRequestException.class, ()-> facultyService.read(100L));
    }

    @Test
    public void update() {

        var faculty = facultyService.read(3L);
        faculty.setName("modifyName");

        var res = facultyService.update(faculty);

        assertEquals("modifyName", res.getName());

    }

    @Test
    public void delete() {
        var res = facultyService.delete(2L);

        assertNotNull(res);
        assertThrows(ErrBadRequestException.class, ()-> facultyService.read(2l));

    }

}
