package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class Villa extends Services {
    String standardRoom;
    String descriptionComfort;
    double areaPool;
    int numFloor;
    private List<Services> villaList = new ArrayList<>();

    private Villa(String id, String nameService, double areaUsed, double costRent, int numPeople, String standardRoom, String descriptionComfort, double areaPool, int numFloor) {
        super(id, nameService, areaUsed, costRent, numPeople);
        this.standardRoom = standardRoom;
        this.descriptionComfort = descriptionComfort;
        this.areaPool = areaPool;
        this.numFloor = numFloor;
    }
    public Villa(){};

    public void addVilla(){
        int idVilla = (villaList.size() > 0) ? (villaList.size() + 1) : 1;
        System.out.println("product id = " + idVilla);
        nameService = "Villa";
        inputAreaUsed();
        inputCostRent();
        inputNumPeople();
        inputStandardRoom();
        MainController.input.nextLine();
        inputDescriptionComfort();
        inputAreaPool();
        inputNumFloor();
        Villa villa = new Villa(id, nameService, areaUsed, costRent, numPeople, standardRoom, descriptionComfort, areaPool, numFloor);
        villaList.add(villa);
    }

    private void inputNumFloor() {
        System.out.println("Enter numFloor");
        numFloor = MainController.input.nextInt();
    }

    private void inputAreaPool() {
        System.out.println("Enter areaPool");
        areaPool = MainController.input.nextDouble();
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
        System.out.println("areaPool: " + areaPool);
        System.out.println("numFloor: " + numFloor);
    }
}
