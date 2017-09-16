public class Product implements ProductInterface {

	int productID;
	String productName;
	double price;

	Product(){
		
	}
	
	Product(int productID, String productName, double price){
		this.productID = productID;
		this.productName = productName;
		this.price = price;
	}
	
	@Override
	public int getProductID() {
		// TODO Auto-generated method stub
		return this.productID;
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return this.productName;
	}

	@Override
	public double getProductPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	public void setProductID(int productID) {
		// TODO Auto-generated method stub
		this.productID=productID;
	}

	@Override
	public void setProductName(String productName) {
		// TODO Auto-generated method stub
		this.productName=productName;
	}

	@Override
	public void setProductPrice(double productPrice) {
		// TODO Auto-generated method stub
		this.price = productPrice;
	}
}