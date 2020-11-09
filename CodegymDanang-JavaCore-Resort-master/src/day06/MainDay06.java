package day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import runningApplication.ApplicationRunningInterface;


public class MainDay06 implements ApplicationRunningInterface{

	public static void main(String[] args) {
		MainDay06 mainDay06 = new MainDay06();
		mainDay06.run();
	}
	
	public static void addCustomerListInDay06(){	
		Scanner scanner = new Scanner(System.in);
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
		
		
//		music.printElementInLibrary();
		System.out.println(" -------------All Music----------------");
		music.deleteElementInLibrary(choiceGenerics);
		//library : books
		System.out.println(" -----------------------------");
		Library<Book> books = new Library<Book>();
		books.getElementInLibrary().add(new Book("Trở về tuổi thơ"));
		books.getElementInLibrary().add(new Book("Think and Grow Rick"));
		books.printElementInLibrary();
		System.out.println("-------------- Add book -------------");
		String nameBook;
		nameBook = scanner.nextLine();
		System.out.println(nameBook);
		books.addElementInLibrary(new Book(nameBook));
		books.printElementInLibrary();
	}
	

	@Override
	public void run() {
		addCustomerListInDay06();
	}

}
