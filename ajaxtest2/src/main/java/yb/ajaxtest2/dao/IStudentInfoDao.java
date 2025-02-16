package yb.ajaxtest2.dao;

import yb.ajaxtest2.pojo.StudentInfo;

import java.util.ArrayList;

public interface IStudentInfoDao extends IBaseDao {
    ArrayList<StudentInfo> queryAll();
}
