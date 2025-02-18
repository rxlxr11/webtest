package yb.jsptest6.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface IBaseDao {
    Connection getConnection();
    void close(ResultSet resultSet, Statement statement ,Connection connection);
}
