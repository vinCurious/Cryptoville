package model.RegisterMe;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RegisterMe implements RegisterMeInterface{
	
	static Map<Integer, Double>productPriceList;
	
	static{
		productPriceList = new HashMap<Integer,Double>();
		for(int i=0;i<21;i++)
		productPriceList.put(i,0.0);	
	}
	
	public static boolean registerFarmer(int farmerID, String farmerName, String farmerStreetAddress, String farmerCity,
			String farmerState, String farmerZipCode, double balance, String walletAddress, Connection c) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		try {
			stmt = c.createStatement();
	        String sql = "INSERT INTO Farmer (ID,NAME,STREET, CITY, STATE, ZIPCODE, BALANCE, WALLETADDRESS) " +
	                       "VALUES ("+farmerID+", '"+farmerName+ "', '"+farmerStreetAddress +"', '"+farmerCity+"', '"+farmerState+"', '"+farmerZipCode+"', "+balance+ ", '"+walletAddress +"');"; 
	        stmt.executeUpdate(sql);
	        stmt.close();
	        return true;
		} catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        return false;
	    }
		
	}

	public static boolean registerBuyer(int buyerID, String buyerName, double balance, String buyerStreetAddress,
			String buyerCity, String buyerState, String buyerZipCode, String walletAddress, Connection c) {
		// TODO Auto-generated method stub

		Statement stmt=null;
		try {
			stmt = c.createStatement();
	        String sql = "INSERT INTO Buyer (ID,NAME,STREET, CITY, STATE, ZIPCODE, BALANCE, WALLETADDRESS) " +
                    "VALUES ("+buyerID+", '"+buyerName+ "', '"+buyerStreetAddress +"', '"+buyerCity+"', '"+buyerState+"', '"+buyerZipCode+"', "+balance+ ", '"+walletAddress +"');"; 
	        stmt.executeUpdate(sql);
	        stmt.close();
	       
		} catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        return false;
	    }
		
		return true;
	}
	
}