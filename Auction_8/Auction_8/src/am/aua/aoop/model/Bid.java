package am.aua.aoop.model;

import java.util.UUID;

public class Bid{
    private final String USER_ID;
    private final String ITEM_ID;
    private final String BID_ID;
    private double amount;

    public Bid(String USER_ID, String ITEM_ID, double amount) {
        this.USER_ID = USER_ID;
        this.ITEM_ID = ITEM_ID;
        BID_ID = UUID.randomUUID().toString();
        this.amount = amount;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public String getITEM_ID() {
        return ITEM_ID;
    }

    public String getBID_ID() {
        return BID_ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
