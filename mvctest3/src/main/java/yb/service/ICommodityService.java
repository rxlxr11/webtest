package yb.service;


import yb.pojo.Commodity;
import yb.pojo.Condition;

import java.util.HashMap;
import java.util.List;

public interface ICommodityService {
    HashMap<String, Object> queryPage(Integer curPage, Condition condition);
    int addCommodity(Commodity commodity);
    List<Commodity> queryByName(String name);
    int deleteById(Integer id);
    Commodity queryById(Integer id);
    int updateById(Commodity commodity);
}
