package yb.ajaxtest3.dao;

import yb.ajaxtest3.pojo.Games;

import java.util.ArrayList;

public interface IGamesDao extends IBaseDao{
    ArrayList<Games> queryByCondition(Games game);
    Integer addOne(Games game);
    ArrayList<String> queryAllName();
    Games queryByName(String gameName);
}
