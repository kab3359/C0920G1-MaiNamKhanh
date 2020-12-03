package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class Room extends Services {
    private String freeService;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append(", id='").append(id).append('\'');
        sb.append(", nameService='").append(nameService).append('\'');
        sb.append(", areaUsed='").append(areaUsed).append('\'');
        sb.append(", costRent='").append(costRent).append('\'');
        sb.append(", numPeople='").append(numPeople).append('\'');
        sb.append(", typeRent='").append(typeRent).append('\'');
        sb.append(", freeService='").append(freeService).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
