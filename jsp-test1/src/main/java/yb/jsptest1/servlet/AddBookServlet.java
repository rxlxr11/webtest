package yb.jsptest1.servlet;

import yb.jsptest1.dao.impl.BookManageDaoImpl;
import yb.jsptest1.pojo.BookManage;
import yb.jsptest1.utils.DateFormatUtil;

@javax.servlet.annotation.WebServlet(name = "addBook", urlPatterns = "/addBook")
public class AddBookServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookTime = request.getParameter("bookTime");
        String bookType = request.getParameter("bookType");


        BookManage bookManage = new BookManage(0,bookName,bookAuthor, DateFormatUtil.stringToDate(bookTime),Integer.parseInt(bookType));
        Integer i = new BookManageDaoImpl().addOne(bookManage);
        response.sendRedirect("queryAll");


    }
}