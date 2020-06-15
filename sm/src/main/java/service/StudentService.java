package service;

import domain.Students;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<Students> selectAll() throws IOException;

    int addStudent(Students students);
}
