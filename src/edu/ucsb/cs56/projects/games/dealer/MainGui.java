package edu.ucsb.cs56.projects.games.dealer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Main menu to select the game you want to play
 *  @author Eric Xiao, Kin Kwan Poon
 *  @version CS56, Fall 2016
 */

public class MainGui {
    private JFrame frame;
    private JButton DealerButton;
    private JButton BlackjackButton;
    private JPanel panel;
    private JLabel prompt;

    public static void main(String[] args) {
	MainGui gui = new MainGui();
	gui.go();
    }

    public void go() {
	prompt = new JLabel("Select a game to play");
	frame = new JFrame("Games");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	DealerButton = new JButton("Dealer");
	DealerButton.addActionListener(new DealerListener());
	BlackjackButton = new JButton("Blackjack");
	BlackjackButton.addActionListener(new BlackjackListener());
	Dimension d = new Dimension(250, 50);
	DealerButton.setPreferredSize(d);
	BlackjackButton.setPreferredSize(d);
	frame.getContentPane().setLayout(new FlowLayout());
	frame.getContentPane().add(prompt);
	frame.getContentPane().add(BlackjackButton);
	frame.getContentPane().add(DealerButton);
	frame.setSize(350,500);
	frame.setVisible(true);
    }

    class DealerListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    frame.setSize(800, 600);
	    frame.setContentPane(new GamesDealerPanel());
	    frame.invalidate();
	    frame.validate();
	}
    }

    class BlackjackListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		frame.setSize(1000, 600);
	    frame.setContentPane(new BlackJackGui());
	    frame.invalidate();
	    frame.validate();
	}
    }

}
