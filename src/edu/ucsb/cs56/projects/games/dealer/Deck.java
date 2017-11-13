package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;
import java.security.*;
import java.io.File;

import javax.sound.sampled.*;


/**
 * This class is to provide functions to a standard 52 cards deck such as shuffling.
 *
 * @author Kin Kwan Poon and Eric Xiao
 * @author Jeremy White and Andrew Cooney
 * @author Antonio Cantor
 * @version cs56 F16
 */

public class Deck {
    private ArrayList<Card> deck;
    private String[] ranks={"Ace","2","3","4","5","6","7","8",
			    "9","10","Jack","Queen","King"};
    private String[] suits={"Spades","Hearts","Clubs","Diamonds"};

    /**
     * Deck constructor to make deck arraylist contained an unshuffle deck.
     */

    public Deck() {
	deck = new ArrayList<Card>();
	for(int i=0;i<4;i++) {
	    for(int j=0;j<13;j++){
		deck.add(new Card(ranks[j],suits[i]));
	    }
	}
    }
    
    /**
     * Deck Constructor to make numOfDecks Decks into one Deck 
     * for games that require more than one deck. 
     * @param numOfDecks
     */
    public Deck(int numOfDecks) {
    	deck = new ArrayList<Card>();
    	for (int k=0;k<numOfDecks;k++){
    		for(int i=0;i<4;i++) {
    			for(int j=0;j<13;j++){
    				deck.add(new Card(ranks[j],suits[i]));
    			}
    		}
        }
    }

    /**
     * This function is used to shuffle the deck
     * by using the shuffle function from the Collections
     * class and a SecureRandom seed. It randomly permutes deck using
     * the seed.
     */

    public void shuffle() {
	//Creates the seed
	SecureRandom random = new SecureRandom();
	byte bytes[] = new byte[64];
	random.nextBytes(bytes);

	//Shuffles the deck with a 64 bit seed
	Collections.shuffle(deck,random);
	SoundEffect.playSound("shuffle.wav");
	try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }

    /**
     * Overridden toString function to print cards remaining in the deck.
     * @return deckResult a string of the cards remaining in the deck
     */

    public String toString(){
	String deckResult="Your deck"+"\n";
	//Only one card to add to deckResult
	if (deck.size()==1){
	    deckResult+=deck.get(0);
	}
	else{
	    for (int i = 0; i<deck.size(); i++){
		//5 cards per line
		if (i%5==0)
		    deckResult+="\n";
		//No comma at the end of the string
		if(i == deck.size()-1)
		    deckResult+=deck.get(i);
		else
		    deckResult+=deck.get(i) + ", ";
	    }
	    //deck is empty
	    if (deck.size()==0)
		deckResult="NO MORE CARDS IN THE DECK";
	}
	return deckResult;
    }


    /**
     *  Draw a number of cards from the deck
     *
     *  @param numCards number of cards to draw
     *  @param h hand to add cards to
     */

    public void draw(int numCards, Hand h) {
	int i = 0;
	//Loops up to index numCards-1 in the deck
	//Using an Iterator instead of using for loop is safer
	//There won't be an index out of bounds exception
	for(Iterator<Card> iterator = deck.iterator();
	    iterator.hasNext(); ) {
	    Card card = iterator.next();
	    if(i<numCards) {
		//removes first element in the ArrayList
		iterator.remove();
		i++;
		h.getHand().add(card);
	    }
	}
    }



    /**
     *   Returns the ArrayList of the deck
     *
     * @return deck an ArrayList containing each card in the deck
     */

    //Necessary for dealer class and addtoHand function in Hand class
    public ArrayList<Card> getDeck() {
	return deck;
    }

    /**
     * Plays a sound
     *
     * @param filename The name of sound file 
     */


}
