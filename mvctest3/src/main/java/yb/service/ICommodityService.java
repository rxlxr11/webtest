package yb.service;


import yb.pojo.Commodity;
import yb.pojo.Condition;

import java.util.HashMap;
import java.util.List;

public interface ICommodityService {
    HashMap<String, Object> queryPage(Integer curPage, Condition condition);
}
