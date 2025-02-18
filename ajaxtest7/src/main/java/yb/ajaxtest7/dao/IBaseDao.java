package yb.ajaxtest7.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface IBaseDao {
    Connection getCon();
    void close(ResultSet resultSet, Statement statement, Connection connection);
}
