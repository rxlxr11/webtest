package yb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("toQueryByCondition")
    public String toQueryByCondition(){return "queryGame";}

    @RequestMapping("toGameList")
    public String toGameList(){return "gameList";}

    @RequestMapping("toAddGame")
    public String toAddGame(){return "addGame";}
}
