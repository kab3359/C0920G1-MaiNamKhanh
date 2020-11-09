package day13;

public interface AccommodationInterface {
	public static int NUMBER_BED = 1;
	public static int PRICE_ONEDATE = 10;
	
	public float getCostFinal();
	public int getNumberDateStayInResort(int money);
	public void paymentMoneyByVisaCard();
	public void paymentMoneyByMasterCard();
}
