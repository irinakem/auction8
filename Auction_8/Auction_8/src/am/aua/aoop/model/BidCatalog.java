package am.aua.aoop.model;

import am.aua.aoop.model.Bid;

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

    public Bid getWinningBid(String itemId){
        Bid winningBid = null;
        double highestBid = 0;
        for(Bid bid: bids){
            if(bid.getITEM_ID().equals(itemId) && bid.getAmount() > highestBid){
                highestBid = bid.getAmount();
                winningBid = bid;
            }
        }
        return winningBid;
    }

}
