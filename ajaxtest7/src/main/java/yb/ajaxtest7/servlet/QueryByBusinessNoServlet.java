package yb.ajaxtest7.servlet;

import yb.ajaxtest7.dao.impl.BranchesDaoImpl;
import yb.ajaxtest7.pojo.Branches;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryByBusinessNo", urlPatterns = "/queryByBusinessNo")
public class QueryByBusinessNoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String businessNo = request.getParameter("businessNo");
        BranchesDaoImpl branchesDao = new BranchesDaoImpl();
        ArrayList<Branches> branches = branchesDao.queryByBusinessNo(businessNo);

        response.getWriter().print(branches.size());
    }
}