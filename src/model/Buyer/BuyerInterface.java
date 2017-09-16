package model.Buyer;
public interface BuyerInterface{
	
	int getBuyerID();
	String getBuyerName();
	double getBalance();
    String getBuyerStreetAddress();
    String getBuyerCity();
    String getBuyerState();
    String getBuyerZipCode();
    String getWalletAddress();

	void setBuyerID(int buyerID);
	void setBuyerName(String buyerName);
	void setBalance(double balance);
    void setBuyerStreetAddress(String streetAddress);
    void setBuyerCity(String city);
    void setBuyerState(String state);
    void setBuyerZipCode(String zipCode);
    void setWalletAddress(String walletAddress);
}