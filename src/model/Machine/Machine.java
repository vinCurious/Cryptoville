package model.Machine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import model.Product.Product;
import model.Transaction.Transaction;

public class Machine implements MachineInterface{

	static Map<Integer,String> productList;
	
	static{
	productList = new HashMap<Integer,String>();
	productList.put(0, "Apple");
	productList.put(1, "Apricot");
	productList.put(2, "Avocado");
	productList.put(3, "Banana");
	productList.put(4, "Cherry");
	productList.put(5, "Citrus");
	productList.put(6, "Coconut");
	productList.put(7, "DragonFruit");
	productList.put(8, "Durian");
	productList.put(9, "Grapes");
	productList.put(10, "Kiwi");
	productList.put(11, "Melon");
	productList.put(12, "Orange");
	productList.put(13, "Papaya");
	productList.put(14, "Pear");
	productList.put(15, "Pineapple");
	productList.put(16, "Plum");
	productList.put(17, "Pomegranate");
	productList.put(18, "Raspberry");
	productList.put(19, "Strawberry");
	productList.put(20, "Watermelon");
	}
	
	public Machine(){
	}
	

	@Override
	public Transaction emitTransaction() {
		// TODO Auto-generated method stub
 	
		Statement stmt=null;
		Connection c=null;
		int farmerCount=0;
		try {
			Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:cryptoville.db");
	        //c.setAutoCommit(false);
	        System.out.println("Opened database successfully");
			stmt = c.createStatement();
	        String sql = "SELECT count(*) FROM Farmer;"; 
	        
	        ResultSet rs = stmt.executeQuery( sql);
	        
	        while ( rs.next() ) {
	           farmerCount = rs.getInt("count(*)");

	           System.out.println( "farmer count = " + farmerCount );

	           //System.out.println();
	        }
	        rs.close();
	        stmt.close();
	     
		} catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
		
		
		int currentFarmerID = ThreadLocalRandom.current().nextInt(0,farmerCount);
    	int currentProductID = ThreadLocalRandom.current().nextInt(0,21);
    	String currentProductName = productList.get(currentProductID);
    	double currentPrice = ThreadLocalRandom.current().nextDouble(0.5,30.0);
    	
    	System.out.println("new instance at: farmerID: "+currentFarmerID );
    	System.out.println("productID: "+currentProductID + " price: "+currentPrice);
    	    	
    	int transactionCount=0;
    	
		try {
	        //c.setAutoCommit(false);
			stmt = c.createStatement();
		    String sql = "SELECT count(*) FROM Transactions;"; 
		    
	      
	        
		    ResultSet rs = stmt.executeQuery(sql);
		        
		        while ( rs.next() ) {
		        	transactionCount = rs.getInt("count(*)");

		           System.out.println( "Transaction Count = " + transactionCount);

		           //System.out.println();
		        }
		        rs.close();
		        
		        try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
	        sql = "INSERT INTO Transactions (ID,farmerID,productID, productPrice) " +
	                       "VALUES ("+transactionCount+","+currentFarmerID+", "+currentProductID+ ", "+currentPrice +");"; 
	        
	        	stmt.executeUpdate(sql);
		        stmt.close();
   
	        c.close();

		} catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	
		System.out.println("New Transaction emitted by "+Thread.currentThread()+" for farmer "+currentFarmerID+", productID: "+currentProductID+" , ProductName: "+currentProductName+"  ,ProductPrice: "+currentPrice);
		
		return new Transaction(currentFarmerID,  new Product(currentProductID,currentProductName, currentPrice));
	}
	
	public static void main(String args[]) {
		Machine obj = new Machine();
		obj.emitTransaction();
	}


}