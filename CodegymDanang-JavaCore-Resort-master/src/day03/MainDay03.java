package day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import runningApplication.ApplicationRunningInterface;
import totalSourceJavaAdvantage.BeachHouse;
import totalSourceJavaAdvantage.Customer;
import totalSourceJavaAdvantage.Villa;


public class MainDay03 implements ApplicationRunningInterface{

	public static void main(String[] args) {
		MainDay03 mainDay03 = new MainDay03();
		mainDay03.run();
	}
	
	public static void addAndShowBeachHouseInDay02(){		
		BeachHouse beachHouse1 = new BeachHouse("Beach House Vip1");
		BeachHouse beachHouse2 = new BeachHouse("Beach House Vip2");
		BeachHouse[] arrayBeach = new BeachHouse[2];
		arrayBeach[0] = beachHouse1;
		arrayBeach[1] = beachHouse2;
		
		System.out.println("----------------------------");
		getAllNameBeachByArray(arrayBeach);
	}
	
	public static void getAllNameBeachByArray(BeachHouse[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("BeachHouse "+i+" is name: "+array[i].getName());
		}
	}
	public static void getAllNameVillaByArray(Villa[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Villa "+i+" is name: "+array[i].getName());
		}
	}
	
	public static void addAndShowVillaInDay02() {
		Customer customer1 = new Customer("Nguyen Van A", 20);
		Villa villa1 = new Villa("Villa VIP01",customer1, 4);
		
		Customer customer2 = new Customer("Nguyen Van B", 20);
		Villa villa2 = new Villa("Villa VIP02",customer2, 2);
		
		Customer customer3 = new Customer("Nguyen Van C", 20);
		Villa villa3 = new Villa("Villa VIP03",customer3, 1);
		
		Customer customer4 = new Customer("Nguyen Van D", 20);
		Villa villa4 = new Villa("Villa VIP04",customer4, 5);
		
		Customer customer5 = new Customer("Nguyen Van E", 20);
		Villa villa5 = new Villa("Villa VIP05",customer5, 5);
		
		Villa[] arrayListVilla = new Villa[5];
		arrayListVilla[0] = villa1;
		arrayListVilla[1] = villa2;
		arrayListVilla[2] = villa3;
		arrayListVilla[3] = villa4;
		arrayListVilla[4] = villa5;
		
		System.out.println("----------------------------");
		getAllNameVillaByArray(arrayListVilla);
	}
	

	@Override
	public void run() {
		addAndShowBeachHouseInDay02();
		addAndShowVillaInDay02();
	}

}
