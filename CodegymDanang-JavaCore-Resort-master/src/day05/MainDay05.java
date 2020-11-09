package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import runningApplication.ApplicationRunningInterface;


public class MainDay05 implements ApplicationRunningInterface{

	public static void main(String[] args) {
		MainDay05 mainDay05 = new MainDay05();
		mainDay05.run();
	}
	
	public static void choosePaymentInDay05(Villa villa1){
		
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println(" -----------------------------");
			System.out.println("| Do you choose payment?      |");
			System.out.println("| 1. Visa                     |");
			System.out.println("| 2. Master Card              |");
			System.out.println(" -----------------------------");
			choice = scanner.nextInt();
		} while (choice>2);
		
		switch (choice) {
		case 1:
			villa1.paymentMoneyByVisaCard();
			break;
		case 2:
			villa1.paymentMoneyByMasterCard();
			break;

		default:

		}
	}
	
	

	@Override
	public void run() {
		Customer customer1 = new Customer("Nguyen Van A", 20);
		Villa villa1 = new Villa("Villa VIP01",customer1, 4);
		choosePaymentInDay05(villa1);
	}

}
