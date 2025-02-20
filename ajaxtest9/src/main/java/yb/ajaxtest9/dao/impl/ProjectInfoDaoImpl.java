package yb.ajaxtest9.dao.impl;

import yb.ajaxtest9.dao.IProjectInfoDao;
import yb.ajaxtest9.pojo.ProjectInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectInfoDaoImpl extends BaseDaoImpl implements IProjectInfoDao {
    @Override
    public ArrayList<ProjectInfo> queryPage(Integer curPage) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<ProjectInfo> projectInfos = new ArrayList<>();

        int i = (curPage-1)*3;

        try {
            connection = getCon();
            statement = connection.prepareStatement("select * from projectinfo limit ?,3");
            statement.setInt(1,i);

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                ProjectInfo projectInfo = new ProjectInfo();
                projectInfo.setId(resultSet.getInt("id"));
                projectInfo.setStartDate(resultSet.getDate("startDate"));
                projectInfo.setEndDate(resultSet.getDate("endDate"));
                projectInfo.setProjectName(resultSet.getString("projectName"));
                projectInfo.setStatus(resultSet.getInt("status"));

                projectInfos.add(projectInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return projectInfos;

    }

    @Override
    public ArrayList<ProjectInfo> queryByStatus(Integer status,Integer curPage) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<ProjectInfo> projectInfos = new ArrayList<>();
        int i = (curPage-1)*3;

        try {
            connection = getCon();
            if (status==-1){
                projectInfos = queryPage(curPage);
            }else {
                statement = connection.prepareStatement("select * from projectinfo where status=? limit ?,3");
                statement.setInt(1,status);
                statement.setInt(2,i);



            resultSet = statement.executeQuery();

            while (resultSet.next()){
                ProjectInfo projectInfo = new ProjectInfo();
                projectInfo.setId(resultSet.getInt("id"));
                projectInfo.setStartDate(resultSet.getDate("startDate"));
                projectInfo.setEndDate(resultSet.getDate("endDate"));
                projectInfo.setProjectName(resultSet.getString("projectName"));
                projectInfo.setStatus(resultSet.getInt("status"));

                projectInfos.add(projectInfo);
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return projectInfos;
    }

    @Override
    public Integer updateById(ProjectInfo projectInfo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Integer i = new Integer(0);

        try {
            connection = getCon();
            statement = connection.prepareStatement("update projectinfo set status=? where id=?");
            statement.setInt(1,projectInfo.getStatus());
            statement.setInt(2,projectInfo.getId());

            i = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return i;
    }

    @Override
    public ProjectInfo queryById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ProjectInfo projectInfo = new ProjectInfo();


        try {
            connection = getCon();
            statement = connection.prepareStatement("select * from projectinfo where id=?");
            statement.setInt(1,id);

            resultSet = statement.executeQuery();

            resultSet.next();

                projectInfo.setId(resultSet.getInt("id"));
                projectInfo.setStartDate(resultSet.getDate("startDate"));
                projectInfo.setEndDate(resultSet.getDate("endDate"));
                projectInfo.setProjectName(resultSet.getString("projectName"));
                projectInfo.setStatus(resultSet.getInt("status"));



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return projectInfo;
    }

    @Override
    public Integer queryProjectCount(Integer status) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Integer i = new Integer(0);

        try {
            connection = getCon();
            if (status==-1){

                statement = connection.prepareStatement("select count(id) from projectinfo ");

            }else {

                statement = connection.prepareStatement("select count(id) from projectinfo where status=?");
                statement.setInt(1,status);
                resultSet = statement.executeQuery();
            }

            resultSet = statement.executeQuery();

            resultSet.next();
            i = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return i;
    }
}
