package yb.ajaxtest9.servlet;

@javax.servlet.annotation.WebServlet(name = "toProjectPage", urlPatterns = "/toProjectPage")
public class ToProjectPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("/WEB-INF/projectPageList.jsp?").forward(request,response);
    }
}