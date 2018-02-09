package am.aua.aoop.model;

import am.aua.aoop.BidCatalog;
import am.aua.aoop.ItemCatalog;
import am.aua.aoop.UserCatalog;

public class Auction {
    private BidCatalog bidCatalog;
    private UserCatalog userCatalog;
    private ItemCatalog itemCatalog;

    public Auction(BidCatalog bidCatalog, UserCatalog userCatalog, ItemCatalog itemCatalog) {
        this.bidCatalog = bidCatalog;
        this.userCatalog = userCatalog;
        this.itemCatalog = itemCatalog;
    }

    public void addItem(String name, String description, double startingPrice) {
        itemCatalog.createItem(name, description, startingPrice);
    }

    public void addUser(String username){
        userCatalog.createUser(username);
    }

    public void addBid(String itemId, String userId, double amount){
        bidCatalog.createBid(userId, itemId, amount);
    }

    public String findWinner(String itemId){
        return bidCatalog.getWinningBid(itemId).getUSER_ID();
    }
}
