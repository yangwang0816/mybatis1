package dao;

import domain.Students;
import domain.StudentsExample;
import java.util.List;

public interface StudentsMapper {
    int deleteByPrimaryKey(Integer xh);

    int insert(Students record);

    int insertSelective(Students record);

    List<Students> selectByExample(StudentsExample example);

    Students selectByPrimaryKey(Integer xh);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);


}