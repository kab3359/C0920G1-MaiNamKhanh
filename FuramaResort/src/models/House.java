package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class House extends Services {
    String standardRoom;
    String descriptionComfort;
    int numFloor;
    private List<Services> houseList = new ArrayList<>();

    private House(String id, String nameService, double areaUsed, double costRent, int numPeople, String standardRoom, String descriptionComfort, int numFloor) {
        super(id, nameService, areaUsed, costRent, numPeople);
        this.standardRoom = standardRoom;
        this.descriptionComfort = descriptionComfort;
        this.numFloor = numFloor;
    }
    public House(){}

    public void addHouse(){
        int idHouse = (houseList.size() > 0) ? (houseList.size() + 1) : 1;
        System.out.println("product id = " + idHouse);
        nameService = "House";
        inputAreaUsed();
        inputCostRent();
        inputNumPeople();
        inputStandardRoom();
        inputDescriptionComfort();
        inputNumFloor();
        House house = new House(id, nameService, areaUsed, costRent, numPeople, standardRoom, descriptionComfort, numFloor);
        houseList.add(house);
    }

    private void inputNumFloor() {
        System.out.println("Enter numFloor");
        numFloor = MainController.input.nextInt();
    }

    private void inputDescriptionComfort() {
        System.out.println("Enter descriptionComfort");
        descriptionComfort = MainController.input.nextLine();
    }

    private void inputStandardRoom() {
        System.out.println("Enter standardRoom");
        standardRoom = MainController.input.nextLine();
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
        System.out.println("standardRoom: " + standardRoom);
        System.out.println("descriptionComfort: " + descriptionComfort);
        System.out.println("numFloor: " + numFloor);
    }
}
