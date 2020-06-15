package com.kgc.grade.service;


import com.github.pagehelper.PageInfo;
import com.kgc.grade.domain.StudentCondition;
import com.kgc.grade.domain.Students;


import java.util.List;

public interface StudentService {
    List<Students> selectAll();

    int add(Students students);

    int delete(int xh);

    int update(Students students);

    Students getOne(int xh);

    PageInfo<Students> studentTOPage(Integer curPage,Integer pageSize);

    PageInfo<Students> getStudentByCondition(StudentCondition studentCondition);
}
