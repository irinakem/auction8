package am.aua.aoop.model;

import java.util.ArrayList;

public class BidCatalog {

    int count = 0;

    private ArrayList<Bid> bids;

    public BidCatalog() {
        bids = new ArrayList<>();
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public int createBid(String itemId, String userId, double amount) {

        count++;
        bids.add(new Bid(userId, itemId, amount, count));
        return count;
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
