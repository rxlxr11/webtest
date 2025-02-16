package yb.jsptest3.dao;

import yb.jsptest3.pojo.Games;

import java.util.ArrayList;

public interface IGamesDao extends IBaseDao{
    ArrayList<Games> queryByCondition(Games game);
    Integer addOne(Games game);
}
