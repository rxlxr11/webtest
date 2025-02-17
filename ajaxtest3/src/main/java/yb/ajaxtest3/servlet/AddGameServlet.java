package yb.ajaxtest3.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest3.dao.impl.GamesDaoImpl;
import yb.ajaxtest3.pojo.Games;

import java.io.BufferedReader;

@javax.servlet.annotation.WebServlet(name = "addGame", urlPatterns = "/addGame")
public class AddGameServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        BufferedReader reader = request.getReader();
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();

        while ((line=reader.readLine())!=null){
            stringBuffer.append(line);
        }

        Games games = JSONObject.parseObject(stringBuffer.toString(), Games.class);
        GamesDaoImpl gamesDao = new GamesDaoImpl();
        Integer i = gamesDao.addOne(games);
        response.getWriter().print(i>0?"success":"fail");
    }
}