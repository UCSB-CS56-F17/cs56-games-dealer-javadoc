package edu.ucsb.cs56.projects.games.dealer;

import java.awt.*;
import javax.swing.*;

/** SimpleGui for our Games Dealer application

     @author Kelly Bielaski and Tristan Starck
     @version CS56, Winter 2016, UCSB
*/


public class GamesDealerGui{
    
    /**
       Constructor
    */

    private GamesDealerGui(){}

    /**
       The places the BACPanel into the frame and makes
       the specifc frame visible
       @param standard command line parameters for main
     */
    public static void main (String[] args) {
	
	JFrame frame = new JFrame("Games Dealer");
	GamesDealerPanel panel = new GamesDealerPanel();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(BorderLayout.CENTER, panel);
	frame.pack();
	frame.setSize(800,600);
	frame.setVisible(true);
    }
}
