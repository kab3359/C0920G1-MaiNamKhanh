package day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import runningApplication.ApplicationRunningInterface;


public class MainDay04 implements ApplicationRunningInterface{

	public static void main(String[] args) {
		MainDay04 mainDay04 = new MainDay04();
		mainDay04.run();
	}
	
	public static void addCustomerListInDay04(){		
		Customer customer1 = new Customer("Nguyen Van A", 20);
		Customer customer2 = new Customer("Nguyen Van 1", 20);
		Customer customer3 = new Customer("Nguyen Van 2", 20);
		Customer customer4 = new Customer("Nguyen Van 3", 20);
		Customer customer5 = new Customer("Nguyen Van 4", 20);
		Customer customer6 = new Customer("Nguyen Van 5", 20);
		Customer customer7 = new Customer("Nguyen Van 6", 20);
		Customer customer8 = new Customer("Nguyen Van 7A", 20);
		Customer customer9 = new Customer("Nguyen Van 8A", 20);
		Customer customer10 = new Customer("Nguyen Van 9A", 20);
		
		List<Customer> arrayListCustomerList = new ArrayList<>();
		arrayListCustomerList.add(customer1);
		arrayListCustomerList.add(customer2);
		arrayListCustomerList.add(customer3);
		arrayListCustomerList.add(customer4);
		arrayListCustomerList.add(customer5);
		arrayListCustomerList.add(customer6);
		arrayListCustomerList.add(customer7);
		arrayListCustomerList.add(customer8);
		arrayListCustomerList.add(customer9);
		arrayListCustomerList.add(customer10);
		
		showCustomerListInDay04(arrayListCustomerList);
	}
	
	public static void showCustomerListInDay04(List<Customer> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.println("Villa "+i+" is name: "+array.get(i).getNameCustomer() );
		}
	}
	

	@Override
	public void run() {
		addCustomerListInDay04();
	}

}
