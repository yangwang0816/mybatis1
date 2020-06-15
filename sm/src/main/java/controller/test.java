package controller;

import domain.Students;
import service.StudentService;
import service.impl.StudentServiceDao;

import java.io.IOException;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        StudentService studentService=new StudentServiceDao();
        List<Students> list = studentService.selectAll();
        list.forEach(students -> {
            System.out.println(students);
        });
    }
}
