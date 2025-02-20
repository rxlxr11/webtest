package yb.ajaxtest9.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest9.dao.impl.ProjectInfoDaoImpl;
import yb.ajaxtest9.pojo.ProjectInfo;

import java.io.BufferedReader;

@javax.servlet.annotation.WebServlet(name = "updateById", urlPatterns = "/updateById")
public class UpdateByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        BufferedReader reader = request.getReader();
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        while ((line=reader.readLine())!=null){
            stringBuffer.append(line);
        }

        ProjectInfo projectInfo = JSONObject.parseObject(stringBuffer.toString(), ProjectInfo.class);

        ProjectInfoDaoImpl projectInfoDao = new ProjectInfoDaoImpl();
        Integer i = projectInfoDao.updateById(projectInfo);
        response.getWriter().print(i>0?"success":"fail");
    }
}