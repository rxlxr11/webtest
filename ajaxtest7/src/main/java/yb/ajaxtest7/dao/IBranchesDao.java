package yb.ajaxtest7.dao;

import yb.ajaxtest7.pojo.Branches;

import java.util.ArrayList;

public interface IBranchesDao extends IBaseDao{
    ArrayList<Branches> queryAll();
    Branches queryById(Integer id);
    ArrayList<Branches> queryByBusinessNo(String businessNo);
    Integer addOne(Branches branches);
}
