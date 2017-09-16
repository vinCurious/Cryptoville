package model.Transaction;
import model.Product.Product;

public class Transaction implements TransactionInterface {
		
	int farmerID;
	Product emittedProduct;
	
	Transaction(){
		
	}
	
	public Transaction(int farmerID, Product currentProduct){
		this.farmerID = farmerID;
		this.emittedProduct = currentProduct;
	}
	
	@Override
	public int getFarmerID() {
		// TODO Auto-generated method stub
		return this.farmerID;
	}
	
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return this.emittedProduct;
	}
	
	@Override
	public void setFarmerID(int farmerID) {
		// TODO Auto-generated method stub
		this.farmerID = farmerID;
	}
	
	@Override
	public void setProduct(Product product) {
		// TODO Auto-generated method stub
		this.emittedProduct = product;
	}
	
}