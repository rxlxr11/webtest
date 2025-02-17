package yb.jsptest4.servlet;

import yb.jsptest4.dao.impl.FlowerDaoImpl;
import yb.jsptest4.pojo.Flower;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "addFlower", urlPatterns = "/addFlower")
public class AddFlowerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String flowerName = request.getParameter("flowerName");
        String flowerNickName = request.getParameter("flowerNickName");
        String flowerProperty = request.getParameter("flowerProperty");
        String flowerPrice = request.getParameter("flowerPrice");
        String flowerProduction = request.getParameter("flowerProduction");

        Flower flower = new Flower(0,flowerName, flowerNickName, flowerProperty, new Float(flowerPrice), flowerProduction);

        FlowerDaoImpl flowerDao = new FlowerDaoImpl();
        ArrayList<Flower> flowers = flowerDao.queryByName(flowerName);
        if (flowers.size()>0){
            request.setAttribute("allowIf","no");
            request.getRequestDispatcher("/WEB-INF/addFlower.jsp").forward(request,response);

        }else {
            Integer i = flowerDao.addOne(flower);
            response.sendRedirect("queryAll");
        }


    }
}