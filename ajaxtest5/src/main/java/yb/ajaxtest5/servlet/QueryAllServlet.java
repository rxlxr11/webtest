package yb.ajaxtest5.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest5.dao.impl.PetDaoImpl;
import yb.ajaxtest5.pojo.Pet;

import java.io.PrintWriter;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryAll", urlPatterns = "/queryAll")
public class QueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        PetDaoImpl petDao = new PetDaoImpl();
        ArrayList<Pet> pets = petDao.queryAll();
        String jsonString = JSONObject.toJSONString(pets);
        System.out.println("aaa"+jsonString);

        PrintWriter writer = response.getWriter();
        writer.print(jsonString);
    }
}