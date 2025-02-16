package yb.ajaxtest2.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest2.dao.impl.StudentInfoDaoImpl;
import yb.ajaxtest2.pojo.StudentInfo;

import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "toUpdateById", urlPatterns = "/toUpdateById")
public class ToUpdateByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String id = request.getParameter("id");
        request.getRequestDispatcher("/WEB-INF/updateStu.jsp?id="+id).forward(request,response);

    }
}