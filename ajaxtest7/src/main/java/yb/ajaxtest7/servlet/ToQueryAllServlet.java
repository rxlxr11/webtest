package yb.ajaxtest7.servlet;

@javax.servlet.annotation.WebServlet(name = "toQueryAll", urlPatterns = "/toQueryAll")
public class ToQueryAllServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        request.getRequestDispatcher("/WEB-INF/branchList.jsp").forward(request,response);
    }
}