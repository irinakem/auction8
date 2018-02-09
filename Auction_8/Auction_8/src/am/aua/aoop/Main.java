package am.aua.aoop;

import java.util.Scanner;
import am.aua.aoop.model.*;

public class Main {
    public static void main(String[] args){

        UserCatalog userCatalog = new UserCatalog();
        ItemCatalog itemCatalog = new ItemCatalog();
        BidCatalog bidCatalog = new BidCatalog();

        Auction auction = new Auction(bidCatalog, userCatalog, itemCatalog);

        auction.addItem("Sweets","Tasty chocolate sweets", 10);
        String itemID = itemCatalog.getItem("Sweets").getITEM_ID();
        auction.addUser("Irina");
        auction.addUser("Mikayel");
        auction.addUser("Olya");

        Scanner in = new Scanner(System.in);
        String userBidInput;

        for (User user : userCatalog.getUsers()) {
            System.out.println("Please enter your bid, " + user.getUserName());
            Double startingPrice = itemCatalog.getItem("Sweets").getStartingPrice();
            System.out.println("\nYour bid should be higher than the starting price: " + startingPrice + "\n");
            if ((userBidInput = in.nextLine()) != null && Double.valueOf(userBidInput) >= startingPrice) {
                auction.addBid(itemID, user.getUSER_ID(),Double.valueOf(userBidInput));
            }
        }

        String winnerName = (userCatalog.getUser(auction.findWinner(itemID))).getUserName();
        System.out.println("Congratulations to the winner: " + winnerName);
    }


}
