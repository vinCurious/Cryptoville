package model.RegisterMe;
import java.sql.Connection;

public abstract class AbstractRegisterMe{
	 
	public boolean registerFarmer(int farmerID, String farmerName, String farmerStreetAddress, String farmerCity, String farmerState, String farmerZipCode, double Balance, String walletAddress, Connection c) {
		return false;
	}

	public  boolean registerBuyer(int buyerID, String buyerName, double balance, String buyerStreetAddress, String buyerCity, String buyerState, String buyerZipCode, String walletAddress, Connection c) {
		return false;
	}
}