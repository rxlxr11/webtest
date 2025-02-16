package yb.ajaxtest3.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest3.pojo.Games;

import java.io.BufferedReader;

@javax.servlet.annotation.WebServlet(name = "toQueryByCondition",urlPatterns = "/toQueryByCondition")
public class ToQueryByConditionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("WEB-INF/queryGame.jsp").forward(request,response);
    }
}