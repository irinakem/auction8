package am.aua.aoop.RMI.server;

import am.aua.aoop.model.BidCatalog;
import am.aua.aoop.model.ItemCatalog;
import am.aua.aoop.model.UserCatalog;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class ServerInit {
    private static final String DEFAULT_FILENAME = "auction";

    public static void main(String[] args) throws RemoteException, NamingException {
        String host = "localhost";
        int port = 1099;

        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        } else if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        UserCatalog userCatalog = new UserCatalog();
        ItemCatalog itemCatalog = new ItemCatalog();
        BidCatalog bidCatalog = new BidCatalog();
        AuctionServerImpl auction = new AuctionServerImpl(bidCatalog, userCatalog, itemCatalog);

        Context namingContext = new InitialContext();
        namingContext.bind("rmi:auction", auction);
//        LocateRegistry.createRegistry(port);
//        Registry reg = LocateRegistry.getRegistry(host, port);
//        reg.rebind("auction", auction);

    }
}
