package yb.jsptest6.dao.impl;

import yb.jsptest6.dao.IMembersInfoDao;
import yb.jsptest6.pojo.MembersInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MembersInfoDaoImpl extends BaseDaoImpl implements IMembersInfoDao {
    @Override
    public ArrayList<MembersInfo> queryAll() {
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<MembersInfo> membersInfos = new ArrayList<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from membersInfo");
            resultSet  = statement.executeQuery();

            while (resultSet.next()){
                MembersInfo membersInfo = new MembersInfo();
                membersInfo.setId(resultSet.getInt("id"));
                membersInfo.setmName(resultSet.getString("mname"));
                membersInfo.setmGender(resultSet.getString("mgender"));
                membersInfo.setmAge(resultSet.getInt("mAge"));
                membersInfo.setmAddress(resultSet.getString("maddress"));
                membersInfo.setmEmail(resultSet.getString("memail"));

                membersInfos.add(membersInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }
        return membersInfos;
    }

    @Override
    public MembersInfo queryById(Integer id) {
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        MembersInfo membersInfo = new MembersInfo();
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from membersInfo where id=?");
            statement.setInt(1,id);
            resultSet  = statement.executeQuery();

            resultSet.next();

                membersInfo.setId(resultSet.getInt("id"));
                membersInfo.setmName(resultSet.getString("mname"));
                membersInfo.setmGender(resultSet.getString("mgender"));
                membersInfo.setmAge(resultSet.getInt("mAge"));
                membersInfo.setmAddress(resultSet.getString("maddress"));
                membersInfo.setmEmail(resultSet.getString("memail"));



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }
        return membersInfo;
    }

    @Override
    public Integer updateById(MembersInfo m) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);

        try {
            connection = getConnection();
            statement = connection.prepareStatement("update membersInfo set mname=? , mage=?, mgender=?, maddress=?, memail=? where id=?");
            statement.setString(1,m.getmName());
            statement.setInt(2,m.getmAge());
            statement.setString(3,m.getmGender());
            statement.setString(4,m.getmAddress());
            statement.setString(5,m.getmEmail());
            statement.setInt(6,m.getId());
            i = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return i;
    }

    @Override
    public Integer deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer i = new Integer(0);

        try {
            connection = getConnection();
            statement = connection.prepareStatement("delete from membersInfo where id=?");
            statement.setInt(1,id);
            i = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }

        return i;
    }
}
