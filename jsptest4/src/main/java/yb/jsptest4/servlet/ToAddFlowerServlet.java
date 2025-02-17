package yb.jsptest4.servlet;

@javax.servlet.annotation.WebServlet(name = "toAddFlower", urlPatterns = "/toAddFlower")
public class ToAddFlowerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setAttribute("allowIf","yes");
        request.getRequestDispatcher("/WEB-INF/addFlower.jsp").forward(request,response);
    }
}