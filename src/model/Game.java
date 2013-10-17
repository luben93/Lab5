package model;
import java.util.Scanner;

/**
*Class that handles all user-IO for blackjack
 */

public class Game {

	private int choice;
	private Scanner input;
	private String playername;
	BlackjackModel blackjack;
	
	public Game() {
		input = new Scanner(System.in);
	}
	
	public void WelcomeScreen(int firstrun) {
		if(firstrun == 1) {
			System.out.print("Player name: ");
			playername = input.nextLine();
		
			System.out.println("**************** Welcome to Blackjack " + playername + "! ****************");
		}

		blackjack = new BlackjackModel(playername);
		
		System.out.println("1. New game");
		System.out.println("2. Quit game");
		
		choice = input.nextInt();
		
		switch(choice) {
			case 1:
				blackjack.InitGame();
				break;
			case 2:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice.");
		}
		
		do {
			System.out.println("Cards in dealers hand: \n" + blackjack.getDealerHand());
			System.out.println("Dealer has " + blackjack.getDealerPoints() + " points\n");
			System.out.println("Cards in your hand: \n" + blackjack.getPlayerHand());	
			System.out.println("You have " + blackjack.getPlayerPoints() + " points\n");
			
			if(blackjack.CheckPoints() == 1) {
				System.out.println("You got 21 points! You win!\n");
			}
			else if(blackjack.CheckPoints() == 2) {
				System.out.println("Bust! You lose!\n");
			}
			else if(blackjack.CheckPoints() == 3) {
				System.out.println("Dealer got a blackjack! You lose!\n");
			}
			else if(blackjack.CheckPoints() == 4) {
				System.out.println("Dealer busted! You win!\n");
			}
			else if(blackjack.CheckPoints() == 5) {
				System.out.println("Push! Nobody wins or loses!\n");
			}
			else if(blackjack.CheckPoints() == 6) {
				System.out.println("You win!\n");
			}
			else if(blackjack.CheckPoints() == 7) {
				System.out.println("Dealer wins!\n");
			}
			else {
			
			System.out.println("Choices: \n1. Hit\n2. Stand\n3. Surrender");
			
			choice = input.nextInt();
			
			switch(choice) {
				case 1:
					blackjack.PlayerHit();
				break;
				case 2:
					blackjack.Stand();
				break;
				case 3:
					System.out.println("You surrendered! Dealer wins!\n");
					blackjack.Surrender();
				break;
				/* case 4:
					blackjack.TestException();*/
				default:
					System.out.println("Invalid choice.");
				}
			
			}
			
		}while(!blackjack.GameOver());
		
		blackjack.EndGame();
		
		WelcomeScreen(0); //Go back to welcome screen
	}
}
