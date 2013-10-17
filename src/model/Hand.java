package model;
import java.util.ArrayList;
import java.util.Collections;

/**
*Objects of this class represent a 
*hand of cards.
 */

public class Hand {
	
	private ArrayList<Card> theHand;
	
	public Hand() {
	
		theHand = new ArrayList<Card>(); //Creates an ArrayList with the Cards in the hand
		
	}
	
	public int getLatestAddedCardRank() throws NoSuchCardException {
		return (theHand.get(theHand.size() - 1).getRank().ordinal() + 1);
	}
	
	public int getNoOfCards() {
		return theHand.size();
	}
	
	public void addCard(Deck deck) throws NoSuchCardException {
		theHand.add(deck.dealCard());
	}
	
	public Card getCard(int position) {
		if(position < 0 || position > theHand.size() - 1) {
			throw new NoSuchCardException("No card in position " + position + ".");
		}
		else {
			return theHand.get(position);
		}
	}
	
	public Card removeCard(int position) {
		if(position < 0 || position > theHand.size() - 1) {
			throw new NoSuchCardException("No card in position " + position + ".");
		}
		else {
			Card c = theHand.get(position);
			theHand.remove(position);
			return c;
		}
	}
	
	public String toString() {
		String s = "";
		
		for(int i = 0; i < theHand.size(); i++) {
			if(i == 0) {
				s = theHand.get(i).toString();
			}
			else {
				s = s + " | " + theHand.get(i).toString();
			}
		}
		
		return s;
	}
	
	public void sortSuits() {
		Collections.sort(theHand, new SuitsComparator());
	}
	
	public void sortRank() {
		Collections.sort(theHand, new RankComparator());
	}

}
