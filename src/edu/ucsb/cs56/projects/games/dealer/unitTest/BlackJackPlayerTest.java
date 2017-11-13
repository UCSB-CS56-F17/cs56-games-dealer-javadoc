package edu.ucsb.cs56.projects.games.dealer.unitTest;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ucsb.cs56.projects.games.dealer.BlackJackPlayer;
import edu.ucsb.cs56.projects.games.dealer.Deck;

/**
 * This class is used to test the BlackJackPlayer class.
 * @author Kin Kwan Poon
 * @version UCSB, cs56, F16
 */
public class BlackJackPlayerTest {
    private Deck d;
    @Before
    public void setUp(){
    	d=new Deck();
	}
	
    @Test
    public void testHandVaule1(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	h1.addtoHand(2,d);
    	assertEquals(13,h1.getHandValue());
    }
    
    @Test
    public void testHandVaule2(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	h1.addtoHand(5,d);
    	assertEquals(15,h1.getHandValue());
    }
    
    @Test
    public void testHandVaule3(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	BlackJackPlayer h2=new BlackJackPlayer("test");
    	h1.addtoHand(1,d);// Ace
    	h2.addtoHand(8, d); // 2 to 9
    	h1.addtoHand(1, d);// 10
    	assertEquals(21,h1.getHandValue());
    }
    @Test
    public void testHandVaule4(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	BlackJackPlayer h2=new BlackJackPlayer("test");
    	h1.addtoHand(1,d);// Ace
    	h2.addtoHand(9, d); // 2 to 10
    	h1.addtoHand(1, d);// Jack
    	assertEquals(21,h1.getHandValue());
    }
    @Test
    public void testHandVaule5(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	BlackJackPlayer h2=new BlackJackPlayer("test");
    	h1.addtoHand(1,d);// Ace
    	h2.addtoHand(10, d); // 2 to Jack
    	h1.addtoHand(1, d);// Queen
    	assertEquals(21,h1.getHandValue());
    }
    @Test
    public void testHandVaule6(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	BlackJackPlayer h2=new BlackJackPlayer("test");
    	h1.addtoHand(1,d);// Ace
    	h2.addtoHand(11, d); // 2 to 10
    	h1.addtoHand(1, d);// King
    	assertEquals(21,h1.getHandValue());
    }
    @Test
    public void testHandVaule7(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	BlackJackPlayer h2=new BlackJackPlayer("test");
    	h1.addtoHand(1,d);// Ace
    	h2.addtoHand(12, d); // 2 to King Spades
    	h1.addtoHand(1, d);// Hearts Ace
    	assertEquals(12,h1.getHandValue());
    }
    
    @Test
    public void testBusted1(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	BlackJackPlayer h2=new BlackJackPlayer("test");
    	h1.addtoHand(10, d);
    	h2.addtoHand(3, d);// Jack to King
    	assertTrue(h2.isBusted());
    }   
    @Test
    public void testBusted2(){
    	BlackJackPlayer h1=new BlackJackPlayer("test");
    	BlackJackPlayer h2=new BlackJackPlayer("test");
    	h1.addtoHand(1, d);
    	h2.addtoHand(1, d);// 2
    	h1.addtoHand(9, d);
    	h2.addtoHand(2, d);// Queen and King
    	assertTrue(h2.isBusted());
    }
    
}
