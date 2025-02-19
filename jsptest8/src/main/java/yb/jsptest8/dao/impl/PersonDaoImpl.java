package yb.jsptest8.dao.impl;

import yb.jsptest8.dao.IPersonDao;
import yb.jsptest8.pojo.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDaoImpl extends BaseDaoImpl implements IPersonDao {
    @Override
    public ArrayList<Person> queryAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Person> people = new ArrayList<>();


        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from person");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSex(resultSet.getString("sex"));
                person.setAge(resultSet.getInt("age"));
                person.setRank(resultSet.getString("rank"));
                person.setDepartment(resultSet.getString("department"));
                people.add(person);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return  people;
    }

    @Override
    public Integer addOne(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);


        try {
            connection = getConnection();
            statement = connection.prepareStatement("insert into person values (default,?,?,?,?,?)");
            statement.setInt(3,person.getAge());
            statement.setString(1,person.getName());
            statement.setString(2,person.getSex());
            statement.setString(4,person.getRank());
            statement.setString(5,person.getDepartment());

            i = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return  i;
    }

    @Override
    public Integer deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);


        try {
            connection = getConnection();
            statement = connection.prepareStatement("delete from person where id=?");
            statement.setInt(1,id);
            i = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return  i;
    }
}
