package ru.hogwarts.school.service;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;

@Component
public class StudentService {
    private HashMap<Long, Student> studentHashMap;
}
