package day12;

import resortInterface.AccommodationInterface;

public class Villa extends Accommodation implements day01.AccommodationInterface{
		
	public Villa(String nameVilla, Customer customer, int totalDate) {
		this.name = nameVilla;
		this.totalDate = totalDate;
	}
	@Override
	public float getCostFinal() {
		return this.PRICE_ONEDATE*this.getTotalDate();
		
	}

	public String getCustomerInVilla(Customer customer) {
		return customer.toString()+"";
	}
	
	public String getNameCustomerInVilla(Customer customer) {
		return customer.getNameCustomer();
	}
	public boolean getCheckCustomerInVilla(Customer customer) {
		if (customer.getNameCustomer()==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int getNumberDateStayInResort(int money) {
		int date = 0;
		switch (money) {
		case 100:
			date = money/this.PRICE_ONEDATE;
			break;
		case 50:
			date = money/this.PRICE_ONEDATE;
			break;
		case 30:
			date = money/this.PRICE_ONEDATE;
			break;
		default:
			date = 1;
		}
		return date;
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
