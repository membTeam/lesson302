package ru.hogwarts.school.utils;

import ru.hogwarts.school.exception.ErrBadRequestException;
import ru.hogwarts.school.exception.RunErrBadRequestException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadDataFromFile {

    public static List<Student> loadListStudents() {
        List<Student> result = new ArrayList<>();

        var path = Path.of("txtData/student.txt");

        try (var scanner = new Scanner(path)) {
            String pattern = "--(.+)\\s+--(\\d+)\\s+--(\\w+)";
            Pattern r = Pattern.compile(pattern);
            Long id = 1L;

            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                if (line.startsWith("#")) {
                    continue;
                }

                Matcher matcher = r.matcher(line);
                if (matcher.find()) {
                    Student student = new Student();
                    student.setId(id++);
                    student.setName(matcher.group(1).trim());
                    student.setAge(Integer.parseInt(matcher.group(2).trim()));
                    student.setFaculty(matcher.group(3).trim());

                    result.add(student);

                } else {
                    throw new ErrBadRequestException("Ошибка чтения строки");
                }
            }
        } catch (IOException ex) {
            throw new ErrBadRequestException("Ошибка загрузки данных из файла student.txt");
        }

        return result;
    }

    public static List<Faculty> loadListFaculties() {
        List<Faculty> result = new ArrayList<>();
        var path = Path.of("txtData/faculty.txt");

        try (var scanner = new Scanner(path)) {
            String pattern = "--(\\w+)\\s+--(\\w+)";
            Pattern r = Pattern.compile(pattern);
            Long id = 1L;
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                if (line.startsWith("#")) {
                    continue;
                }

                Matcher matcher = r.matcher(line);
                if (matcher.find()) {
                    Faculty faculty = new Faculty();

                    faculty.setId(id++);
                    faculty.setName(matcher.group(1).trim());
                    faculty.setColor(matcher.group(2).trim());

                    result.add(faculty);

                } else {
                    throw new ErrBadRequestException("Ошибка чтения строки из файла faculty");
                }
            }
        } catch (IOException ex) {
            throw new ErrBadRequestException("Ошибка загрузки данных из файла faculty.txt");
        }
        return result;
    }

}
