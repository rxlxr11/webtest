package yb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {


    @RequestMapping("toCommodityList")
    public String toCommodityList(){ return "commodity/commodityList";}

    @RequestMapping("toAddCommodity")
    public String toAddCommodity(){ return "commodity/addCommodity";}

    @RequestMapping("toUpdateCommodity")
    public String toUpdateCommodity(){ return "commodity/updateCommodity";}

    @RequestMapping("toAddType")
    public String toAddType(){ return "type/addType";}
}
