package models;

import controllers.MainController;

import java.util.ArrayList;
import java.util.List;

public class Villa extends Services {
    String standardRoom;
    String descriptionComfort;
    String areaPool;
    String numFloor;

    public Villa(String id, String nameService, String areaUsed, String costRent, String numPeople, String typeRent, String standardRoom,
                 String descriptionComfort, String areaPool, String numFloor) {
        super(id, nameService, areaUsed, costRent, numPeople, typeRent);
        this.standardRoom = standardRoom;
        this.descriptionComfort = descriptionComfort;
        this.areaPool = areaPool;
        this.numFloor = numFloor;
    }
    public Villa(){};



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

    public String getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(String areaPool) {
        this.areaPool = areaPool;
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
        + "| numPeople: " + numPeople + "| typeRent: " + typeRent + "| standardRoom: " + standardRoom + "| descriptionComfort: " + descriptionComfort
        + "| areaPool: " + areaPool + "| numFloor: " + numFloor);
//        System.out.println("Name: " + nameService);
//        System.out.println("areaUsed: " + areaUsed);
//        System.out.println("costRent: " + costRent);
//        System.out.println("numPeople:" + numPeople);
//        System.out.println("standardRoom: " + standardRoom);
//        System.out.println("descriptionComfort: " + descriptionComfort);
//        System.out.println("areaPool: " + areaPool);
//        System.out.println("numFloor: " + numFloor);
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Villa{");
//        sb.append("standardRoom='").append(standardRoom).append('\'');
//        sb.append(", descriptionComfort='").append(descriptionComfort).append('\'');
//        sb.append(", areaPool='").append(areaPool).append('\'');
//        sb.append(", numFloor='").append(numFloor).append('\'');
//        sb.append(", id='").append(id).append('\'');
//        sb.append(", nameService='").append(nameService).append('\'');
//        sb.append(", areaUsed='").append(areaUsed).append('\'');
//        sb.append(", costRent='").append(costRent).append('\'');
//        sb.append(", numPeople='").append(numPeople).append('\'');
//        sb.append('}');
//        return sb.toString();
//    }
}
