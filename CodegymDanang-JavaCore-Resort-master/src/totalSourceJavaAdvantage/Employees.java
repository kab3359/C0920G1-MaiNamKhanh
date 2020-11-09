package totalSourceJavaAdvantage;

import java.util.HashMap;
import java.util.Map;

public class Employees {
	private int idEmployees;
	private String nameEmployees;
	private int ageEmployees;
	private String addressEmployees;
	HashMap<Integer, Employees> employeesManagerHashMap = null;

	
	public Employees(int id, String name, int age, String address) {
		this.setIdEmployees(id);
		this.setNameEmployees(name);
		this.setAddressEmployees(address);
		this.setAgeEmployees(age);
	}
	
	public HashMap<Integer, Employees> addEmployeesToMap( Employees value) {
		if (employeesManagerHashMap == null) {
			employeesManagerHashMap = new HashMap<>();
		}
		employeesManagerHashMap.put(value.getIdEmployees(), value);
		return employeesManagerHashMap;
	}
	
	
	
	
	public int getIdEmployees() {
		return idEmployees;
	}
	public void setIdEmployees(int idEmployees) {
		this.idEmployees = idEmployees;
	}
	public String getNameEmployees() {
		return nameEmployees;
	}
	public void setNameEmployees(String nameEmployees) {
		this.nameEmployees = nameEmployees;
	}
	public int getAgeEmployees() {
		return ageEmployees;
	}
	public void setAgeEmployees(int ageEmployees) {
		this.ageEmployees = ageEmployees;
	}
	public String getAddressEmployees() {
		return addressEmployees;
	}
	public void setAddressEmployees(String addressEmployees) {
		this.addressEmployees = addressEmployees;
	}
	@Override
	public String toString() {
		return "Name : "+this.nameEmployees + "\tAge: " + this.ageEmployees+ ". Address: "+ this.addressEmployees+ "\n";
	}
}
