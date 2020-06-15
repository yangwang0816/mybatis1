package com.kgc.grade.service.impl;

import com.kgc.grade.dao.GradeMapper;
import com.kgc.grade.domain.Grade;
import com.kgc.grade.domain.GradeExample;
import com.kgc.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    public List<Grade> selectGrade() {
        return this.gradeMapper.selectByExample(new GradeExample());
    }
}
