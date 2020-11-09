package day01;


public class SwimmingPool {

	private String openTime;
	
	public SwimmingPool() {
		this.setOpenTime("9:00 am");
	}
	
	public void getOpenTimeInScreen() {
		System.out.println("Swimming open at "+getOpenTime());
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

}
