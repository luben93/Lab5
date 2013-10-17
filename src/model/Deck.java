package model;
import java.util.ArrayList;
import java.util.Collections;

/**
*Objects of this class represent a 
*deck of cards
 */

public class Deck {
	
	private ArrayList<Card> theCards;
	
	public Deck() {
		theCards = new ArrayList<Card>(); //Creates an ArrayList with the Cards
		
		fill();
	}
	
	public int getNoOfCards() {
		return theCards.size();
	}
	
	public Card dealCard() {
		Card c = null;
		
		if(!theCards.isEmpty()) {
			c = theCards.get(getNoOfCards()-1);
			theCards.remove(getNoOfCards()-1);
			return c;
		}
		else {
			throw new NoSuchCardException("No more cards left!");
		}

	}
	
	public void shuffleCards() {
		Collections.shuffle(theCards);
	}
	
	public void fill() {
		theCards.removeAll(theCards);
		 for (Suit suit : Suit.values()) {
	            for (Rank rank : Rank.values()) {
	            	theCards.add(new Card(rank, suit));
			}
		 }		
	}
	
	public void empty() {
		theCards.removeAll(theCards);
	}
	
	public String toString() {
			String s = "Cards in deck:\n";
			
			for(int i = 0; i < theCards.size(); i++) {
				s = s + "\n" + theCards.get(i).toString();
			}
			
			return s;
	}

}
