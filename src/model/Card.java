package model;
/** Objects of this class represents cards in
 *	a deck (of cards).
 *	A card is immutable, i.e. once created its
 *	rank or suit cannot be changed.
 */
import java.util.Comparator;


class SuitsComparator implements Comparator<Card>{
	public int compare(Card c1, Card c2){
		return c1.getSuit().compareTo(c2.getSuit());
	}
}

class RankComparator implements Comparator<Card>{
	public int compare(Card c1, Card c2){
		return c1.getRank().compareTo(c2.getRank());
	}
}

public class Card {
	
	/** rank: 1 = Ace, 2 = 2, ...
	 *  suit: 1 = spades, 2 = hearts, ...
	 */						
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank() { return rank; }

	public Suit getSuit() { return suit; }
	
	public boolean equals(Card other) {
		return this.rank == other.rank && this.suit == other.suit;
	}
	
	public String toString() {
		return rank +" of "+ suit;
	}
	
	private final Rank rank; 
	private final Suit suit;
	
}
