import java.sql.Connection;

public abstract class RegisterMeInterface{
	 
	boolean registerFarmer(int farmerID, String farmerName, String stateName, Connection c) {
		return false;
	}
	
	boolean registerBuyer(int buyerID, String buyerName, Connection c){
		return false;
	}

}