package yb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yb.pojo.Commodity;
import yb.pojo.Condition;
import yb.service.ICommodityService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("commodity")
public class CommodityController {
    @Autowired
    private ICommodityService commodityService;

    @RequestMapping("queryPage")
    public HashMap<String, Object> queryPage(@RequestParam("curPage") Integer curPage
                                    ,HttpSession session){

        Condition condition = (Condition) session.getAttribute("condition");

        return commodityService.queryPage(curPage, condition);
    }

    @RequestMapping("addCommodity")
    public String addCommodity(@RequestBody Commodity commodity){
        if (commodity==null)
            return "数据错误";
        return commodityService.addCommodity(commodity)>0?"success":"fail";
    }

    @RequestMapping("queryByName")
    public String queryByName(String name){
        if (name==null||name=="")
            return "no";
        return commodityService.queryByName(name).isEmpty()?"yes":"no";
    }

    @RequestMapping("deleteById")
    public String deleteById(Integer id){
        if (id==null)
            return "请求错误";
        return commodityService.deleteById(id)>0?"success":"fail";
    }

    @RequestMapping("queryById")
    public Commodity queryById(Integer id){
        return commodityService.queryById(id);
    }

    @RequestMapping("updateById")
    public String updateById(@RequestBody Commodity commodity){
        if (commodity==null)
            return "数据错误";
        return commodityService.updateById(commodity)>0?"success":"fail";
    }

}
