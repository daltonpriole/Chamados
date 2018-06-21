package persistence;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.connection.GenericDao;
import persistence.connection.iGenericDao;

public class TestConnection {
	private Connection connection;
	
	public void testConnection() {
		iGenericDao gDao = new GenericDao();
		try {
			setConnection(gDao.getConnection());
			System.out.println("Conex�o Okay");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
