package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;

/**
 *   This class is used to add cards to the hand.
 *
 * @author Kin Kwan Poon and Eric Xiao
 * @author Antonio Cantor
 * @version cs56 F16
 */

public class Hand {
    protected ArrayList<Card> hand;
    protected int handSize;

    /**
     * Hand constructor to make hand arraylist be an empty hand
     * and the handSize be 0.
     */

    public Hand() {
        hand = new ArrayList<Card>();
        handSize=0;
    }

    /**
     * Add a number of cards to the hand, and play a sound effect
     *
     * @param numCards number of cards to draw
     * @param d the deck to draw from
     */

     public void addtoHand(int numCards, Deck d) {
         d.draw(numCards, this);
         handSize += numCards;
         SoundEffect.playSound("deal",1,4);
    }
     
     public void removeLastCard(){
    	 hand.remove(handSize-1);
    	 handSize--;
     }

    /**
     * @return an ArrayList containing each card in the hand
     */
     public ArrayList<Card> getHand() {
	return hand;
    }

    /**
     * Overridden toString function to print cards in the hand.
     *
     * @return handResult a string of the cards in the hand
     */

    @Override
    public String toString() {
        String result = "Your hand:\n";
	for(int i = 0; i < handSize - 1; i++) {
	    result += hand.get(i) + ", ";
	}
	result += hand.get(handSize - 1);
	return result;
    }
}
