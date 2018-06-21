package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import persistence.user.UserDao;

/**
 * Servlet implementation class ControlAccess
 */
public class ControlAccess extends HttpServlet {
    private static final long serialVersionUID = 1L;

 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println("User: "+user+" Password: "+password); 
        if (request.getParameter("user").trim().length() < 1) {
            out.println("Preencha o Campo Usuarios");
        } else if (request.getParameter("password").length() < 1) {
            out.println("Preencha o Campo Senha");
        } else {
            User u = new User(user, password);
            UserDao uDao = new UserDao();
            try {
                uDao.validar(u, request, response);
            } catch (SQLException e) {
                if (request.getParameter("msg") != null) {
                    if (request.getParameter("msg").equals("error")) {
                        out.println("<span style='color: red'>Login ou senha inválido</span>");
                    }
                }
            }
        }
    }
    public void comunication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        if(user != null) {
            doPost(request, response);
        }
    }
    
    public void logoff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("msg")!= null) {
            if (sessao.getAttribute("msg").equals("logoff")) {
                sessao.invalidate();
                response.sendRedirect("http://localhost:8080/Chamados/Login.jsp");
                out.println("<span style='color: red'>Sessão encerrada</span>");
            }
        }
    }
}


