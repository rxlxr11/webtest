package yb.ajaxtest3.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest3.pojo.Games;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;

@javax.servlet.annotation.WebServlet(name = "setCondition", urlPatterns = "/setCondition")
public class SetConditionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        BufferedReader reader = request.getReader();
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        //Games game = JSONObject.parseObject(stringBuilder.toString(), Games.class);
        String string = stringBuilder.toString();
        System.out.println(string);
        HttpSession session = request.getSession();
        session.setAttribute("gameCondition", string);

    }
}