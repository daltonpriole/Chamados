package persistence.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public interface iUserDao {
	
	public void validar(User user, HttpServletRequest request,  HttpServletResponse responses) throws SQLException, IOException;
	public void inserir(User user) throws SQLException;
	public List<User> listar() throws SQLException;
}
