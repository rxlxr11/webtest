package yb.jsptest3.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.jsptest3.dao.impl.GamesDaoImpl;
import yb.jsptest3.pojo.Games;

import java.io.BufferedReader;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryByCondition", urlPatterns = "/queryByCondition")
public class QueryByConditionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String gameName = request.getParameter("gameName");
        String gameType = request.getParameter("gameType");
        String gameCompany = request.getParameter("gameCompany");
        String gameYearStr = request.getParameter("gameYear");

        Integer gameYear = null;
        if (gameYearStr!=null){
            gameYear = Integer.valueOf(gameYearStr);
        }

        Games game = new Games(0l, gameName, gameType, gameCompany, gameYear);

        GamesDaoImpl gamesDao = new GamesDaoImpl();
        ArrayList<Games> games = gamesDao.queryByCondition(game);

        request.setAttribute("games",games);
        request.getRequestDispatcher("/WEB-INF/gameList.jsp").forward(request,response);


    }
}