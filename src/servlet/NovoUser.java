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

public class NovoUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NovoUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("login") == null) {
			sessao.setAttribute("redirect", "http://localhots:8080/Chamados/NovoChamado.jsp");
			response.sendRedirect("http://localhost:8080/Chamados/Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (request.getParameter("nome").trim().length() < 4) {
			out.println("Preencha o Campo Nome");
		} else if (request.getParameter("email").length() < 4) {
			out.println("Preencha o Campo email");
		} else if (request.getParameter("password").length() < 4) {
			out.println("Preencha o Campo Password");
		} else {
			User c = new User(nome, email, password);
			try {
				UserDao cDao = new UserDao();
				cDao.inserir(c);
				response.sendRedirect("http://localhost:8080/Chamados/ListarUser.jsp");
			} catch (SQLException e) {
				System.out.println("Erro ao adicionar no banco: " + e);
			}
		}
	}
	public void add(HttpServletRequest request, HttpServletResponse response) {
		try {
			if(request.getParameter("user" ) != null)
			doPost(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Erro ao executar do Post: "+ e);
			e.printStackTrace();
		}
	}

}
