package yb.jsptest6.servlet;

import yb.jsptest6.dao.impl.MembersInfoDaoImpl;
import yb.jsptest6.pojo.MembersInfo;

@javax.servlet.annotation.WebServlet(name = "updateById", urlPatterns = "/updateById")
public class UpdateByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("mName");
        String mAge = request.getParameter("mAge");
        String mGender = request.getParameter("mGender");
        String mAddress = request.getParameter("mAddress");
        String mEmail = request.getParameter("mEmail");
        MembersInfo membersInfo = new MembersInfo(Integer.parseInt(id), name, mGender, Integer.parseInt(mAge), mAddress, mEmail);

        MembersInfoDaoImpl membersInfoDao = new MembersInfoDaoImpl();
        Integer i = membersInfoDao.updateById(membersInfo);
        response.sendRedirect("queryAll");
    }
}