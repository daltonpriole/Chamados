package persistence.chamado;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Chamado;

public interface iChamadoDao {
	public void persistir(Chamado chamado) throws SQLException;
	public void responder(Chamado chamado) throws SQLException;
	public Chamado consultar(int id) throws SQLException;
	public void deleat (int id) throws SQLException;
	List<Chamado> listar() throws SQLException;
	public void setConnection(Connection connection);
}
