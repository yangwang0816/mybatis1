package com.kgc.grade.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.grade.dao.StudentsMapper;
import com.kgc.grade.domain.StudentCondition;
import com.kgc.grade.domain.Students;
import com.kgc.grade.domain.StudentsExample;
import com.kgc.grade.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentsMapper studentsMapper;
    public List<Students> selectAll() {
        return this.studentsMapper.selectByExample(new StudentsExample());
    }

    public int add(Students students) {
        return this.studentsMapper.insertSelective(students);
    }

    public int delete(int xh) {
        return this.studentsMapper.deleteByPrimaryKey(xh);
    }

    public int update(Students students) {
        return this.studentsMapper.updateByPrimaryKey(students);
    }

    public Students getOne(int xh) {
        return this.studentsMapper.selectByPrimaryKey(xh);
    }

    public PageInfo<Students> studentTOPage(Integer curPage, Integer pageSize) {
        PageHelper.startPage(curPage,pageSize);

        StudentsExample studentsExample = new StudentsExample();
        List<Students> list=this.studentsMapper.selectByExample(studentsExample);
        PageInfo<Students> studentsPageInfo = new PageInfo<>(list);

        return studentsPageInfo;
    }

    @Override
    public PageInfo<Students> getStudentByCondition(StudentCondition studentCondition) {
        PageHelper.startPage(studentCondition.getPage(),studentCondition.getPageSize());
        //2.利用selectByExample实现条件查询 或者 自己编写持久化方法
        StudentsExample studentsExample=new StudentsExample();
        //添加条件
        StudentsExample.Criteria criteria =studentsExample.createCriteria();
        if(studentCondition.getName()!=null){
            criteria.andNameLike("%"+studentCondition.getName()+"%");
        }
        if(studentCondition.getStartAge()!=null) //
        {
            criteria.andAgeGreaterThan(studentCondition.getStartAge());
        }
        if(studentCondition.getEndAge()!=null) //
        {
            criteria.andAgeLessThan(studentCondition.getEndAge());
        }
        List<Students> list=this.studentsMapper.selectByExample(studentsExample);
        return new PageInfo<Students>(list); //获取分页信息

    }
}
