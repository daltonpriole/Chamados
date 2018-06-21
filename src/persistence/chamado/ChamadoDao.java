package persistence.chamado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import persistence.connection.GenericDao;
import persistence.connection.iGenericDao;

public class ChamadoDao implements iChamadoDao {

	private Connection connection;
	
	public ChamadoDao() throws ClassNotFoundException, SQLException {
		iGenericDao gDao = new GenericDao();
		setConnection(gDao.getConnection());
	}
	
	@Override
	public void persistir(Chamado chamado) {
		try {
			String sql = "INSERT INTO chamados (titulo, conteudo) VALUES(?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, chamado.getTitulo());
			ps.setString(2, chamado.getConteudo());
			ps.execute();
			ps.close();
		} catch (SQLException  e) {
			System.out.println("problemas com o banco " + e);
		}
	}

	@Override
	public void responder(Chamado chamado) throws SQLException {
		String sql = "UPDATE chamados SET titulo = ?, conteudo = ?, data_abertura = ?, retorno = ?, data_retorno = ?, estado =  ? WHERE(id = ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, chamado.getTitulo());
		ps.setString(2, chamado.getConteudo());
		ps.setString(3, chamado.getData_abertura());
		ps.setString(4, chamado.getRetorno());
		ps.setString(5, chamado.getData_retorno());
		ps.setString(6, chamado.getEstado());
		ps.setInt(7, chamado.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public Chamado consultar(int id) throws SQLException{	
		Chamado c = null;
		String sql = "SELECT * FROM chamados WHERE(id =?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			c = new Chamado(rs.getInt("id"), rs.getString("titulo"), rs.getString("conteudo"));
		}
		rs.close();
		ps.close();
		return c;
	}
	
	@Override
	public List<Chamado> listar() throws SQLException {
		List<Chamado> list = new ArrayList<Chamado>();
		String sql = "SELECT * FROM chamados ORDER BY id DESC";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Chamado c = new Chamado(rs.getInt("id"), rs.getString("titulo"), rs.getString("conteudo"));
			list.add(c);
		}
		rs.close();
		ps.close();
		return list;
	}

	@Override
	public void deleat (int id) throws SQLException{
		String sql = "DELETE FROM chamados WHERE(id = ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
