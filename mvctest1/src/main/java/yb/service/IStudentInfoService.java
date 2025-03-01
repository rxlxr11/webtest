package yb.service;

import yb.pojo.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public interface IStudentInfoService {
    List<StudentInfo> queryAll();

    StudentInfo queryById(Integer id);
    int deleteById(Integer id);
    int updateById(StudentInfo studentInfo);
}
