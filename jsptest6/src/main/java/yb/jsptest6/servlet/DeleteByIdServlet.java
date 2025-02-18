package yb.jsptest6.servlet;

import yb.jsptest6.dao.impl.MembersInfoDaoImpl;

@javax.servlet.annotation.WebServlet(name = "deleteById", urlPatterns = "/deleteById")
public class DeleteByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String id = request.getParameter("id");
        MembersInfoDaoImpl membersInfoDao = new MembersInfoDaoImpl();
        Integer i = membersInfoDao.deleteById(Integer.parseInt(id));
        response.sendRedirect("queryAll");
    }
}