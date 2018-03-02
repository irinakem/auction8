package am.aua.aoop.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import am.aua.aoop.HintTextField;

public class ClientFrame extends javax.swing.JFrame implements ActionListener {

    JLabel currentBidJLabel, buttonsJLabel, historyJLabel;
    JTextField currentBidTextField, makeBidTextField;
    JButton makeBidJButton, makeBidDefaultJButton, stopBiddingJButton;
    JTextArea historyTextArea;
    JScrollPane scrollPane;


    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "makeBidJButton":
                //TODO: makeBidJButton
                //implement our usual bid functionality
                // (you can set a default value for bidding, or add one edit text field to give an opportunity to user add value manually)
                historyTextArea.append("New bid added:" + makeBidTextField.getText());

                break;
            case "makeBidDefaultJButton":
                //TODO: makeBidDefaultJButton
                //by clicking on this button, the thread should start bidding automatically
                //(with a default value) after a client is notified that the other user has bid with the bigger amount
                break;
            case "stopBiddingJButton":
                //TODO: stopBiddingJButton
                //stops the default bidding functionality
                break;
        }
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Auction GUI Team 8");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        currentBidJLabel = new JLabel("Current bid price: ");
        currentBidJLabel.setBorder(new EmptyBorder(0,10,5,0));
        currentBidTextField = new JTextField(20);
        currentBidTextField.setEditable(false);

        buttonsJLabel = new JLabel("Select an option: ");
        buttonsJLabel.setBorder(new EmptyBorder(5,10,5,0));

        makeBidJButton = new JButton("Make a bid");
        makeBidDefaultJButton = new JButton("Make a bid by default");
        makeBidTextField = new HintTextField("Enter the value of the bid here");
        makeBidTextField.setBorder(new EmptyBorder(5, 5, 5, 5));
        stopBiddingJButton = new JButton("Stop bidding");

        makeBidJButton.addActionListener(this);
        makeBidJButton.setActionCommand("makeBidJButton");
        makeBidDefaultJButton.addActionListener(this);
        makeBidDefaultJButton.setActionCommand("makeBidDefaultJButton");
        stopBiddingJButton.addActionListener(this);
        stopBiddingJButton.setActionCommand("stopBiddingJButton");

        main.add(currentBidJLabel);
        main.add(currentBidTextField);
        main.add(buttonsJLabel);
        main.add(makeBidTextField);
        main.add(makeBidJButton);
        main.add(makeBidDefaultJButton);
        main.add(stopBiddingJButton);


        historyJLabel = new JLabel("History: ");
        historyJLabel.setBorder(new EmptyBorder(10,10,5,0));
        historyTextArea = new JTextArea(5, 30);
        historyTextArea.setEditable(false);
        scrollPane = new JScrollPane(historyTextArea);

        main.add(historyJLabel);
        main.add(scrollPane);

        main.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.setContentPane(main);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClientFrame clientFrame = new ClientFrame();
                clientFrame.createAndShowGUI();
            }
        });
    }


}
