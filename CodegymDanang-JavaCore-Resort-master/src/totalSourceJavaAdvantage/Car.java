package totalSourceJavaAdvantage;

public class Car {
	
	private String numberCar;
	
	public Car(String numberCar) {
		this.setNumberCar(numberCar);
	}

	public String getNumberCar() {
		return numberCar;
	}

	public void setNumberCar(String numberCar) {
		this.numberCar = numberCar;
	}
	
	@Override
	public String toString() {
		return this.numberCar.toString();
	}
	

}
