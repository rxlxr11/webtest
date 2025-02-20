package yb.ajaxtest9.servlet;

@javax.servlet.annotation.WebServlet(name = "toCheckProject", urlPatterns = "/toCheckProject")
public class ToCheckProjectServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String id = request.getParameter("id");
        request.getRequestDispatcher("/WEB-INF/checkProject.jsp?id="+id).forward(request,response);
    }
}