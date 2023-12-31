package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ErrBadRequestException;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.stream.Collectors;

import static ru.hogwarts.school.exception.RunErrBadRequestException.runException;

@Service
public class StudentService {
    private HashMap<Long, Student> hashMap;

    private FacultyService facultyService;

    public StudentService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public void init(HashMap<Long, Student> hashMap) {
        if (this.hashMap == null) {
            this.hashMap = hashMap;
        }
    }

    private Long getMaxId() {
        return hashMap.keySet().stream()
                .max(Long::compare)
                .orElseThrow(()-> {
                    throw new ErrBadRequestException("Нет данных в hashMap");});
    }

    private boolean isExists(Student item) {
        return hashMap.values().stream()
                .filter(student -> student.getName().equals(item))
                .findFirst().isPresent();
    }

    private void checkData(Student item) {
        String strErr = "";

        if (item.getAge() == 0 || item.getAge() < 17 || item.getAge() > 25) {
            strErr = "Возраст д/быть больше 17 и меньше 25";
        }

        if (item.getName() == null || item.getName().isBlank()) {
            var s = "Нет данных по имени";
            strErr = strErr.isBlank() ? s : " " + s;
        }

        if (item.getFaculty() == null
                || item.getFaculty().isBlank()
                || !facultyService.isExists(item.getFaculty()) ) {

            var s = "Нет данных по факультету";
            strErr = strErr.isBlank() ? s : " " + s;
        }

        if (!strErr.isBlank()) {
            runException(strErr);
        }
    }

    public Iterable<Student> age(Integer age) {
        return hashMap.values().stream()
                .filter(student-> student.getAge() == age)
                .collect(Collectors.toList());
    }

    public Student add(Student item) {

        checkData(item);

        if (isExists(item)) {
            runException("Повторный ввод данных");
        }

        item.setId(getMaxId() + 1);
        hashMap.put(item.getId(), item);

        return item;
    }

    public Student read(Long id) {
        if (!hashMap.containsKey(id)) {
            runException("Нет данных по id " + id);
        }

        return hashMap.get(id);
    }

    public Student update(Student item) {
        if (!hashMap.containsKey(item.getId())) {
            runException("Нет данных");
        }

        checkData(item);

        hashMap.put(item.getId(), item);
        return item;
    }

    public Student delete(Long id) {
        var item = hashMap.get(id);
        if (item == null) {
            runException("Нет данных");
        }

        hashMap.remove(id);
        return item;
    }

}
