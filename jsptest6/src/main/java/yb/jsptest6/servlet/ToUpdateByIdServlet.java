package yb.jsptest6.servlet;

import yb.jsptest6.dao.impl.MembersInfoDaoImpl;
import yb.jsptest6.pojo.MembersInfo;

@javax.servlet.annotation.WebServlet(name = "toUpdateById", urlPatterns = "/toUpdateById")
public class ToUpdateByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String id = request.getParameter("id");
        MembersInfoDaoImpl membersInfoDao = new MembersInfoDaoImpl();
        MembersInfo membersInfo = membersInfoDao.queryById(Integer.parseInt(id));
        request.setAttribute("member",membersInfo);
        request.getRequestDispatcher("/WEB-INF/updateMember.jsp").forward(request,response);
    }
}