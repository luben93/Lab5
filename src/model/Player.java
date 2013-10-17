package model;

public class Player {
	
	private String playerName;
	private int playerPoints;
	private Hand hand;
	
	public Player(String playerName_) {
		
		playerName = playerName_;
		playerPoints = 0;
		
		hand = new Hand();
		
	}
	
	public void receiveCard(Deck deck) throws NoSuchCardException {
		hand.addCard(deck);
	}
	
	public int getLatestCardRank() throws NoSuchCardException {
		return hand.getLatestAddedCardRank();
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getPlayerPoints() {
		return playerPoints;
	}
	
	public void addPoints(int points) {
		playerPoints = playerPoints + points;
	}
	
	public int getPoints() {
		return playerPoints;
	}
	
	public String toString() {
		return hand.toString();
	}
	
	
}
