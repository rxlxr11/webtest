package yb.ajaxtest7.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest7.dao.impl.BranchesDaoImpl;
import yb.ajaxtest7.pojo.Branches;

import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryAll", urlPatterns = "/queryAll")
public class QueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        BranchesDaoImpl branchesDao = new BranchesDaoImpl();
        ArrayList<Branches> branches = branchesDao.queryAll();

        String jsonString = JSONObject.toJSONString(branches);
        response.getWriter().print(jsonString);
    }
}