package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Index() {
		super();
	}

	public void checkSessao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("login") == null) {
			response.sendRedirect("http://localhost:8080/Chamados/Login.jsp");
		}
	}

	public boolean checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("login") == null) {
			return false;
		}else {
			if (request.getParameter("type") == "admin") {
				return true;
			}
		} 
		return false;
	}
}
