package yb.ajaxtest2.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest2.dao.impl.StudentInfoDaoImpl;
import yb.ajaxtest2.pojo.StudentInfo;

import java.io.PrintWriter;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryAll", urlPatterns = "/queryAll")
public class QueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        StudentInfoDaoImpl studentInfoDao = new StudentInfoDaoImpl();
        ArrayList<StudentInfo> studentInfos = studentInfoDao.queryAll();

        String jsonString = JSONObject.toJSONString(studentInfos);

        PrintWriter writer = response.getWriter();
        writer.print(jsonString);
    }
}