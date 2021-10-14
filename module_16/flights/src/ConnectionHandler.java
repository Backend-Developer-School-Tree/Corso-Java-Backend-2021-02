import org.checkerframework.checker.units.qual.C;

import java.sql.*;

public class ConnectionHandler {
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/databasename";
	
	private final String connectionUrl;
	
	private Connection connection;


	public ConnectionHandler(String dbUrl, String schema, String username, String password) throws ClassNotFoundException {
		this.connectionUrl = dbUrl 
				+ "?currentSchema="+ schema 
				+ "&user="+username
				+ "&password=" + password;
	
		Class.forName("org.postgresql.Driver");
	
	}
	
	public Connection getConnection() throws SQLException {
		if ( this.connection == null || this.connection.isClosed() ) {
			this.connection = DriverManager.getConnection(connectionUrl);
		}
		return this.connection;

	}

	public void closeConnection() throws SQLException {
		if ( this.connection != null && !this.connection.isClosed()) {
			this.connection.close();
			this.connection = null;
		}
	}
	
	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		Connection conn = getConnection();
		
		PreparedStatement stmnt = conn.prepareStatement(query);
		
		return stmnt;
	}

}
