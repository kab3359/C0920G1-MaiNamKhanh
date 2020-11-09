package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import runningApplication.ApplicationRunningInterface;


public class MainDay01 implements ApplicationRunningInterface{

	public static void main(String[] args) {
		MainDay01 mainDay01 = new MainDay01();
		mainDay01.run();
	}
	
	public static void showTask01InDay01(){		
		Customer customer1 = new Customer("Nguyen Van A", 20);
		Villa villa1 = new Villa("Villa VIP01",customer1, 4);
		System.out.println("Name Customer: "+villa1.getCustomerInVilla(customer1));
		System.out.println("Cost         :"+villa1.getCostFinal());
	}
	
	public static void showTask02InDay01() {
		checkAndShowTimeOpenSwimmingPool();
		
		Scanner scanner = new Scanner(System.in);
		Customer customer1 = new Customer("Nguyen Van A", 20);
		Villa villa1 = new Villa("Villa VIP01",customer1, 4);
		System.out.println("----------------------------");
		System.out.print("Input money: ");
		int moneyVilla = scanner.nextInt();
		System.out.println(villa1.getNumberDateStayInResort(moneyVilla));
	}
	
	public static void checkAndShowTimeOpenSwimmingPool() {
		float timeSwimming;
		SwimmingPool swp = new SwimmingPool();
		swp.getOpenTimeInScreen();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input time Customer request: ");
		timeSwimming = scanner.nextFloat();
		if (timeSwimming < 9) {
			System.out.println("Go back at 9:00 am");
		}
		else {
			System.out.println("Welcome...");
		}
	}

	@Override
	public void run() {
		showTask01InDay01();
		showTask02InDay01();
	}

}
