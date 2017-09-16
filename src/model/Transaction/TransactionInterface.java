package model.Transaction;
import model.Product.Product;

public interface TransactionInterface{
	
	int getFarmerID();
	Product getProduct();
	
	void setFarmerID(int farmerID);
	void setProduct(Product newProduct);
}