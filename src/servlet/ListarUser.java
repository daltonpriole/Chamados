package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import persistence.user.UserDao;

public class ListarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void checkSessao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("login") == null) {
			sessao.setAttribute("redirect", "http://localhots:8080/Chamados/NovoChamado.jsp");
			response.sendRedirect("http://localhost:8080/Chamados/Login.jsp");
		}
	}

	public List<User> listagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> uList = new ArrayList<User>();
		if (request.getCookies() != null) {
			UserDao dao = new UserDao();
			try {
				uList = dao.listar();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return uList;

	}
}
