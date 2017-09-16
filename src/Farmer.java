import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Farmer implements FarmerInterface{
		
    int farmerID;
    String farmerName;
    String farmerState;
	 

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
   	
}