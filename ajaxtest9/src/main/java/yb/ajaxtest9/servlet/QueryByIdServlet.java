package yb.ajaxtest9.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest9.dao.impl.ProjectInfoDaoImpl;
import yb.ajaxtest9.pojo.ProjectInfo;

@javax.servlet.annotation.WebServlet(name = "queryById", urlPatterns = "/queryById")
public class QueryByIdServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String id = request.getParameter("id");

        ProjectInfoDaoImpl projectInfoDao = new ProjectInfoDaoImpl();

        ProjectInfo projectInfo = projectInfoDao.queryById(Integer.parseInt(id));

        String jsonString = JSONObject.toJSONString(projectInfo);

        response.getWriter().print(jsonString);

    }
}