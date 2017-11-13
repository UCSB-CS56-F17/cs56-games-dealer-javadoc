package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
   This class is used to deal cards to the user.

   @author Jeremy White and Andrew Cooney
   @author Antonio Cantor
   @author Tristan Starck and Kelly Bielaski
   @version cs56 W16 2/15/16
*/

public class Dealer {

    /**
       Main function to interact with the user,
       shuffle the deck, and print cards

       @param args Command line arguments entered by user
    */
    
    public static void main(String[] args) throws IOException {
	Scanner stdin = new Scanner(System.in);
	int numCards;
	int numHands = 0;
	boolean keepDealing = true;

	//Create unshuffled deck
	Deck deck=new Deck();

	// Requests input from player for how many hands they want to play with
	System.out.println("How many hands do you want? (Enter an integer greater than 0)");
	if(stdin.hasNextInt()){
	    numHands = stdin.nextInt();
	    if(numHands < 1){
		System.out.println("Default number of hands: 1");
		numHands = 1;
	    }
	}
	// Creates an array of Hand objects
	Hand[] hands = new Hand[numHands];
	for(int i = 0; i < numHands; i++){
	    hands[i] = new Hand();
	}

	do{
	    // Position in array that gives us the current hand
	    int currentHand = 0;

	    // Requests input from player to shuffle the deck
	    System.out.println("Do you want the deck shuffled? (y/n)");
	    if (stdin.next().startsWith("y")){
		deck.shuffle();
	    }
	    else{
		System.out.println("The cards will remain unshuffled");
	    }

	    // Requests input from player for wanted number of hands if game gets reset.
	    if(numHands < 1){
		System.out.println("How many hands do you want? (Enter an integer greater than 0)");
		if(stdin.hasNextInt()){
		    numHands = stdin.nextInt();
		    if(numHands < 1){
			System.out.println("Default number of hands: 1");
			numHands = 1;
		    }
		}
		hands = new Hand[numHands];
		for(int i = 0; i < numHands; i++){
		    hands[i] = new Hand();
		}
	    }
	    // Asks each player how many cards they want.
	    for(; currentHand < numHands; currentHand++){
		
		System.out.println("Player " + (currentHand+1) + "/" + numHands + " : How many cards do you want for your hand?");
		if(stdin.hasNextInt()){
		    numCards = stdin.nextInt();
		    //Checks if numCards is from 0 to 52 is inputted
		    if (numCards<0||numCards>53){
			System.out.println("An integer from 0 to 52 was not entered");
			System.out.println("Five cards will be dealt");
			numCards = 5;
			hands[currentHand].addtoHand(numCards, deck);
			System.out.println(hands[currentHand]);
			break;
		    }

		    hands[currentHand].addtoHand(numCards, deck);
		    //Prints hand
		    System.out.println(hands[currentHand]);
		}
		else{
		    System.out.println("No number entered, five cards will be dealt");
		    numCards = 5;
		    hands[currentHand].addtoHand(numCards, deck);
		    System.out.println(hands[currentHand]);			
		    break;
		}
	    }
		System.out.println("Do you want to continue? (y/n)");
		if(stdin.next().startsWith("y")){
		    //Want to continue but no cards in deck
		    if (deck.getDeck().size()<=0){
		    	System.out.println(deck);
			System.out.println("Do you want to reset? (y/n)");
			if(stdin.next().startsWith("y")){
			    //Resets both hand and deck to default 
			    numHands = 0;
			    deck = new Deck();
			}
			else{
			    //Doesn't want to reset
			    break;
			}
		    }
		    System.out.println("OK");
		}
		else{
		    //No longer wants to continue 
		    break;
		}


	    }while(true);
	
	    //prints the deck
	    System.out.println(deck);


	    System.out.println();
	    System.out.println("Goodbye");

	}
    }

