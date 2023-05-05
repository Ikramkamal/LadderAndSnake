import java.util.Scanner;
/**
 * Name and ID: Ikram Kamal 40248477
 * COMP249
 * Assignment #0
 * Due Date 02/06/2023
 * 
 * Driver class
 */


public class Driver {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
	//Welcome Message	
	System.out.println("--------------------Welcome to Ladder And Snake game----------------------- \nPlease enter Number of players: ");
	
	
	//Enter number of players
	int numOfPlayers;
    numOfPlayers= keyboard.nextInt();
	
	if(numOfPlayers>2) {
	System.out.println("Intitialization was attempted for "+numOfPlayers+" memeber of players; this is only expected for an extended version of the game. Value will be set to 2");
	numOfPlayers=2;
	}
	
	if(numOfPlayers<2) {
	System.out.println("");
	}
		
	
	if(numOfPlayers==2) {
	LadderAndSnake NewGame = new LadderAndSnake(numOfPlayers);	
	NewGame.displayBoard();
	System.out.println("Please enter your names:");
	String Player1 = keyboard.next();
	String Player2=keyboard.next();
		
    LadderAndSnake Players = new LadderAndSnake(Player1, Player2);
	Players.play();	
	}

	
	//Error message if number of players is less than 2, exit the game and end program 
	else
		System.out.println("Error: Cannot execute the game with less than 2 players! Will exit");
	
	}
	
}
