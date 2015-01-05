package db.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyOperator {

	public static void main(String[] args) {
		operateDB();
	}

	private static void operateDB() {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String url = "jdbc:derby:firstdb;create=true";
		Connection conn;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
//			createTable(stmt);
			insertRecord(stmt);
			query(stmt);
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void createTable(Statement stmt) throws SQLException {
		String createTable = "create table person ( name varchar(10), age integer )";
		stmt.executeUpdate(createTable);
	}
	
	private static void insertRecord(Statement stmt) throws SQLException {
		String insertRecord = "insert into person values('xiaoni',28)";
		stmt.executeUpdate(insertRecord);
	}
	
	private static void query(Statement stmt) throws SQLException {
		String query = "select * from person";
		ResultSet rs = stmt.executeQuery(query);
	    while (rs.next()) {
	        String name = rs.getString(1);
	        int age = rs.getInt("age");
	        System.out.println(name + "    " + age);

	    }
	}
	
	
}
