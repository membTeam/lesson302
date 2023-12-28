package ru.hogwarts.school.utils;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LoadDataFromFileTest {

    @Test
    public void LoadStudentFromFile() {

        var res = LoadDataFromFile.loadListStudents();

        assertNotNull(res);
        assertInstanceOf(List.class, res );
        assertEquals(42, res.size());
    }

    @Test
    public void LoadFacultyFromFile() {

        var res = LoadDataFromFile.loadListFaculties();

        assertNotNull(res);
        assertInstanceOf(List.class, res );
        assertEquals(4, res.size());
    }
}
