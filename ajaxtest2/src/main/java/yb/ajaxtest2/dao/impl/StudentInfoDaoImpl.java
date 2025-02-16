package yb.ajaxtest2.dao.impl;

import yb.ajaxtest2.dao.IStudentInfoDao;
import yb.ajaxtest2.pojo.StudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentInfoDaoImpl extends BaseDaoImpl implements IStudentInfoDao {
    @Override
    public ArrayList<StudentInfo> queryAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<StudentInfo> studentInfos = new ArrayList<>();


        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from studentInfo");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                StudentInfo studentInfo = new StudentInfo();
                studentInfo.setsId(resultSet.getInt("sid"));
                studentInfo.setsName(resultSet.getString("sname"));
                studentInfo.setsGender(resultSet.getString("sgender"));
                studentInfo.setsAge(resultSet.getInt("sage"));
                studentInfo.setsAddress(resultSet.getString("saddress"));
                studentInfo.setsEmail(resultSet.getString("semail"));

                studentInfos.add(studentInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return studentInfos;
    }

    @Override
    public Integer deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Integer i = new Integer(0);


        try {
            connection = getConnection();
            statement = connection.prepareStatement("delete from studentInfo where sid=?");
            statement.setInt(1,id);
            i = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return i;
    }

    @Override
    public StudentInfo queryById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StudentInfo studentInfo = new StudentInfo();


        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from studentInfo where sid=?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){

                studentInfo.setsId(resultSet.getInt("sid"));
                studentInfo.setsName(resultSet.getString("sname"));
                studentInfo.setsGender(resultSet.getString("sgender"));
                studentInfo.setsAge(resultSet.getInt("sage"));
                studentInfo.setsAddress(resultSet.getString("saddress"));
                studentInfo.setsEmail(resultSet.getString("semail"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return studentInfo;
    }

    @Override
    public Integer updateById(StudentInfo stu) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Integer i = new Integer(0);


        try {
            connection = getConnection();
            statement = connection.prepareStatement("update studentInfo  set sname=?,sgender=?,sage=?,saddress=?,semail=? where sid=?");
            statement.setString(1,stu.getsName());
            statement.setString(2,stu.getsGender());
            statement.setInt(3,stu.getsAge());
            statement.setString(4,stu.getsAddress());
            statement.setString(5,stu.getsEmail());
            statement.setInt(6,stu.getsId());
            i = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return i;
    }
}
