package persistence.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface iGenericDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
}
