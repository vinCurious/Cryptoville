package model.Farmer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Farmer implements FarmerInterface{
		
    int farmerID;
    String farmerName;
    String farmerStreetAddress;
    String farmerCity;
    String farmerState;
    String farmerZipCode;
    String walletAddress;
    double balance;
	 
	@Override
	public int getFarmerID() {
		// TODO Auto-generated method stub
		return this.farmerID;
	}

	@Override
	public String getFarmerName() {
		// TODO Auto-generated method stub
		return this.farmerName;
	}

	@Override
	public String getFarmerState() {
		// TODO Auto-generated method stub
		return this.farmerState;
	}

	@Override
	public void setFarmerID(int farmerID) {
		// TODO Auto-generated method stub
		this.farmerID = farmerID;
	}

	@Override
	public void setFarmerName(String farmerName) {
		// TODO Auto-generated method stub
		this.farmerName = farmerName;
	}

	@Override
	public void setFarmerState(String farmerState) {
		// TODO Auto-generated method stub
		this.farmerState = farmerState;
	}

	@Override
	public String getFarmerStreetAddrees() {
		// TODO Auto-generated method stub
		return this.farmerStreetAddress;
	}

	@Override
	public String getFarmerCity() {
		// TODO Auto-generated method stub
		return this.farmerCity;
	}

	@Override
	public String getFarmerZipCode() {
		// TODO Auto-generated method stub
		return this.farmerZipCode;
	}

	@Override
	public void setFarmerStreetAddress(String streetAddress) {
		// TODO Auto-generated method stub
		this.farmerStreetAddress = streetAddress;
	}

	@Override
	public void setFarmerCity(String farmerCity) {
		// TODO Auto-generated method stub
		this.farmerCity = farmerCity;
	}

	@Override
	public void setFarmerZipCode(String farmerZipCode) {
		// TODO Auto-generated method stub
		this.farmerZipCode = farmerZipCode;
	}

	@Override
	public String getWalletAddress() {
		// TODO Auto-generated method stub
		return this.walletAddress;
	}

	@Override
	public void setWalletAddress(String walletAddress) {
		// TODO Auto-generated method stub
		this.walletAddress = walletAddress;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}

	@Override
	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		this.balance=balance;
	}
   	
}