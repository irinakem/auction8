package am.aua.aoop.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    void addBid(String itemId, String userId, double amount) throws RemoteException;

    String findWinner(String itemId) throws RemoteException;
}
