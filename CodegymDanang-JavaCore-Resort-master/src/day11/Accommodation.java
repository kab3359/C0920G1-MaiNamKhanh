package day11;

public abstract class Accommodation {
	protected int totalPrice;
	protected int totalDate;
	protected String name;
	protected int numberBed;
	protected float size;
	
	
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public int getTotalDate() {
		return totalDate;
	}
	public void setTotalDate(int totalDate) {
		this.totalDate = totalDate;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getNumberBed() {
		return numberBed;
	}
	public void setNumberBed(int numberBed) {
		this.numberBed = numberBed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
