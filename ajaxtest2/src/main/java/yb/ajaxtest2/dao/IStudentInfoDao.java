package yb.ajaxtest2.dao;

import yb.ajaxtest2.pojo.StudentInfo;

import java.util.ArrayList;

public interface IStudentInfoDao extends IBaseDao {
    ArrayList<StudentInfo> queryAll();
    Integer deleteById(Integer id);
    StudentInfo queryById(Integer id);
    Integer updateById(StudentInfo stu);
}
