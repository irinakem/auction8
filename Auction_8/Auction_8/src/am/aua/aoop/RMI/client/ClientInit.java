package am.aua.aoop.RMI.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

public class ClientInit {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1099;

        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        } else if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

//        Context namingContext = new InitialContext();
//        System.out.print("RMI registry bindings: ");
//        Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
//        while (e.hasMoreElements())
//            System.out.println(e.nextElement().getName());
//
//        String url = "rmi://localhost/auction";
//        AuctionServerImpl auction = (AuctionServerImpl) namingContext.lookup(url);

        String connectionStr = "rmi://" + host + ":" + port + "/auction";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean end = false;
        while (!end) {
            try {
                ClientConnection connection = new ClientConnection(connectionStr);
                try {
                    System.out.print("There is an item to be sold. You can make a bid\n");
                    System.out.print("Please enter your name:\n");
                    String username = br.readLine();
                    connection.getServer().addUser(username);
                    String auctionUserId = connection.getServer().getUserCatalog().getUserByName(username).getUSER_ID();
                    System.out.print("Please enter your bid amount:\n");
                    double bidAmount = Double.valueOf(br.readLine());
                    String auctionItemId = connection.getServer().getItemCatalog().getItem("Sweets").getITEM_ID();
                    connection.getServer().addBid(auctionUserId, auctionItemId, bidAmount);
                } catch (NumberFormatException nfe) {
                    System.err.println("Incorrect input format. Please try again.");
                }
            } catch (RemoteException e1) {
                System.out.println(e1);
            } catch (IOException e2) {
                System.err.println("Unable to parse your input " + e2);
            }
        }
    }
}
