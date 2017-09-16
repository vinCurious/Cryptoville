import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Machine.Machine;
import model.RegisterMe.RegisterMe;

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
			String sql = "CREATE TABLE IF NOT EXISTS Products " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " NAME TEXT    NOT NULL)";
		
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Product table created successfully");
		
		stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Farmer " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " NAME           TEXT    NOT NULL, STREET        CHAR(50),"
							+ " CITY        CHAR(50),"
							+ " STATE        CHAR(50),"
							+ " ZIPCODE        CHAR(5),"
							+ " BALANCE        DOUBLE(12,2),"
							+ " WALLETADDRESS        CHAR(50)"
							+ ");";
			
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Farmer Table created successfully");

		stmt= null;
		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Buyer " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " NAME           TEXT    NOT NULL, " + " STREET        CHAR(50),"
							+ " CITY        CHAR(50),"
							+ " STATE        CHAR(50),"
							+ " ZIPCODE        CHAR(5),"
							+ " BALANCE        DOUBLE(12,2),"
							+ " WALLETADDRESS        CHAR(50)"
							+ ");";
			
			stmt.executeUpdate(sql);
			stmt.close();

			System.out.println("Buyer Table created successfully");

		
				stmt = c.createStatement();
				sql = "CREATE TABLE IF NOT EXISTS Transactions " + "(ID INT PRIMARY KEY     NOT NULL,"
						+ " farmerID           TEXT    NOT NULL, productID           INT    NOT NULL, productPrice DOUBLE(12,2) NOT NULL)";
				stmt.executeUpdate(sql);
				stmt.close();
				System.out.println("Transactions Table created successfully");

			//registering farmers
			for (int i = 0; i < 20; i++) {
				RegisterMe.registerFarmer(i, "vinFarmer" + i, "123 abc apt ","Rochester","New York","14623",100000.12,"ed@#$sdasf"+i+"vinFarmer" + i, c);
			}

			//registering buyers
			for (int i = 0; i < 20; i++) {
				RegisterMe.registerFarmer(100+i, "vinBuyer" + i, "123 xyz apt ","Rochester","New York","14623",100000.12,"ed@#$sdasf"+(100+i)+"vinBuyer" + i, c);
			}
			
			//initializing machines
			for (int i = 0; i < 4; i++) {
            	Machine newMachine =  new Machine();

				Thread t = new Thread(new Runnable()
		        {
		            @Override
		            public void run()
		            {
		        	  	while(true){
			            	newMachine.emitTransaction();
		                try {
		        			Thread.sleep(1000);
		        		} catch (InterruptedException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		}
		        	  	}
		            }
		        });
		        t.start();
	
			}	
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

}