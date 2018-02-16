package am.aua.aoop.RMI.server;

import am.aua.aoop.model.BidCatalog;
import am.aua.aoop.model.ItemCatalog;
import am.aua.aoop.model.UserCatalog;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuctionServerImpl extends UnicastRemoteObject implements AuctionServerRemote {
    private BidCatalog bidCatalog;
    private UserCatalog userCatalog;
    private ItemCatalog itemCatalog;

    public AuctionServerImpl(BidCatalog bidCatalog, UserCatalog userCatalog, ItemCatalog itemCatalog) throws RemoteException {
        super();
        this.bidCatalog = bidCatalog;
        this.userCatalog = userCatalog;
        this.itemCatalog = itemCatalog;
    }

    public void addItem(String name, String description, double startingPrice) {
        itemCatalog.createItem(name, description, startingPrice);
    }

    public void addUser(String username) {
        userCatalog.createUser(username);
    }

    public int addBid(String itemId, String userId, double amount) {
        int response = bidCatalog.createBid(userId, itemId, amount);
        return response;

    }

    public String findWinner(String itemId) {
        return bidCatalog.getWinningBid(itemId).getUSER_ID();
    }

    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }

    @Override
    public UserCatalog getUserCatalog() {
        return userCatalog;
    }
}
