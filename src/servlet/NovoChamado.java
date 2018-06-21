package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chamado;
import persistence.chamado.ChamadoDao;

public class NovoChamado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NovoChamado() {
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

		String titulo = request.getParameter("titulo");
		String conteudo = request.getParameter("conteudo");

		if (request.getParameter("titulo").trim().length() < 4) {
			out.println("Preencha o Campo titulo");
		} else if (request.getParameter("conteudo").length() < 4) {
			out.println("Preencha o Campo conteudo");
		} else {
			Chamado c = new Chamado(titulo, conteudo);
			try {
				ChamadoDao cDao = new ChamadoDao();
				cDao.persistir(c);
				response.sendRedirect("http://localhost:8080/Chamados/ListarChamados.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Erro ao adicionar no banco: " + e);
			}
		}
	}
	public void adicionar(HttpServletRequest request, HttpServletResponse response) {
		try {
			if(request.getParameter("titulo" ) != null)
			doPost(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Erro ao execultar do Post: "+ e);
			e.printStackTrace();
		}
	}
}
