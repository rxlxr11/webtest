package yb.ajaxtest9.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest9.dao.impl.ProjectInfoDaoImpl;
import yb.ajaxtest9.pojo.ProjectInfo;

import java.util.ArrayList;
import java.util.HashMap;

@javax.servlet.annotation.WebServlet(name = "queryByStatus", urlPatterns = "/queryByStatus")
public class QueryByStatusServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String curPageStr = request.getParameter("curPage");
        String statusStr = request.getParameter("status");

        Integer curPage = Integer.valueOf(curPageStr);
        Integer status = Integer.valueOf(statusStr);

        ProjectInfoDaoImpl projectInfoDao = new ProjectInfoDaoImpl();

        ArrayList<ProjectInfo> projectInfos = projectInfoDao.queryByStatus(status, curPage);
        int size = projectInfoDao.queryProjectCount(status);
        Integer totalPage = size%3==0?size/3:size/3+1;
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("projectInfos",projectInfos);
        stringObjectHashMap.put("curPage",curPage);
        stringObjectHashMap.put("totalPage",totalPage);
        String jsonString = JSONObject.toJSONString(stringObjectHashMap);

        response.getWriter().print(jsonString);


    }
}