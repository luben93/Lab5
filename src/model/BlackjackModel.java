package model;
/**
*Class that contains all the game-logic 
*for Blackjack.
 */

public class BlackjackModel {
	
	private Player player; //Player
	private Player dealer; //Dealer
	private Deck deck;
	private boolean gameover; //Is the game over?
	
	//Constructor
	public BlackjackModel(String playername) {
		deck = new Deck();
		player = new Player(playername);
		dealer = new Player("Mr. Dealer");
	}
	
	public int getPlayerPoints() {
		return player.getPoints();
	}
	
	public int getDealerPoints() {
		return dealer.getPoints();
	}
	
	public String getPlayerHand() {
		return player.toString();
	}
	
	public String getDealerHand() {
		return dealer.toString();
	}
	
	public boolean GameOver() {
		if(gameover)
			return true;
		else
			return false;
	}
	
	public void InitGame() {
		gameover = false;
		
		deck.shuffleCards();
		
		Hit(player);Hit(player); //Adds two cards from the deck to the hand of the player
		
		Hit(dealer); //Adds one cards from the deck to the hand of the dealer
	}
	
	public int CheckPoints() {
		if(player.getPoints() == 21) {
			gameover = true;
			return 1; //Player gets blackjack
		}
		else if(player.getPoints() > 21) {
			gameover = true;
			return 2; //Player busts
		}
		else if(dealer.getPoints() == 21) {
			gameover = true;
			return 3; //Dealer gets blackjack
		}
		else if(dealer.getPoints() > 21) {
			gameover = true;
			return 4; //Dealer busts
		}
		else if(player.getPoints() == dealer.getPoints()) {
			gameover = true;
			return 5; //Push
		}
		else if(dealer.getPoints() >= 17 && player.getPoints() > dealer.getPoints()) {
			gameover = true;
			return 6; //Player wins
		}
		else if(dealer.getPoints() >= 17 && player.getPoints() < dealer.getPoints()) {
			gameover = true;
			return 7; //Dealer wins
		}
		else {
			return 0;
		}
	}
	
	public void Hit(Player p) {
		
		try {
			p.receiveCard(deck);
		}catch(NoSuchCardException e) {
			System.out.println(e.getMessage());
		}
		
		try {
		//Add the points (Blackjack) of the added card to playerPoints
			if(p.getLatestCardRank() == 11 || p.getLatestCardRank() == 12 || p.getLatestCardRank() == 13) { //Face cards
				p.addPoints(10);
			}
			else if(p.getLatestCardRank() == 1) { //Ace
				if(p.getPlayerPoints() == 20 || (p.getPlayerPoints() + 11) > 21) {
					p.addPoints(1); //Ace counts as 1 if you have 20 points or over 21
				}
				else {
					p.addPoints(11);
				}
			}
			else {
				p.addPoints(p.getLatestCardRank());
			}
		}catch(NoSuchCardException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void PlayerHit() {
		Hit(player);
	}
	
	public void Stand() {
		while(dealer.getPoints() < 17) {
			Hit(dealer);
		}
	}
	
	public void Surrender() {
		gameover = true;
	}
	
	public void EndGame() {

		/* Clear the references to player, dealer and the deck */
		player = null;
		dealer = null;
		deck = null;
		
	}
	
	
	
}
