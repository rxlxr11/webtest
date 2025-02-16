package yb.ajaxtest3.servlet;

@javax.servlet.annotation.WebServlet(name = "toAddGame", urlPatterns = "/toAddGame")
public class ToAddGameServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        request.getRequestDispatcher("WEB-INF/addGame.jsp").forward(request,response);
    }
}