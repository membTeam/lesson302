package ru.hogwarts.school.service;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.exception.ErrBadRequestException;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Optional;

import static ru.hogwarts.school.exception.RunErrBadRequestException.runException;

@Component
public class FacultyService {
    private HashMap<Long, Faculty> facultyHashMap;

    // TODO: реализовать заполнение facultyHashMap
    public Faculty add(Faculty item) {
        runException("the method is not completed");
        return null;
    }

    public Faculty read(Long id) {
        runException("the method is not completed");
        return null;
    }

    public Faculty update(Faculty item) {
        runException("the method is not completed");
        return null;
    }

    public Faculty delete(Long id) {
        runException("the method is not completed");
        return null;
    }

}
