package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
   This class is used to help the Panel create the string of random cards that it displays.

   @author Kelly Bielaski and Tristan Starck
   @version cs56 W16 2/15/16
*/

public class DealerPanelHelperCopy{

    /**
       Main function to interact with the gui,
       shuffle the deck, and print cards

       @param args Command line arguments entered by user
    */

    private int numHands;
    private int[] playerInputArrayInts;
    private String shuffle;
    private Deck deck;
    private Hand[] hands;
    
    public DealerPanelHelperCopy(int numHands, int[] playerInputArrayInts, String shuffle, Deck deck, Hand[] hands){
	this.numHands=numHands;
	this.playerInputArrayInts=playerInputArrayInts;
	this.shuffle=shuffle;
	this.deck=deck;
	this.hands=hands;
    }
    
    public ArrayList<String> playerCardString(){
	ArrayList<String> displayedCards = new ArrayList<String>();
	
	/*if(playerInputArrayInts==null){
	  return "player inputs are null";
	  }
	  if(shuffle==null){
	  return "shuffle is null";
	  }
	  if(deck==null){
	  return "deck is null";
	  }*/
	//make the size of the array based on how many times we shuffle	   

	//place holder to where to insert the statement

	if (shuffle=="shuffle once before dealing" || shuffle == "shuffle after every set of cards is dealt"){
	    deck.shuffle();
	    displayedCards.add("deck shuffled\n");
	}
	if(hands==null)
	    hands=new Hand[numHands];
	
	for(int i=0; i<numHands;i++){
	    if (playerInputArrayInts[i]<0||playerInputArrayInts[i]>53)
		playerInputArrayInts[i]=5;
	    if(hands[i]==null){
		hands[i]= new Hand();
	    }

	    hands[i].addtoHand(playerInputArrayInts[i], deck);
	    displayedCards.add("\n" +"Player "+ (i+1)+ "/" +numHands+ ": "+ hands[i]+"\n");
	    if(shuffle=="shuffle after every set of cards is dealt"){
		deck.shuffle();
		displayedCards.add("\ndeck shuffled\n");
	    }
	}
	displayedCards.add("\n\n"+deck);
	if(deck.getDeck().size()<=0){
	    displayedCards.add("\nNo more cards to distribute. Click Submit/Reset button to reset the deck and play again.");
	}
	    
	return displayedCards;	
    }

    public Deck getDeck(){
	return deck;
    }

    public Hand[] getHands(){
	return hands;
    }
    
}

