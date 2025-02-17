package yb.jsptest4.servlet;

import yb.jsptest4.dao.impl.FlowerDaoImpl;
import yb.jsptest4.pojo.Flower;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryAll", urlPatterns = "/queryAll")
public class QueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        FlowerDaoImpl flowerDao = new FlowerDaoImpl();
        ArrayList<Flower> flowers = flowerDao.queryALl();
        request.setAttribute("flowers",flowers);
        request.getRequestDispatcher("/WEB-INF/flowerList.jsp").forward(request,response);
    }
}