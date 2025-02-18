package yb.ajaxtest7.dao.impl;

import yb.ajaxtest7.dao.IBranchesDao;
import yb.ajaxtest7.pojo.Branches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BranchesDaoImpl extends BaseDaoImpl implements IBranchesDao {
    @Override
    public ArrayList<Branches> queryAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Branches> branches = new ArrayList<>();


        try {
            connection = getCon();
            statement = connection.prepareStatement("select * from branches");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Branches branch = new Branches();
                branch.setId(resultSet.getInt("id"));
                branch.setBusinessNo(resultSet.getString("businessNo"));
                branch.setName(resultSet.getString("name"));
                branch.setCityArea(resultSet.getString("cityArea"));
                branch.setAddress(resultSet.getString("address"));
                branch.setBranchTelephone(resultSet.getString("telephone"));
                branch.setBranchSummary(resultSet.getString("summary"));

                branches.add(branch);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branches;
    }

    @Override
    public Branches queryById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Branches branch = new Branches();


        try {
            connection = getCon();
            statement = connection.prepareStatement("select * from branches where id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            resultSet.next();

            branch.setId(resultSet.getInt("id"));
            branch.setBusinessNo(resultSet.getString("businessNo"));
            branch.setName(resultSet.getString("name"));
            branch.setCityArea(resultSet.getString("cityArea"));
            branch.setAddress(resultSet.getString("address"));
            branch.setBranchTelephone(resultSet.getString("telephone"));
            branch.setBranchSummary(resultSet.getString("summary"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branch;
    }

    @Override
    public ArrayList<Branches> queryByBusinessNo(String businessNo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Branches> branches = new ArrayList<>();


        try {
            connection = getCon();
            statement = connection.prepareStatement("select * from branches where businessno=?");
            statement.setString(1, businessNo);
            resultSet = statement.executeQuery();

            resultSet.next();
            while (resultSet.next()){
                Branches branch = new Branches();
                branch.setId(resultSet.getInt("id"));
                branch.setBusinessNo(resultSet.getString("businessNo"));
                branch.setName(resultSet.getString("name"));
                branch.setCityArea(resultSet.getString("cityArea"));
                branch.setAddress(resultSet.getString("address"));
                branch.setBranchTelephone(resultSet.getString("telephone"));
                branch.setBranchSummary(resultSet.getString("summary"));

                branches.add(branch);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branches;
    }

    @Override
    public Integer addOne(Branches branches) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);


        try {
            connection = getCon();
            statement = connection.prepareStatement("insert into branches values (default,?,?,?,?,?,?)");
            statement.setString(1, branches.getBusinessNo());
            statement.setString(2, branches.getName());
            statement.setString(3, branches.getCityArea());
            statement.setString(4, branches.getAddress());
            statement.setString(5, branches.getBranchTelephone());
            statement.setString(6, branches.getBranchSummary());
            i = statement.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
