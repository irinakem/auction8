package am.aua.aoop.model;

import java.util.UUID;

public class Item {

    private final String ITEM_ID;

    private String name;
    private String description;
    private double startingPrice;
    private boolean isSold;


    public Item(String name, String description, double startingPrice) {
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        ITEM_ID = UUID.randomUUID().toString();
        isSold = false;
    }

    public String getITEM_ID() {
        return ITEM_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
