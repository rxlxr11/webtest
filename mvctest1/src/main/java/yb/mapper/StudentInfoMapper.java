package yb.mapper;

import org.apache.ibatis.annotations.Param;
import yb.pojo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public interface StudentInfoMapper {
    List<StudentInfo> queryAll();
    StudentInfo queryById(@Param("id") Integer id);
    int deleteById(@Param("id") Integer id);
    int updateById(StudentInfo studentInfo);
}
