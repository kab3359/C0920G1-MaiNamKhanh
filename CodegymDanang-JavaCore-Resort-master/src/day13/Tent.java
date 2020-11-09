package day13;

import resortInterface.AccommodationInterface;

public class Tent extends Accommodation implements AccommodationInterface{

	public Tent(String name) {
		this.setName(name);
	}

	@Override
	public float getCostFinal() {
		return 0;
	}

	@Override
	public int getNumberDateStayInResort(int money) {
		return 0;
	}

	@Override
	public void paymentMoneyByVisaCard() {
		System.out.println("Hello. You chooses payment by Visa Card.");
		
	}

	@Override
	public void paymentMoneyByMasterCard() {
		System.out.println("Hello. You chooses payment by Master Card.");
		
	}



}
