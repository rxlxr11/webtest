package yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yb.mapper.CommodityMapper;
import yb.pojo.Commodity;
import yb.pojo.Condition;
import yb.service.ICommodityService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class CommodityServiceImpl implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public HashMap<String, Object> queryPage(Integer curPage, Condition condition) {
        int offSet = (curPage-1)*5;
        List<Commodity> commodities = commodityMapper.queryPage(offSet, condition);

        int size = commodityMapper.queryCommodityCountInt();
        Integer totalPage = size%5==0?size/5:size/5+1;
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("curPage",curPage);
        stringObjectHashMap.put("totalPage",totalPage);
        stringObjectHashMap.put("commodities",commodities);

        return stringObjectHashMap;
    }
}
