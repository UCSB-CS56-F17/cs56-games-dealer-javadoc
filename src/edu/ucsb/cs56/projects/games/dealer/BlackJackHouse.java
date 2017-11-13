package edu.ucsb.cs56.projects.games.dealer;

/**
 * The dealer / house of the game.
 * @author Kin Kwan Poon
 * @version UCSB, cs56, F16
 */
public class BlackJackHouse extends BlackJackPlayer{
	/**
	 * Constructor of the BlackJackHouse.
	 */
	public BlackJackHouse(){
		super("Dealer");
	}
	/**
	 * Dealer must hit soft 17, 
	 * which means he need to hit until 17.
	 * @return true if its cards does not add up to 17
	 * 			false if its cards adds up to 17
	 */
	public boolean isHitting(){
		return getHandValue()<17;
	}
}
