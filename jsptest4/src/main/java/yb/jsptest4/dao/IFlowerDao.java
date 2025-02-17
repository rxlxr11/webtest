package yb.jsptest4.dao;

import yb.jsptest4.pojo.Flower;

import java.util.ArrayList;

public interface IFlowerDao extends IBaseDao {

    ArrayList<Flower> queryALl();
    Integer addOne(Flower flower);
    ArrayList<Flower> queryByName(String name);
}
