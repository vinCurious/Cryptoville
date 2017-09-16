package model.Product;
public interface ProductInterface{
	
	int getProductID();
	String getProductName();
	double getProductPrice();
	
	void setProductID(int productID);
	void setProductName(String productName);
	void setProductPrice(double productPrice);
}