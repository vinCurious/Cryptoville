import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Machine implements MachineInterface{

	static Map<Integer,String> productList;
	
	static{
	productList = new HashMap<Integer,String>();
	productList.put(0, "banana");
	productList.put(1, "apple");
	productList.put(2, "avocado");
	productList.put(3, "cherry");
	productList.put(4, "coconut");
	productList.put(5, "dragonfruit");
	productList.put(6, "grapes");
	productList.put(7, "kiwi");
	productList.put(8, "lemon");
	productList.put(9, "melon");
	productList.put(10, "orange");
	productList.put(11, "papaya");
	productList.put(12, "peach");
	productList.put(13, "pineapple");
	productList.put(14, "pomegranate");
	productList.put(15, "squash");
	productList.put(16, "strawberry");
	productList.put(17, "watermelon");
	}
	
	Machine(){
		
	}
	

	@Override
	public Transaction emitTransaction() {
		// TODO Auto-generated method stub
 	
		Statement stmt=null;
		Connection c=null;
		int count=0;
		try {
			Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:cryptoville.db");
	        //c.setAutoCommit(false);
	        System.out.println("Opened database successfully");
			stmt = c.createStatement();
	        String sql = "SELECT count(*) FROM Farmer;"; 
	        
	        ResultSet rs = stmt.executeQuery( sql);
	        
	        while ( rs.next() ) {
	           count = rs.getInt("count(*)");

	           System.out.println( "ID = " + count );

	           //System.out.println();
	        }
	        rs.close();
	        stmt.close();
	        c.close();
	        
		} catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
		int currentFarmerID = ThreadLocalRandom.current().nextInt(0,count);
    	int currentProductID = ThreadLocalRandom.current().nextInt(0,18);
    	String currentProductName = productList.get(currentProductID);
    	double currentPrice = ThreadLocalRandom.current().nextDouble(0.5,30.0);
    	
    	System.out.println("new instance at: farmerID: "+currentFarmerID );
    	System.out.println("productID: "+currentProductID + " price: "+currentPrice);
		return new Transaction(currentFarmerID,  new Product(currentProductID,currentProductName, currentPrice));
	}
	
	public static void main(String args[]) {
		Machine obj = new Machine();
		obj.emitTransaction();
	}


}