package com.kgc.grade.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.grade.domain.Grade;
import com.kgc.grade.domain.StudentCondition;
import com.kgc.grade.domain.Students;
import com.kgc.grade.service.GradeService;
import com.kgc.grade.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentServices;
    @Autowired
    private GradeService gradeService;
   @RequestMapping("/showStudent")
    public String showStudent(Model model){
       List<Students> list = studentServices.selectAll();
       model.addAttribute("list",list);
       return "index";
    }
    @RequestMapping("/addStudent")
    public String addStudent(Students students){
        int add = studentServices.add(students);
        return "redirect:studentPage";
    }
    @RequestMapping("/delete")
    public String delete(int xh){
        int delete = studentServices.delete(xh);
        return "redirect:studentPage";
    }

    @RequestMapping("/getOne")
    public String getOne(Model model,int xh){
        Students s = studentServices.getOne(xh);
        model.addAttribute("s",s);

        List<Grade> gradeList = gradeService.selectGrade();
        model.addAttribute("gradeList",gradeList);
        return "update";
   }

    @RequestMapping("/updateStudent")
    public String updateStudent(Students students){
        int update = studentServices.update(students);
        return "redirect:studentPage";
    }

    @RequestMapping("/studentPage")
    public String studentPage(Integer page,Model model){
        if (page==null||page.equals("")){
            page=1;
        }
        PageInfo<Students> studentsPageInfo = studentServices.studentTOPage(page, 3);
        model.addAttribute("pageInfo",studentsPageInfo);
        return "index";
    }

    @RequestMapping("/searchStudent")
    public String searchStudent(StudentCondition studentCondition, Model model) {
        //调用业务
        PageInfo<Students> pageInfo = studentServices.getStudentByCondition(studentCondition);

        //填充分页信息到页面
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("condition", studentCondition);//回显
        return "index2";
    }
}
