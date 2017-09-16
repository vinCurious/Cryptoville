package model.Buyer;

public class Buyer implements BuyerInterface{
	
	int buyerID;
	String buyerName;
	double balance;
    String buyerStreetAddress;
    String buyerCity;
    String buyerState;
    String buyerZipCode;
    String walletAddress;
	
	@Override
	public int getBuyerID() {
		// TODO Auto-generated method stub
		return this.buyerID;
	}
	@Override
	public String getBuyerName() {
		// TODO Auto-generated method stub
		return this.buyerName;
	}
	@Override
	public void setBuyerID(int buyerID) {
		// TODO Auto-generated method stub
		this.buyerID = buyerID;
	}
	@Override
	public void setBuyerName(String buyerName) {
		// TODO Auto-generated method stub
		this.buyerName = buyerName;
	}
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}
	@Override
	public String getBuyerStreetAddress() {
		// TODO Auto-generated method stub
		return this.buyerStreetAddress;
	}
	@Override
	public String getBuyerCity() {
		// TODO Auto-generated method stub
		return this.buyerCity;
	}
	@Override
	public String getBuyerState() {
		// TODO Auto-generated method stub
		return this.buyerState;
	}
	@Override
	public String getBuyerZipCode() {
		// TODO Auto-generated method stub
		return this.buyerZipCode;
	}
	@Override
	public String getWalletAddress() {
		// TODO Auto-generated method stub
		return this.walletAddress;
	}
	@Override
	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		this.balance = balance;
	}
	@Override
	public void setBuyerStreetAddress(String streetAddress) {
		// TODO Auto-generated method stub
		this.buyerStreetAddress = streetAddress;
	}
	@Override
	public void setBuyerCity(String city) {
		// TODO Auto-generated method stub
		this.buyerCity = city;
	}
	@Override
	public void setBuyerState(String state) {
		// TODO Auto-generated method stub
		this.buyerState = state;
	}
	@Override
	public void setBuyerZipCode(String zipCode) {
		// TODO Auto-generated method stub
		this.buyerZipCode = zipCode;
	}
	
	@Override
	public void setWalletAddress(String walletAddress) {
		// TODO Auto-generated method stub
		this.walletAddress = walletAddress;
	}
	
}