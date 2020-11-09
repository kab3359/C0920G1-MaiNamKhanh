package models;

public abstract class Services {
    String id;
    String nameService;
    double areaUsed;
    double costRent;
    int numPeople;

    public Services(String id, String nameService, double areaUsed, double costRent, int numPeople) {
        this.id = id;
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.costRent = costRent;
        this.numPeople = numPeople;
    }

    public Services() {

    }

    public abstract void showInfo();


}
