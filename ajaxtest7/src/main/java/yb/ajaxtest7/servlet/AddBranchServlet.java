package yb.ajaxtest7.servlet;

import com.alibaba.fastjson.JSONObject;
import yb.ajaxtest7.dao.impl.BranchesDaoImpl;
import yb.ajaxtest7.pojo.Branches;

import java.io.BufferedReader;

@javax.servlet.annotation.WebServlet(name = "addBranch", urlPatterns = "/addBranch")
public class AddBranchServlet extends javax.servlet.http.HttpServlet {
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

        Branches branches = JSONObject.parseObject(stringBuffer.toString(), Branches.class);

        BranchesDaoImpl branchesDao = new BranchesDaoImpl();
        Integer i = branchesDao.addOne(branches);

        response.getWriter().print(i>0?"success":"fail");
    }
}