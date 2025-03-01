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
}
