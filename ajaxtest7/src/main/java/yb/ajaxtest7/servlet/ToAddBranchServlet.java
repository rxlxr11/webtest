package yb.ajaxtest7.servlet;

@javax.servlet.annotation.WebServlet(name = "toAddBranch", urlPatterns = "/toAddBranch")
public class ToAddBranchServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

        request.getRequestDispatcher("/WEB-INF/addBranch.jsp").forward(request,response);
    }
}