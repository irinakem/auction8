package am.aua.aoop.server;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class Registry {

    public static void main(String[] args) {
        try {

            Auction          auction = new Auction(new BidCatalog(), new UserCatalog(), new ItemCatalog());
            Context namingContext = new InitialContext();
            namingContext.bind("rmi://localhost/auction", auction);
        } catch (RemoteException e) {
            e.printStackTrace();
        }catch (NamingException e){
            e.printStackTrace();
        }
    }
}
