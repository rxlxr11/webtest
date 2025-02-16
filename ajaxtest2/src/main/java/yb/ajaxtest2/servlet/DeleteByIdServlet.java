package yb.ajaxtest2.servlet;

import yb.ajaxtest2.dao.impl.StudentInfoDaoImpl;

import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "deleteById", urlPatterns = "/deleteById")
public class DeleteByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String id = request.getParameter("id");
        StudentInfoDaoImpl studentInfoDao = new StudentInfoDaoImpl();
        Integer i = studentInfoDao.deleteById(Integer.parseInt(id));
        PrintWriter writer = response.getWriter();
        writer.print(i>0?"success":"fail");

    }
}