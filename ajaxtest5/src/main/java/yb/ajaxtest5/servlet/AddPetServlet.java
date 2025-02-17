package yb.ajaxtest5.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest5.dao.impl.PetDaoImpl;
import yb.ajaxtest5.pojo.Pet;

import java.io.BufferedReader;

@javax.servlet.annotation.WebServlet(name = "addPet", urlPatterns = "/addPet")
public class AddPetServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        BufferedReader reader = request.getReader();
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();

        while ((line=reader.readLine())!=null){
            stringBuffer.append(line);
        }
        Pet pet = JSONObject.parseObject(stringBuffer.toString(), Pet.class);

        PetDaoImpl petDao = new PetDaoImpl();
        Integer i = petDao.addOne(pet);

        response.getWriter().print(i>0?"success":"fail");
    }
}