package yb.jsptest4.dao.impl;

import yb.jsptest4.dao.IFlowerDao;
import yb.jsptest4.pojo.Flower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlowerDaoImpl extends BaseDaoImpl implements IFlowerDao {
    @Override
    public ArrayList<Flower> queryALl() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Flower> flowers = new ArrayList<>();


        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from flower");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Flower flower = new Flower();
                flower.setId(resultSet.getInt("id"));
                flower.setName(resultSet.getString("name"));
                flower.setNickName(resultSet.getString("nickname"));
                flower.setProperty(resultSet.getString("property"));
                flower.setProduction(resultSet.getString("production"));
                flower.setPrice(resultSet.getFloat("price"));


                flowers.add(flower);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return flowers;
    }

    public Integer addOne(Flower flower) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);

        connection = getConnection();
        try {
            statement = connection.prepareStatement("insert into flower values (default,?,?,?,?,?)");
            statement.setString(1,flower.getName());
            statement.setString(2,flower.getNickName());
            statement.setString(3,flower.getProperty());

            statement.setFloat(4,flower.getPrice());
            statement.setString(5,flower.getProduction());

            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet,statement,connection);
        }
        return i;
    }

    @Override
    public ArrayList<Flower> queryByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Flower> flowers = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from flower where name=?");
            statement.setString(1,name);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Flower flower = new Flower();
                flower.setId(resultSet.getInt("id"));
                flower.setName(resultSet.getString("name"));
                flower.setNickName(resultSet.getString("nickname"));
                flower.setProperty(resultSet.getString("property"));
                flower.setProduction(resultSet.getString("production"));
                flower.setPrice(resultSet.getFloat("price"));


                flowers.add(flower);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(resultSet,statement,connection);
        }

        return flowers;
    }
}
