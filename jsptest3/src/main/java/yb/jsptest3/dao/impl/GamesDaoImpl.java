package yb.jsptest3.dao.impl;

import yb.jsptest3.dao.IGamesDao;
import yb.jsptest3.pojo.Games;

import java.sql.*;
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

            if (game.getGameName()!=null){
                flag = true;
                objects.add(game.getGameName());
                stringBuffer.append(" gamename like %?% and ");
            }

            if (game.getGameType()!=null){
                flag = true;
                objects.add(game.getGameType());
                stringBuffer.append(" gametype=? and ");
            }

            if (game.getGameCompany()!=null){
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
                string = string.substring(0,string.length()-3);
                sql += " where "+string;
            }

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
            statement.setString(1,game.getGameName());
            statement.setString(2,game.getGameType());
            statement.setString(3,game.getGameCompany());
            statement.setInt(4,game.getGameYear());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet,statement,connection);
        }
    }
}
