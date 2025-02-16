package yb.jsptest3.servlet;

@javax.servlet.annotation.WebServlet(name = "toQueryByCondition", urlPatterns = "/toQueryByCondition")
public class ToQueryByConditionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("/WEB-INF/queryGame.jsp").forward(request,response);
    }
}