package am.aua.aoop.client;

import am.aua.aoop.server.Auction;
import am.aua.aoop.server.User;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class Client {

//    @Override
//    public void addBid(String itemId, String userId, double amount) throws RemoteException {
//        try {
//            Auction auction = (Auction) Naming.lookup("rmi://localhost/auction");
//            auction.addBid(itemId, userId, amount);
//
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public String findWinner(String itemId) throws RemoteException {
//        String winner = null;
//        try {
//            Auction auction = (Auction) Naming.lookup("rmi://localhost/auction");
//            winner =  auction.findWinner(itemId);
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return winner;
//    }

    public static void main(String[] args) {
        User user = new User("Olya");


        try {

            Auction auction = (Auction) Naming.lookup("rmi://localhost/auction");
            auction.addItem("smth","ssmth",1);
            String item_id =  auction.getItem_ID("smth");

            auction.addBid(item_id, user.getUSER_ID(), 100);

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
            }
    }
}
