package am.aua.aoop.RMI.client;

import am.aua.aoop.RMI.server.AuctionServerRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientConnection {
    private String connectionStr;
    private boolean connected = false;
    private AuctionServerRemote server;

    public ClientConnection(String connectionStr) {
        this.connectionStr = connectionStr;
        connect();
    }

    private void connect() {
        if (!isConnected()) {
            try {
                server = (AuctionServerRemote) Naming.lookup(connectionStr);
                // Flag used by the servlet
                setConnected(true);
            } catch (MalformedURLException e) {
                System.err.println("Malformed URL - " + e);
            } catch (NotBoundException e) {
                System.err.println("Unable to bind the server - " + e);
            } catch (RemoteException e) {
                System.err.println("Unable to contact the server - " + e);
            }
        }
    }

    public synchronized boolean isConnected() {
        return connected;
    }

    public synchronized void setConnected(boolean connected) {
        this.connected = connected;
    }

    public AuctionServerRemote getServer() throws RemoteException {
        if (isConnected()) {
            return server;
        } else {
            throw new RemoteException("Server is dead.");
        }
    }

    public void setServer(AuctionServerRemote server) {
        this.server = server;
    }
}
