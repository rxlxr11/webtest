package yb.ajaxtest5.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest5.dao.impl.PetDaoImpl;
import yb.ajaxtest5.pojo.Pet;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryByBreed", urlPatterns = "/queryByBreed")
public class QueryByBreedServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String breed = request.getParameter("breed");
        PetDaoImpl petDao = new PetDaoImpl();
        ArrayList<Pet> pets = petDao.queryByBreed(breed);
        System.out.println(pets);
        String jsonString = JSONObject.toJSONString(pets);
        response.getWriter().print(jsonString);
    }
}