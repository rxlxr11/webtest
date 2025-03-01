package yb.mapper;

import org.apache.ibatis.annotations.Param;
import yb.pojo.Commodity;
import yb.pojo.Condition;

import java.util.List;

public interface CommodityMapper {
    List<Commodity> queryPage(@Param("offSet") Integer offSet,@Param("condition") Condition condition);
    int queryCommodityCountInt();
}
