package yb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yb.pojo.Condition;
import yb.pojo.User;
import yb.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestBody User user, HttpSession session){
        List<User> users = userService.queryByNameAndPwd(user);
        int size = users.size();
        if (size > 0){
            Condition condition = new Condition();
            session.setAttribute("user" ,users.get(0));
            session.setAttribute("condition",condition);
        }
        return size>0?"success":"fail";
    }
}
