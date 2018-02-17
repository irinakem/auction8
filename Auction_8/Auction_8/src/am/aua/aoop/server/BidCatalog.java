package am.aua.aoop.server;

import java.util.ArrayList;

public class BidCatalog {

    private ArrayList<Bid> bids;

    public BidCatalog() {
        bids = new ArrayList<>();
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public void createBid(String itemId, String userId, double amount){
        bids.add(new Bid(userId, itemId, amount));
    }

    //TODO
    public Bid getWinningBid(String itemId){
        String myItemID = itemId;
        Bid winningBid = bids.get(0);
        double highestBid = 0;
        for(Bid bid: bids){
            // the problem is in the if condition
            if(bid.getITEM_ID().equals(myItemID) && bid.getAmount() > highestBid){
                highestBid = bid.getAmount();
                winningBid = bid;
            }
        }
        return winningBid;
    }

}
