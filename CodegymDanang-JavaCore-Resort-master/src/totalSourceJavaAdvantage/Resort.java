package totalSourceJavaAdvantage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import resortInterface.ResortInterface;

public class Resort implements ResortInterface{
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		float timeSwimming;
		int numberVilla = 0;
		
		Customer customer1 = new Customer("Nguyen Van A", 20);
		Villa villa1 = new Villa("Villa VIP01",customer1, 4);
		
		Customer customer2 = new Customer("Nguyen Van B", 20);
		Villa villa2 = new Villa("Villa VIP02",customer2, 2);
		
		Customer customer3 = new Customer("Nguyen Van C", 20);
		Villa villa3 = new Villa("Villa VIP03",customer3, 1);
		
		Customer customer4 = new Customer("Nguyen Van D", 20);
		Villa villa4 = new Villa("Villa VIP04",customer4, 5);
		
		List<Villa> arrayListVilla = new ArrayList<>();
		arrayListVilla.add(villa1);
		arrayListVilla.add(villa2);
		arrayListVilla.add(villa3);
		arrayListVilla.add(villa4);
		
		while (!checkEmplyVilla(numberVilla)) {
			if (checkEmplyVilla(numberVilla)) {
				numberVilla = 0;
			} else {
				numberVilla = addVilla(villa1, customer1, numberVilla);
				System.out.println(numberVilla);
			}		
			
		}
		
		
		
		SwimmingPool swp = new SwimmingPool();
		swp.getOpenTimeInScreen();
		
		System.out.print("Input time Customer request: ");
		timeSwimming = scanner.nextFloat();
		if (timeSwimming < 9) {
			System.out.println("Go back at 9:00 am");
		}
		else {
			System.out.println("Welcome...");
		}
		
		System.out.println("----------------------------");
		getAllVillaByName(arrayListVilla);
		
		System.out.println("----------------------------");
		System.out.print("Input money: ");
		int moneyVilla = scanner.nextInt();
		System.out.println(villa1.getNumberDateStayInResort(moneyVilla));
		
		BeachHouse beachHouse1 = new BeachHouse("Beach House Vip1");
		BeachHouse beachHouse2 = new BeachHouse("Beach House Vip2");
		
		BeachHouse[] arrayBeach = new BeachHouse[2];
		arrayBeach[0] = beachHouse1;
		arrayBeach[1] = beachHouse2;
		
		System.out.println("----------------------------");
		getAllNameBeachByArray(arrayBeach);
		
		List<BeachHouse> arrayListBeachHouse = new ArrayList<>();
		arrayListBeachHouse.add(beachHouse1);
		arrayListBeachHouse.add(beachHouse2);
		
		System.out.println("----------------------------");
		getAllBeahcHouseByName(arrayListBeachHouse);
		
		;
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
		
		System.out.println(" ----------------   ***   ---------------");
		System.out.println(" ----------------   day6  ---------------");
		
		Library<Music> music = new Library<Music>();
		music.getElementInLibrary().add(new Music("How long."));
		music.getElementInLibrary().add(new Music("Burn It Up."));
		music.getElementInLibrary().add(new Music("Beautiful."));
		
		music.printElementInLibrary();
		
		int choiceGenerics;
		int idElementInArray = 0;
		
		do {
			System.out.println(" -----------------------------");
			System.out.println("| Do you want delete?      |");
			for (; idElementInArray < music.getElementInLibrary().size(); idElementInArray++) {
				System.out.println("| "+(idElementInArray+1)+". "+music.getElementInLibrary().get(idElementInArray).getName());				
			}
			System.out.println(" -----------------------------");
			
			choiceGenerics = scanner.nextInt();scanner.nextLine();
			
			
		} while (choiceGenerics > music.getElementInLibrary().size());
		
		
		music.printElementInLibrary();
		music.deleteElementInLibrary(choiceGenerics);
		//library : books
		Library<Book> books = new Library<Book>();
		books.getElementInLibrary().add(new Book("Trở v�? tuổi thơ"));
		books.getElementInLibrary().add(new Book("Think and Grow Rick"));
		books.printElementInLibrary();
		System.out.println("-------------- Add book -------------");
		String nameBook;
		nameBook = scanner.nextLine();
		System.out.println(nameBook);
		books.addElementInLibrary(new Book(nameBook));
		books.printElementInLibrary();
		
	}
	
	
	public static boolean checkEmplyVilla(int numberCheck) {
		if (numberCheck>4) {
			System.out.println("Villa in Resort is full.");
//			numberCheck = 0;
			return true;
		} else {
			return false;
		}
	}
		
	public static int addVilla(Villa villa, Customer customer, int numberVilla) {
		int okfine =  numberVilla;
		
		if (villa.getCheckCustomerInVilla(customer)!=true) {
			System.out.println("Error when add Customer.");			
		} else {
			
			okfine++;
			System.out.println("Name Customer: "+villa.getNameCustomerInVilla(customer));
			System.out.println("Cost         :"+villa.getCostFinal());			
		}
		
		return okfine;
	}
	
	public static void getAllVillaByName(List<Villa> arrayListVilla) {
		for (int i = 0; i < arrayListVilla.size(); i++) {
			System.out.println("Villa "+i+" is name: "+arrayListVilla.get(i).getName() );
		}
	}
	public static void getAllNameBeachByArray(BeachHouse[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("BeachHouse "+i+" is name: "+array[i].getName());
		}
	}
	public static void getAllBeahcHouseByName(List<BeachHouse> arrayListBeach) {
		for (int i = 0; i < arrayListBeach.size(); i++) {
			System.out.println("BeachHouse "+i+" is name: "+arrayListBeach.get(i).getName() );
		}
	}

}
