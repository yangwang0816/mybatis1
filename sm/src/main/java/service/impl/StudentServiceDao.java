package service.impl;

import dao.StudentsMapper;
import domain.Students;
import domain.StudentsExample;
import service.StudentService;
import utils.MyBatisUtil;


import java.io.IOException;
import java.util.List;

public class StudentServiceDao implements StudentService {

    @Override
    public List<Students> selectAll() throws IOException {

            org.apache.ibatis.session.SqlSession sqlSession = MyBatisUtil.getSession();
            StudentsMapper studentsMapper = sqlSession.getMapper(StudentsMapper.class);
            List<Students> list = studentsMapper.selectByExample(new StudentsExample());
            return list;

    }

    @Override
    public int addStudent(Students students) {
        org.apache.ibatis.session.SqlSession sqlSession = null;
            sqlSession = MyBatisUtil.getSession();
        StudentsMapper studentsMapper = sqlSession.getMapper(StudentsMapper.class);
        int selective = studentsMapper.insertSelective(students);
        sqlSession.commit();
        return selective;
    }
}
