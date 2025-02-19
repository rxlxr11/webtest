package yb.jsptest8.servlet;

import yb.jsptest8.dao.impl.PersonDaoImpl;
import yb.jsptest8.pojo.Person;

@javax.servlet.annotation.WebServlet(name = "addPerson", urlPatterns = "/addPerson")
public class AddPersonServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String personName = request.getParameter("personName");
        String sex = request.getParameter("sex");
        String rank = request.getParameter("rank");
        String age = request.getParameter("age");
        String department = request.getParameter("department");

        Person person = new Person(0, personName, sex, Integer.parseInt(age), rank, department);
        new PersonDaoImpl().addOne(person);
        response.sendRedirect("queryAll");

    }
}