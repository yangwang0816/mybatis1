package controller;

import domain.Students;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;
import service.impl.StudentServiceDao;

import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    StudentService studentService=new StudentServiceDao();
    @RequestMapping("/showStudent")
    public String showStudent(Model model) throws IOException {
        List<Students> list = studentService.selectAll();
        model.addAttribute("list",list);
        return "index";
    }
    @RequestMapping("/addStu")
    public String addStu(Students students) throws IOException {
        int i = studentService.addStudent(students);
        List<Students> list = studentService.selectAll();
        list.forEach(student -> {
            System.out.println(student);
        });
        if (i>0){
            return "redirect:showStudent";
        }else {
            return "addStu";
        }
    }

    @RequestMapping("/getStudent")
    @ResponseBody
    public List<Students> getStudent() throws IOException {
        List<Students> list = studentService.selectAll();
        return list;
    }
}
