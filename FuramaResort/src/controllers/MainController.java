package controllers;

import models.House;
import models.Room;
import models.Villa;

import java.util.Scanner;

public class MainController {
    public  static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//        ProductManager productManager = new ProductManager();
        String choose = null;
        boolean exit = true;
        while (exit){
            displayMainMenu();
            choose = input.nextLine();
            switch (choose){
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
                case "0":
                    exit = false;
                    break;
                default:
                    System.out.println("sai");
            }
        }
    }
    public static void displayMainMenu(){
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Exit");
    }
    public static void addNewServices() {
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");
        String choose = null;
        boolean exit = true;
        while (exit) {
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    Villa villa = new Villa();
                    villa.addVilla();
                    break;
                case "2":
                    House house = new House();
                    house.addHouse();
                    break;
                case "3":
                    Room room = new Room();
                    room.addRoom();
                    break;
                case "4":
                    displayMainMenu();
                    break;
                case "0":
                    exit = false;
                    break;
                default:
                    System.out.println("sai");
                    break;
            }
        }
    }
    public static void showServices(){
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Name Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        String choose = null;
        boolean exit = true;
        while (exit) {
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    Villa villa = new Villa();
                    villa.showInfo();
            }
        }
    }
}