package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class Room extends Services {
    String freeService;
    private List<Services> roomList = new ArrayList<>();

    public Room(String id, String nameService, double areaUsed, double costRent, int numPeople, String freeService) {
        super(id, nameService, areaUsed, costRent, numPeople);
        this.freeService = freeService;
    }
    public Room(){}

    public void addRoom(){
        int idRoom = (roomList.size() > 0) ? (roomList.size() + 1) : 1;
        System.out.println("product id = " + idRoom);
        nameService = "Villa";
        inputAreaUsed();
        inputCostRent();
        inputNumPeople();
        inputFreeServices();
        Room room = new Room(id, nameService, areaUsed, costRent, numPeople, freeService);
        roomList.add(room);
    }

    private void inputFreeServices() {
        System.out.println("Enter freeServices:");
        freeService = MainController.input.nextLine();
    }


    private void inputNumPeople() {
        System.out.println("Enter numPeople");
        numPeople = MainController.input.nextInt();
    }

    private void inputCostRent() {
        System.out.println("Enter costRent");
        costRent = MainController.input.nextDouble();
    }

    private void inputAreaUsed() {
        System.out.println("Enter areaUsed");
        areaUsed = MainController.input.nextDouble();
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + nameService);
        System.out.println("areaUsed: " + areaUsed);
        System.out.println("costRent: " + costRent);
        System.out.println("numPeople:" + numPeople);
        System.out.println("freeService: " + freeService);
    }
}
