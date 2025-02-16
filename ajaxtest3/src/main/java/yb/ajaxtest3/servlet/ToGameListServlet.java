package yb.ajaxtest3.servlet;

@javax.servlet.annotation.WebServlet(name = "toGameList", urlPatterns = "/toGameList")
public class ToGameListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("WEB-INF/gameList.jsp").forward(request, response);
    }
}