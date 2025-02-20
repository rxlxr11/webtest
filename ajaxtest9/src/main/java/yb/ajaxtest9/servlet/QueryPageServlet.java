package yb.ajaxtest9.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest9.dao.impl.ProjectInfoDaoImpl;
import yb.ajaxtest9.pojo.ProjectInfo;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@javax.servlet.annotation.WebServlet(name = "queryPage", urlPatterns = "/queryPage")
public class QueryPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String curPageStr = request.getParameter("curPage");
        String status = request.getParameter("status");

        Integer curPage = Integer.valueOf(curPageStr);
        ProjectInfoDaoImpl projectInfoDao = new ProjectInfoDaoImpl();
        ArrayList<ProjectInfo> projectInfos = projectInfoDao.queryPage(curPage);

        int size = projectInfoDao.queryProjectCount(Integer.parseInt(status));
        System.out.println(size);
        Integer totalPage = size%3==0?size/3:size/3+1;
        System.out.println(totalPage);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("projectInfos",projectInfos);
        stringObjectHashMap.put("curPage",curPage);
        stringObjectHashMap.put("totalPage",totalPage);
        String jsonString = JSONObject.toJSONString(stringObjectHashMap);

        PrintWriter writer = response.getWriter();
        writer.print(jsonString);
    }
}