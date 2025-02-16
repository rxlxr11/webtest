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

        connection = getConnection();
        try {
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
}
