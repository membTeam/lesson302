package ru.hogwarts.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;

import static ru.hogwarts.school.exception.RunErrBadRequestException.runException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private HashMap<Long, Student> hashMap;

    public void init(HashMap<Long, Student> hashMap) {
        if (this.hashMap == null) {
            this.hashMap = hashMap;
        }
    }

    public Student add(Faculty item) {
        runException("the method is not completed");
        return null;
    }

    public Student read(Long id) {
        runException("the method is not completed");
        return null;
    }

    public Student update(Faculty item) {
        runException("the method is not completed");
        return null;
    }

    public Student delete(Long id) {
        runException("the method is not completed");
        return null;
    }

}
