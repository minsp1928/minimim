package actionController;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBAction {
	private static DBAction instance;
	private Connection conn;
	private DataSource ds;
	
	public DBAction() {
		try {
			ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/mysql");
			
		} catch (NamingException e) {
			System.out.println("DBAction namingException "+e.getMessage());
			e.printStackTrace();
		}
	}
	public static DBAction getinstance() {
		if(instance == null) {
			instance = new DBAction();
		}
		return instance;
	}
	public Connection getConnection() {
		try {
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("DBAction getConnection->");
			e.printStackTrace();
		}
		return this.conn;
	}
}
