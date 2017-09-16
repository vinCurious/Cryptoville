public interface TransactionInterface{
	
	int getFarmerID();
	Product getProduct();
	
	void setFarmerID(int farmerID);
	void setProduct(Product newProduct);
}