package ru.hogwarts.school.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.utils.LoadDataFromFile;

import java.util.HashMap;

@Configuration
public class SchoolLoadData implements CommandLineRunner {

    private FacultyService facultyService;
    private StudentService studentService;

    public SchoolLoadData(FacultyService facultyService, StudentService studentService) {
        this.facultyService = facultyService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        var loadFaculty = LoadDataFromFile.loadListFaculties();
        HashMap<Long, Faculty> hashMapFaculty = new HashMap<>();
        loadFaculty.stream().forEach(faculty -> hashMapFaculty.put(faculty.getId(), faculty));
        facultyService.init(hashMapFaculty);

        var loadStudent = LoadDataFromFile.loadListStudents();
        HashMap<Long, Student> hashMapStudent = new HashMap<>();
        loadStudent.stream().forEach(student -> hashMapStudent.put(student.getId(), student));
        studentService.init(hashMapStudent);

    }
}
