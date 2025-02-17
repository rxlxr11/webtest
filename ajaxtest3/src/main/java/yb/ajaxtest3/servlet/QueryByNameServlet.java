package yb.ajaxtest3.servlet;

import yb.ajaxtest3.dao.impl.GamesDaoImpl;
import yb.ajaxtest3.pojo.Games;

import java.io.PrintWriter;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryByName", urlPatterns = "/queryByName")
public class QueryByNameServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String name = request.getParameter("gameName");
        GamesDaoImpl gamesDao = new GamesDaoImpl();
        ArrayList<Games> games = gamesDao.queryByName(name);
        PrintWriter writer = response.getWriter();
        if (games.size()>0){
            writer.print("no");
        }else {
            writer.print("yes");
        }
    }
}