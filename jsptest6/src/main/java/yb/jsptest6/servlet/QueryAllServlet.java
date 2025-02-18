package yb.jsptest6.servlet;

import yb.jsptest6.dao.impl.MembersInfoDaoImpl;
import yb.jsptest6.pojo.MembersInfo;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryAll", urlPatterns = "/queryAll")
public class QueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        MembersInfoDaoImpl membersInfoDao = new MembersInfoDaoImpl();
        ArrayList<MembersInfo> membersInfos = membersInfoDao.queryAll();

        request.setAttribute("membersInfos",membersInfos);
        request.getRequestDispatcher("/WEB-INF/membersList.jsp").forward(request,response);
    }
}