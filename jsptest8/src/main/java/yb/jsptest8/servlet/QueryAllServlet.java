package yb.jsptest8.servlet;

import yb.jsptest8.dao.impl.PersonDaoImpl;
import yb.jsptest8.pojo.Person;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryAll", urlPatterns = "/queryAll")
public class
QueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        PersonDaoImpl personDao = new PersonDaoImpl();
        ArrayList<Person> people = personDao.queryAll();

        request.setAttribute("people",people);
        request.getRequestDispatcher("/WEB-INF/personList.jsp").forward(request,response);
    }
}