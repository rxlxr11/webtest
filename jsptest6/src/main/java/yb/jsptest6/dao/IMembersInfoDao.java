package yb.jsptest6.dao;

import yb.jsptest6.pojo.MembersInfo;

import java.util.ArrayList;

public interface IMembersInfoDao extends IBaseDao {
    ArrayList<MembersInfo> queryAll();
    MembersInfo queryById(Integer id);
    Integer updateById(MembersInfo m);
    Integer deleteById(Integer id);
}
