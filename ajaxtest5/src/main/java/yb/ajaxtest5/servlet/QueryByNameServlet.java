package yb.ajaxtest5.servlet;

import yb.ajaxtest5.dao.impl.PetDaoImpl;
import yb.ajaxtest5.pojo.Pet;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryByName", urlPatterns = "/queryByName")
public class QueryByNameServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String name = request.getParameter("name");
        PetDaoImpl petDao = new PetDaoImpl();
        ArrayList<Pet> pets = petDao.queryByName(name);

        response.getWriter().print(pets.size()>0?"no":"yes");
    }
}