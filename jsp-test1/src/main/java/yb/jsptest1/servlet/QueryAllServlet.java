package yb.jsptest1.servlet;

import yb.jsptest1.dao.impl.BookManageDaoImpl;
import yb.jsptest1.pojo.BookManage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "queryAll", urlPatterns = "/queryAll")
public class QueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {


        BookManageDaoImpl bookManageDao = new BookManageDaoImpl();
        ArrayList<BookManage> bookManages = bookManageDao.queryAll();

        System.out.println(bookManages);
        request.setAttribute("books",bookManages);

        request.getRequestDispatcher("/WEB-INF/bookList.jsp").forward(request,response);
    }
}