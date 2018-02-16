package am.aua.aoop.RMI.server;

import am.aua.aoop.model.ItemCatalog;
import am.aua.aoop.model.UserCatalog;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuctionServerRemote extends Remote {
    int addBid(String itemId, String userId, double amount) throws RemoteException;

    //Each client makes a bid with the identified count. Server response should notify the client that he make a bid with the count.
    void addUser(String username) throws RemoteException;

    ItemCatalog getItemCatalog() throws RemoteException;

    UserCatalog getUserCatalog() throws RemoteException;
}
