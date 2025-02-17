package yb.ajaxtest5.servlet;

@javax.servlet.annotation.WebServlet(name = "toAddPet", urlPatterns = "/toAddPet")
public class ToAddPetServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("/WEB-INF/addPet.jsp").forward(request,response);
    }
}