package yb.ajaxtest3.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest3.dao.impl.GamesDaoImpl;
import yb.ajaxtest3.pojo.Games;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryByCondition", urlPatterns = "/queryByCondition")
public class QueryByConditionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        BufferedReader reader = request.getReader();
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        System.out.println("sb"+stringBuilder);

        Games game = JSONObject.parseObject(stringBuilder.toString(), Games.class);
        System.out.println(game);

        GamesDaoImpl gamesDao = new GamesDaoImpl();
        ArrayList<Games> games = gamesDao.queryByCondition(game);
        System.out.println(games);
        response.getWriter().write(JSONObject.toJSONString(games));


    }
}