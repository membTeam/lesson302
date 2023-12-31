package ru.hogwarts.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ErrBadRequestException;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.stream.Collectors;

import static ru.hogwarts.school.exception.RunErrBadRequestException.runException;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private HashMap<Long, Faculty> hashMap;

    public void init(HashMap<Long, Faculty> hashMap) {
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

    public boolean isExists(String item) {
        return hashMap.values().stream()
                .filter(faculty -> faculty.getName().equals(item))
                .findFirst().isPresent();
    }

    private boolean isExists(Faculty item) {
        return hashMap.values().stream()
                .filter(faculty -> faculty.getName().equals(item))
                .findFirst().isPresent();
    }

    public Faculty add(Faculty item) {

        if (isExists(item)) {
            runException("Повторный ввод данных");
        }

        item.setId(getMaxId() + 1);
        hashMap.put(item.getId(), item);

        return item;
    }

    public Faculty read(Long id) {
        if (!hashMap.containsKey(id)) {
            runException("Нет данных по id " + id);
        }

        return hashMap.get(id);
    }

    public Faculty update(Faculty item) {
        if (!hashMap.containsKey(item.getId())) {
            runException("Нет данных");
        }

        hashMap.put(item.getId(), item);
        return item;
    }

    public Faculty delete(Long id) {

        var item = hashMap.get(id);
        if (item == null) {
            runException("Нет данных");
        }

        hashMap.remove(id);
        return item;
    }

    public Iterable<Faculty> color(String color) {
        return hashMap.values()
                .stream()
                .filter(faculty-> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

    public Iterable<Faculty> all() {
        return hashMap.values()
                .stream()
                .collect(Collectors.toList());
    }

}
