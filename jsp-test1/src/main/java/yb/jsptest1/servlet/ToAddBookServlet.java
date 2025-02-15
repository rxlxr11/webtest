package yb.jsptest1.servlet;@javax.servlet.annotation.WebServlet(name = "toAddBook",urlPatterns = "/toAddBook")
public class ToAddBookServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(request, response);
    }
}