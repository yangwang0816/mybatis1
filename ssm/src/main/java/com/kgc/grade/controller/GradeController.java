package com.kgc.grade.controller;

import com.kgc.grade.domain.Grade;
import com.kgc.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @RequestMapping("/showGrade")
    public String showGrade(Model model){
        List<Grade> gradeList = gradeService.selectGrade();
        model.addAttribute("gradeList",gradeList);
        return "add";
    }

}
