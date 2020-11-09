package day01;

import java.io.Serializable;

public class Customer implements Serializable{
	
	private String nameCustomer;
	private int ageCustomer;
	
	
	public Customer() {
		this.setNameCustomer(null);
		this.setAgeCustomer(0);
	}
	
	public Customer(String name, int age) {
			this.setNameCustomer(name);
			this.setAgeCustomer(age);
	}
	
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public int getAgeCustomer() {
		return ageCustomer;
	}
	public void setAgeCustomer(int ageCustomer) {
		this.ageCustomer = ageCustomer;
	}


	@Override
	public String toString() {
		return this.nameCustomer+",\t Age: "+this.getAgeCustomer()+".";
	}

}
