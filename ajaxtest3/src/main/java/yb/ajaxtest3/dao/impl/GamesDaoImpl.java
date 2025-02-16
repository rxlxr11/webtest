package yb.ajaxtest3.dao.impl;

import yb.ajaxtest3.dao.IGamesDao;
import yb.ajaxtest3.pojo.Games;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GamesDaoImpl extends BaseDaoImpl implements IGamesDao {
    @Override
    public ArrayList<Games> queryByCondition(Games game) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Games> games = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();


        try {
            connection = getConnection();
            String sql = new String("select * from games ");
            Boolean flag = false;
            StringBuffer stringBuffer = new StringBuffer();

            if (game.getGameName()!=null&&!game.getGameName().equals("")){
                flag = true;
                objects.add(game.getGameName());
                stringBuffer.append(" gamename like ? and ");
            }

            if (game.getGameType()!=null&&!game.getGameType().equals("")){
                flag = true;
                objects.add(game.getGameType());
                stringBuffer.append(" gametype=? and ");
            }

            if (game.getGameCompany()!=null&&!game.getGameCompany().equals("")){
                flag = true;
                objects.add(game.getGameCompany());
                stringBuffer.append(" gameCompany=? and ");
            }


            if (game.getGameYear()!=null){
                flag = true;
                objects.add(game.getGameYear());
                stringBuffer.append(" gameyear=? and ");
            }

            if (flag){
                String string = stringBuffer.toString();
                string = string.substring(0,string.length()-4);
                sql += " where "+string;
            }

            System.out.println(sql);
            statement = connection.prepareStatement(sql);

            for (int i = 0; i < objects.size(); i++) {
                statement.setObject(i+1,objects.get(i));
            }

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Games game1 = new Games();
                game1.setGameId(resultSet.getLong("gameId"));
                game1.setGameName(resultSet.getString("gameName"));
                game1.setGameType(resultSet.getString("gameType"));
                game1.setGameCompany(resultSet.getString("gameCompany"));
                game1.setGameYear(resultSet.getInt("gameYear"));

                games.add(game1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }


        return  games;
    }

    @Override
    public Integer addOne(Games game) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);

        connection = getConnection();
        try {
            statement = connection.prepareStatement("insert into games values (default,?,?,?,?)");
            statement.setString(1,"%"+game.getGameName()+"%");
            statement.setString(2,game.getGameType());
            statement.setString(3,game.getGameCompany());
            statement.setInt(4,game.getGameYear());

            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet,statement,connection);
        }
        return i;
    }

    @Override
    public ArrayList<String> queryAllName() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> strings = new ArrayList<>();

        connection = getConnection();
        try {
            statement = connection.prepareStatement("select gameName from games");
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                strings.add(resultSet.getString("gameName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet,statement,connection);
        }
        return strings;
    }

    @Override
    public Games queryByName(String gameName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Games games = new Games();

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from games where gameName=?");
            statement.setString(1,gameName);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                games.setGameCompany(resultSet.getString("gameCompany"));
                games.setGameYear(resultSet.getInt("gameYear"));
                games.setGameName(resultSet.getString("gameName"));
                games.setGameType(resultSet.getString("gameType"));
                games.setGameId(resultSet.getLong("gameId"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(resultSet,statement,connection);
        }

        return games;
    }
}
