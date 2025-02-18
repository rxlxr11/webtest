package yb.ajaxtest7.servlet;@javax.servlet.annotation.WebServlet(name = "toDetail",urlPatterns = "/toDetail")
public class ToDetailServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String id = request.getParameter("id");
        request.getRequestDispatcher("/WEB-INF/detailInform.jsp?id="+id).forward(request,response);
    }
}