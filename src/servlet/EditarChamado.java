package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Chamado;
import persistence.chamado.ChamadoDao;

public class EditarChamado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Chamado c;

	public EditarChamado() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("login") == null) {
			if (request.getParameter("id") == null) {
				response.sendRedirect("http://localhost:8080/Chamados/Index.jsp");
			} else {
				sessao.setAttribute("redirect",
						"http://localhots:8080/Chamados/EditarChamado?id=" + request.getParameter("id"));
				response.sendRedirect("http://localhost:8080/Chamados/Login");
			}
		} else {
			String id = request.getParameter("id");
			if (request.getParameter("id") != null) {
				try {
					ChamadoDao cDao = new ChamadoDao();
					c = cDao.consultar(Integer.parseInt(id));
				} catch (ClassNotFoundException | SQLException e) {
					System.err.println("Erro ao consultar no banco: " + e);
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			c = null;
			c.setId(Integer.parseInt(request.getParameter("id")));
			c.setTitulo(request.getParameter("titulo"));
			c.setConteudo(request.getParameter("conteudo"));

			ChamadoDao cDao = new ChamadoDao();
			cDao.responder(c);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro ao adicionar no banco: " + e);
		}
	}
	public Chamado editar (HttpServletRequest request, HttpServletResponse response) {
		try {
			ChamadoDao cDao = new ChamadoDao();
			c = cDao.consultar(Integer.parseInt(request.getParameter("id")));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
