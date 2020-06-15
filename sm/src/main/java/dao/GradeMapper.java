package dao;

import domain.Grade;
import domain.GradeExample;
import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Short gid);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Short gid);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}