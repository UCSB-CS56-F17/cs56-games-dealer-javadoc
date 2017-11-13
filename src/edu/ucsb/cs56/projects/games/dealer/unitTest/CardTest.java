package edu.ucsb.cs56.projects.games.dealer.unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.ucsb.cs56.projects.games.dealer.Card;

/**
 * The test class CardTest, to test the Card class
 * @author Kin Kwan Poon
 * @version UCSB, cs56, F16
 */
public class CardTest {
    @Test 
    public void testAce_SpadesEqualsAce_Hearts(){
	Card AS = new Card("Ace","Spades");
	Card AH = new Card("Ace","Hearts");
	assertFalse("The Hashcodes of two cards should not be the same",
		    AS.hashCode()==AH.hashCode());
    }

    @Test
    public void test2_ClubsEquals2_Clubs(){
	Card c1 = new Card("2","Clubs");
	Card c2 = new Card("2","Clubs");
	assertTrue("The Hashcodes of two cards should be the same",
		   c1.hashCode()==c2.hashCode());
	assertTrue("They should be equal",c1.equals(c2));
	assertEquals(0,c1.compareTo(c2));
    }

    @Test
    public void testSpadesAceGreaterThanHeartsAce(){
    	Card c1 = new Card("Ace","Spades");
    	Card c2 = new Card("Ace","Hearts");
    	assertEquals(1,c1.compareTo(c2));
    }
    
    @Test
    public void testSpades4LessThanClubs5(){
    	Card c1 = new Card("4","Spades");
    	Card c2 = new Card("5","Clubs");
    	assertEquals(-1,c1.compareTo(c2));
    }
    
    @Test
    public void testHeartsAceGreaterThanHeartsKing(){
    	Card c1 = new Card("Ace","Hearts");
    	Card c2 = new Card("King","Hearts");
    	assertEquals(1,c1.compareTo(c2));
    }
    
    @Test 
    public void testAceValue(){
    	Card c1 = new Card("Ace","Clubs");
    	assertEquals(1,c1.rankValue(true).intValue());
    }
    
    @Test
    public void testJackValue(){
    	Card c1 = new Card("Jack","Clubs");
    	assertEquals(10,c1.rankValue(true).intValue());
    }
    @Test
    public void testQueenValue(){
    	Card c1 = new Card("Queen","Clubs");
    	assertEquals(10,c1.rankValue(true).intValue());
    }
    @Test
    public void testKingValue(){
    	Card c1 = new Card("King","Clubs");
    	assertEquals(10,c1.rankValue(true).intValue());
    }
    
    @Test
    public void testThreeValue(){
    	Card c1 = new Card("3","Clubs");
    	assertEquals(3,c1.rankValue(true).intValue());
    }
    
    
}
