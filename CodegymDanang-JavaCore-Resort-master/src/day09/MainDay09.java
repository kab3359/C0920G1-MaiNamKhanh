package day09;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import runningApplication.ApplicationRunningInterface;

public class MainDay09 implements ApplicationRunningInterface{

	public static void main(String[] args) {
		MainDay09 mainDay09 = new MainDay09();
		mainDay09.run();
	}
	
	public static void runningRequestDay09() {
		Set<Car> setCarInResort = new HashSet<>();
		Car carRed = new Car("91A1234");
		setCarInResort.add(carRed);
		Scanner scanner = new Scanner(System.in);
		do {
			showAllElementChoice();
			int choices = scanner.nextInt();scanner.nextLine();
			if (choices == 1 ) {
				setCarInResort = addCarToSet(setCarInResort, scanner);
			}
			else {
				printSetList(setCarInResort);
				break;
			}
		} while (true);
		showCarHaveInPark(setCarInResort);
	}
	
	public static void showCarHaveInPark(Set<Car> setCarInResort) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input idCar comed here.");
		String idCarInput = scanner.nextLine();
		Iterator iterator = setCarInResort.iterator();
		while(iterator.hasNext()){
			checkCar(iterator, idCarInput);
		}
	}
	public static void checkCar(Iterator iterator, String idCar) {
		Car idCarInSet = (Car) iterator.next();
		if (idCarInSet.getNumberCar().equals(idCar)) {
			System.out.println(idCarInSet.getNumberCar()+" comed in here. ABC car park. ");
		}
		else if(!iterator.hasNext()) {
			System.out.println("Not found in Set.");
		}
	}
	
	
	public static void printSetList(Set<Car> arraySet) {
		for (Car value : arraySet) {
            System.out.println(value.toString());
        }
	}
	public static void showAllElementChoice() {
		System.out.println("-----------------------------");
		System.out.println(" What are you choice?");
		System.out.println(" 1. Add a Car");
		System.out.println(" 2. Exit");
	}
	public static Set<Car> addCarToSet(Set<Car> hashSetCar, Scanner scanner) {
		System.out.println("Input ID Car, please.");
		String element = scanner.nextLine();
		Car car = new Car(element);
		if (checkValueInSet(hashSetCar, car)) {
			return hashSetCar;
		}
		else {
			hashSetCar.add(car);
			System.out.println("Add success.");
			return hashSetCar;
		}
	}
	public static boolean checkValueInSet(Set<Car> hashSetCar, Car nameCar) {
		Boolean check = null;
		for (Car value : hashSetCar) {
			if (value.toString().equals(nameCar.toString())) {
				System.out.println(value.toString().equals(nameCar.toString()));
				System.out.println("Error: It's exited.");
				check = true;
			}
			else {
				check = false;
			}
		}
		return check;
	}

	@Override
	public void run() {
		runningRequestDay09();
		
	}

}
