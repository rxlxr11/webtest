package yb.jsptest8.servlet;

import yb.jsptest8.dao.impl.PersonDaoImpl;

@javax.servlet.annotation.WebServlet(name = "deleteById", urlPatterns = "/deleteById")
public class DeleteByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String id = request.getParameter("id");
        PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.deleteById(Integer.parseInt(id));
        response.sendRedirect("queryAll");
    }
}