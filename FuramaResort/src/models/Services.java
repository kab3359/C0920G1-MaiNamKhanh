package models;

public abstract class Services {
    String id;
    String nameService;
    String areaUsed;
    String costRent;
    String numPeople;
    String typeRent;

    public Services(String id, String nameService, String areaUsed, String costRent, String numPeople, String typeRent) {
        this.id = id;
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.costRent = costRent;
        this.numPeople = numPeople;
        this.typeRent = typeRent;
    }
    public Services() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(String areaUsed) {
        this.areaUsed = areaUsed;
    }

    public String getCostRent() {
        return costRent;
    }

    public void setCostRent(String costRent) {
        this.costRent = costRent;
    }

    public String getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(String numPeople) {
        this.numPeople = numPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }


    public abstract void showInfo();


}
