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

import model.Chamado;
import persistence.chamado.ChamadoDao;

public class ListarChamados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarChamados() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("login") == null) {
			sessao.setAttribute("redirect", "http://localhost:8080/Chamados/ListarChamados.jsp");
			response.sendRedirect("http://localhost:8080/Chamados/Login.jsp");
		}
	}

	public List<Chamado> listagem(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		List<Chamado> cList = new ArrayList<Chamado>();
		ChamadoDao dao = new ChamadoDao();
		try {
			cList = dao.listar();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return cList;
	}

	public void deleat(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("id") != null) {
			try {
				ChamadoDao cDao = new ChamadoDao();
				int id = Integer.parseInt(request.getParameter("id"));
				cDao.deleat(id);
				response.sendRedirect("http://localhost:8080/Chamados/ListarChamados.jsp");
			} catch (IOException | ClassNotFoundException | SQLException e) {
				System.err.println("Erro ao remover do banco " + e);
			}
		}
	}
}
