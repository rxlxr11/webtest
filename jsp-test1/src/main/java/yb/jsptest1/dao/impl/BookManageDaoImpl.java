package yb.jsptest1.dao.impl;

import yb.jsptest1.dao.IBookManageDao;
import yb.jsptest1.pojo.BookManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BookManageDaoImpl extends BaseDaoImpl implements IBookManageDao {
    @Override
    public ArrayList<BookManage> queryAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<BookManage> bookManages = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from bookmanage");
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                BookManage bookManage = new BookManage();
                bookManage.setId(resultSet.getInt("id"));
                bookManage.setName(resultSet.getString("name"));
                bookManage.setAuthor(resultSet.getString("author"));
                bookManage.setTime(resultSet.getObject("time", Date.class));
                bookManage.setType(resultSet.getInt("type"));

                bookManages.add(bookManage);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookManages;
    }

    @Override
    public Integer deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);

        try {
            connection = getConnection();
            statement = connection.prepareStatement("delete from bookmanage where id = ?");
            statement.setInt(1, id);
            i = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public Integer addOne(BookManage bookManage) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);

        try {
            connection = getConnection();
            statement = connection.prepareStatement("insert into bookmanage values(default,?,?,?,?)");
            statement.setString(1, bookManage.getName());
            statement.setString(2, bookManage.getAuthor());
            statement.setObject(3, bookManage.getTime());
            statement.setInt(4, bookManage.getType());
            i = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }
}
