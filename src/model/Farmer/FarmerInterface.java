package model.Farmer;
public interface FarmerInterface {

	int getFarmerID();
	String getFarmerName();
	String getFarmerStreetAddrees();
	String getFarmerCity();
	String getFarmerState();
	String getFarmerZipCode();
	String getWalletAddress();
	double getBalance();
	
	void setFarmerID(int farmerID);
	void setFarmerName(String farmerName);
	void setFarmerStreetAddress(String streetAddress);
	void setFarmerCity(String farmerCity);
	void setFarmerState(String farmerState);
	void setFarmerZipCode(String farmerZipCode);
	void setWalletAddress(String walletAddress);
	void setBalance(double balance);
}
