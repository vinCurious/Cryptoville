import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

	public static void main(String args[]) {

		//Populating databases
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:cryptoville.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened cryptoville.db database successfully");

		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Farmer " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " NAME           TEXT    NOT NULL, " + " STATE        CHAR(50))";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Farmer Table created successfully");

		Statement stmt1 = null;
		try {
			stmt1 = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Buyer " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " NAME           TEXT    NOT NULL)";
			stmt1.executeUpdate(sql);
			stmt1.close();

			System.out.println("Buyer Table created successfully");

			for (int i = 0; i < 20; i++) {
				RegisterMe.registerFarmer(i, "vinFarmer" + i, "NY", c);
			}

			for (int i = 0; i < 20; i++) {
				RegisterMe.registerBuyer(100 + i, "vinBuyer" + i, c);
			}

			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		
		
		
	}

}