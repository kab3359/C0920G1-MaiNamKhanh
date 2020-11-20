package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class House extends Services {
    String standardRoom;
    String descriptionComfort;
    String numFloor;

    public House(String id, String nameService, String areaUsed, String costRent, String numPeople, String typeRent,
                  String standardRoom, String descriptionComfort, String numFloor) {
        super(id, nameService, areaUsed, costRent, numPeople, typeRent);
        this.standardRoom = standardRoom;
        this.descriptionComfort = descriptionComfort;
        this.numFloor = numFloor;
    }
    public House(){}

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionComfort() {
        return descriptionComfort;
    }

    public void setDescriptionComfort(String descriptionComfort) {
        this.descriptionComfort = descriptionComfort;
    }

    public String getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(String numFloor) {
        this.numFloor = numFloor;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + id + "| Name: " + nameService + "| areaUsed: " + areaUsed + "| costRent: " + costRent
                + "| numPeople: " + numPeople + "| typeRent: " + typeRent + "| standardRoom: " + standardRoom + "| descriptionComfort: "
                + descriptionComfort + "| numFloor: " + numFloor);
    }
}
