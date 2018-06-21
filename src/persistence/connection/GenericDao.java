package persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements iGenericDao {

	private Connection connection;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbcDriver");
		connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/suportdb", "sa", "");
		
		return connection;
	}

}