package day13;

import resortInterface.AccommodationInterface;
import resortInterface.BeachHouseInterface;

public class BeachHouse extends Accommodation implements AccommodationInterface{
	
	public BeachHouse(String nameBeachHouse) {
		this.name = nameBeachHouse;
	}
	
	
	public String getNameCustomerInVilla(Customer customer) {
		return customer.getNameCustomer();
	}
	
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public float getCostFinal() {
		return this.PRICE_ONEDATE*this.getTotalDate();
	}


	@Override
	public int getNumberDateStayInResort(int money) {
		// TODO Auto-generated method stub
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
