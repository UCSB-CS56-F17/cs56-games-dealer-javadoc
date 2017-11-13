package edu.ucsb.cs56.projects.games.dealer;

/**
   This class is used to help the Panel create the string of random cards that it displays.

   @author Kelly Bielaski and Tristan Starck
   @version cs56 W16 2/15/16
*/

public class DealerPanelHelper{

    private int numHands;
    private int[] playerInputArrayInts;
    private String shuffle;
    private Deck deck;
    private Hand[] hands;

    /**
     * Constructor of DealerPanelHelper
     * @param numHands
     * @param playerInputArrayInts
     * @param shuffle
     * @param deck
     * @param hands
     */

    public DealerPanelHelper(int numHands, int[] playerInputArrayInts, String shuffle, Deck deck, Hand[] hands){
	this.numHands=numHands;
	this.playerInputArrayInts=playerInputArrayInts;
	this.shuffle=shuffle;
	this.deck=deck;
	this.hands=hands;
    }
    
    public String playerCardString(){
	
	if(playerInputArrayInts==null){
	    return "player inputs are null";
	}
	if(shuffle==null){
	    return "shuffle is null";
	}
	if(deck==null){
	    return "deck is null";
	}
	   
	
	String displayedCards="";
	
	if (shuffle=="shuffle once before dealing" || shuffle == "shuffle after every set of cards is dealt"){
	    deck.shuffle();
	    displayedCards+="deck shuffled\n";
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
	    displayedCards+="\n" +"Player "+ (i+1)+ "/" +numHands+ ": "+ hands[i]+"\n";
	    if(shuffle=="shuffle after every set of cards is dealt"){
		deck.shuffle();
		displayedCards+="\ndeck shuffled\n";
	    }
	}
	displayedCards+="\n\n"+deck;
	if(deck.getDeck().size()<=0){
	    displayedCards+="\nNo more cards to distribute. Click Submit/Reset button to reset the deck and play again.";
	}
	    
	return displayedCards;	
    }


    /**
     * @return Return the deck.
     */
    public Deck getDeck(){
	return deck;
    }

    /**
     * @return Return the array of Hands.
     */
    public Hand[] getHands(){
	return hands;
    }
    
}

