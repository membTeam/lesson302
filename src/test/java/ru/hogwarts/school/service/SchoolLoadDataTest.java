package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hogwarts.school.configuration.SchoolLoadData;

@SpringBootTest
public class SchoolLoadDataTest {

    @Autowired
    private SchoolLoadData schoolLoadData;

    @Test
    public void LoadDataSchoolLoadData() {
        assertDoesNotThrow(()-> schoolLoadData.run(""));
    }

}
