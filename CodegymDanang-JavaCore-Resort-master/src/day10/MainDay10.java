package day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import javax.management.Query;

import runningApplication.ApplicationRunningInterface;

public class MainDay10 implements ApplicationRunningInterface{

	public static void main(String[] args) {
		MainDay10 mainDay10 = new MainDay10();
		mainDay10.run();
	}
	
	public static void runningRequestDay10() {
		Customer customer01 = new Customer("Watcher 01", 13);
		Customer customer02 = new Customer("Watcher 02", 18);
		Customer customer03 = new Customer("Watcher 03", 21);
		
		Queue<Customer> queueCustomer = new LinkedList<>();
		queueCustomer.add(customer01);
		queueCustomer.add(customer02);
		queueCustomer.add(customer03);
		System.out.println("---------------Day 10-----------------");
		showAllCustomerInQueue(queueCustomer);
	}
	
	public static void showAllCustomerInQueue(Queue<Customer> customerQueue) {
		 Iterator i = customerQueue.iterator();
	        while (i.hasNext()) {
	            System.out.println(i.next() + " ");
	        }
	}
	
	@Override
	public void run() {
		runningRequestDay10();
		
	}

}
