package yb.ajaxtest2.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest2.dao.impl.StudentInfoDaoImpl;
import yb.ajaxtest2.pojo.StudentInfo;

import java.io.BufferedReader;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "updateById", urlPatterns = "/updateById")
public class UpdateByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String line = null;
        BufferedReader reader = request.getReader();

        StringBuffer stringBuffer = new StringBuffer();

        while ((line=reader.readLine())!=null){
            stringBuffer.append(line);
        }

        StudentInfo studentInfo = JSONObject.parseObject(stringBuffer.toString(), StudentInfo.class);
        StudentInfoDaoImpl studentInfoDao = new StudentInfoDaoImpl();
        Integer i = studentInfoDao.updateById(studentInfo);
        PrintWriter writer = response.getWriter();
        writer.print(i>0?"success":"fail");
    }
}