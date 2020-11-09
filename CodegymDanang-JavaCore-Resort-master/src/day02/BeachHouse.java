package day02;

import resortInterface.AccommodationInterface;
import resortInterface.BeachHouseInterface;

public class BeachHouse implements AccommodationInterface{
	private int totalPrice;
	private int totalDate;
	private String name;
	private int numberBed;
	private float size;
	
	public int getTotalDate() {
		return totalDate;
	}


	public void setTotalDate(int totalDate) {
		this.totalDate = totalDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumberBed() {
		return numberBed;
	}


	public void setNumberBed(int numberBed) {
		this.numberBed = numberBed;
	}


	public float getSize() {
		return size;
	}


	public void setSize(float size) {
		this.size = size;
	}


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
