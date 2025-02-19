package yb.jsptest8.servlet;

@javax.servlet.annotation.WebServlet(name = "toAddPerson", urlPatterns = "/toAddPerson")
public class ToAddPersonServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("/WEB-INF/addPerson.jsp").forward(request,response);
    }
}