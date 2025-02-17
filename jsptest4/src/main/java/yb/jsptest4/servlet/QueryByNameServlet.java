package yb.jsptest4.servlet;

import yb.jsptest4.dao.impl.FlowerDaoImpl;
import yb.jsptest4.pojo.Flower;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryByName", urlPatterns = "/queryByName")
public class QueryByNameServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String name = request.getParameter("name");
        FlowerDaoImpl flowerDao = new FlowerDaoImpl();
        ArrayList<Flower> flowers = flowerDao.queryByName(name);
        request.setAttribute("allowIf", flowers.size());
    }
}