import java.sql.*;

public class RegisterMe{

	public static boolean registerFarmer(int farmerID, String farmerName, String stateName,Connection c) {
		// TODO Auto-generated method stub
		
		Statement stmt=null;
		try {
	        //c.setAutoCommit(false);
			stmt = c.createStatement();
	        String sql = "INSERT INTO Farmer (ID,NAME,STATE) " +
	                       "VALUES ("+farmerID+", '"+farmerName+ "', '"+stateName +"');"; 
	        stmt.executeUpdate(sql);
	        stmt.close();
	        return true;
		} catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
				
		return false;
	}

	public static boolean registerBuyer(int buyerID, String buyerName, Connection c) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		try {
	        //c.setAutoCommit(false);
			stmt = c.createStatement();
	        String sql = "INSERT INTO Buyer (ID,NAME) " +
	                       "VALUES ( "+buyerID + ", '"+buyerName+"');"; 
	        stmt.executeUpdate(sql);
	        stmt.close();
	        return true;
		} catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
				
		return false;
	}
	
	public static void main(String args[]){
	}
	

	
}