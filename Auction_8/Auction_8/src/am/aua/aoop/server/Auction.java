package am.aua.aoop.server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Auction extends UnicastRemoteObject implements IServer{
    private BidCatalog bidCatalog;
    private UserCatalog userCatalog;
    private ItemCatalog itemCatalog;

    public Auction(BidCatalog bidCatalog, UserCatalog userCatalog, ItemCatalog itemCatalog) throws RemoteException{
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

    public void addBid(String itemId, String userId, double amount) throws RemoteException{
        bidCatalog.createBid(userId, itemId, amount);
    }

    public String findWinner(String itemId) throws RemoteException{
        return bidCatalog.getWinningBid(itemId).getUSER_ID();
    }
}
