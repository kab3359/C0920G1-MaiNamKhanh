package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class Room extends Services {
    String freeService;

    public Room(String id, String nameService, String areaUsed, String costRent, String numPeople, String typeRent, String freeService) {
        super(id, nameService, areaUsed, costRent, numPeople, typeRent);
        this.freeService = freeService;
    }
    public Room(){}

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + id + "| Name: " + nameService + "| areaUsed: " + areaUsed + "| costRent: " + costRent
                + "| numPeople: " + numPeople + "| typeRent: " + typeRent + "| freeService: " + freeService);
    }
}
