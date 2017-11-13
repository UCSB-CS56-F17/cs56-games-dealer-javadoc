package edu.ucsb.cs56.projects.games.dealer.unitTest;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.ucsb.cs56.projects.games.dealer.Deck;
import edu.ucsb.cs56.projects.games.dealer.Hand;
import edu.ucsb.cs56.projects.games.dealer.Card;

/**
 * The test class HandTest, to test the Deck, and Hand classes
 *
 * @author Kin Kwan Poon
 * @version UCSB, CS56,F16
 * @see Deck,Hand
 */
public class HandTest{
    private Deck d;
    private ArrayList<Card> unshuffleDeck;
    private final String[] ranks={"Ace","2","3","4","5","6","7","8",
				  "9","10","Jack","Queen","King"};
    private final String[] suits={"Spades","Hearts","Clubs","Diamonds"};

    @Before
    public void setUp(){
	d=new Deck();
	unshuffleDeck=new ArrayList<Card>();
	for(int i=0;i<4;i++){
	    for(int j=0;j<13;j++){
		unshuffleDeck.add(new Card(ranks[j],suits[i]));
	    }
	}
	
    }

    public void shuffle(){
	d.shuffle();
    }

    
    @Test
    public void testUnshuffleDeck(){
	assertEquals(unshuffleDeck,d.getDeck());
    }

    @Test
    public void testShuffleDeck(){
	shuffle();
	assertFalse("Shuffled Deck should not equal to unshuffled Deck",
		    unshuffleDeck.equals(d.getDeck()));
    }

    @Test
    public void testOneCardtoHand(){
	Hand h = new Hand();
	h.addtoHand(1,d);
	assertEquals(unshuffleDeck.get(0),h.getHand().get(0));
	assertEquals(1,h.getHand().size());
    }

    @Test
    public void testDeckRemoveCard(){
	d.draw(1,new Hand());
	assertEquals(unshuffleDeck.get(1),d.getDeck().get(0));
	assertEquals(51,d.getDeck().size());
    }

    @Test
    public void testShuffleDeckRemoveCard(){
	shuffle();
	d.draw(13,new Hand());
	assertEquals(39,d.getDeck().size());
    }

    @Test
    public void testFiveCardtoHand(){
	Hand h = new Hand();
	h.addtoHand(5,d);
	assertEquals(unshuffleDeck.get(0),h.getHand().get(0));
	assertEquals(unshuffleDeck.get(1),h.getHand().get(1));
	assertEquals(unshuffleDeck.get(2),h.getHand().get(2));
	assertEquals(unshuffleDeck.get(3),h.getHand().get(3));
	assertEquals(unshuffleDeck.get(4),h.getHand().get(4));
	assertEquals(5,h.getHand().size());
    }

    @Test
    public void testTwoCardtoTwoHand(){
	Hand h1=new Hand();
	Hand h2=new Hand();
	h1.addtoHand(2,d);
	h2.addtoHand(2,d);
	assertEquals(unshuffleDeck.get(0),h1.getHand().get(0));
	assertEquals(unshuffleDeck.get(1),h1.getHand().get(1));
	assertEquals(unshuffleDeck.get(2),h2.getHand().get(0));
	assertEquals(unshuffleDeck.get(3),h2.getHand().get(1));
	assertEquals(2,h1.getHand().size());
	assertEquals(2,h2.getHand().size());
    }

    @Test
    public void testEmptyDeck(){
	d.draw(52,new Hand());
	assertEquals("NO MORE CARDS IN THE DECK",d.toString());
    }
    
    @Test
    public void testRemoveLastCard(){
    	Hand h1=new Hand();
    	h1.addtoHand(2, d);
    	h1.removeLastCard();
    	assertEquals("Your hand:\nAce of Spades",h1.toString());
    }
    
    @Test
    public void testTwoDecks(){
    	Deck d2=new Deck(2);
    	Hand h1=new Hand();
    	h1.addtoHand(53, d2);
    	assertEquals(unshuffleDeck.get(0),h1.getHand().get(52));
    }
    


}
