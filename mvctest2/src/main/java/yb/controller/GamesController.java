package yb.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yb.pojo.Games;
import yb.service.IGamesService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GamesController {
    @Autowired
    private IGamesService gamesService;

    @RequestMapping("setCondition")
    public String setCondition(@RequestBody Games game, HttpSession session){
        String jsonString = JSONObject.toJSONString(game);
        session.setAttribute("gameCondition", jsonString);
        return "success";
    }

    @RequestMapping("queryByCondition")
    public List<Games> queryByCondition(@RequestBody Games game){
        return gamesService.queryByCondition(game);

    }

    @RequestMapping("queryByName")
    public String queryByName(@RequestParam("name") String name){
        return gamesService.queryByName(name)>0?"no":"yes";

    }

    @RequestMapping("addGame")
    public String addGame(@RequestBody Games game){
        return gamesService.addGame(game)>0?"success":"fail";

    }
}
