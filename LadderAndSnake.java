import java.util.Arrays;
import java.util.Scanner;
/**
 * Name and ID: Ikram Kamal 40248477
 * COMP249
 * Assignment #0
 * Due Date 02/06/2023
 * 
 * This class implement a ladder and snake game
 * @author Ikram Kamal
 *
 */
public class LadderAndSnake {
	
	
	private int NumOfPlayers;
	private int Board [][]	= new int [10][10];
	private String Player1;
	private String Player2;
	private int pos1=0; 
	private int pos2=0;
	
	/**
	 * @param NumOfPlayers number of players 
	 * @param Player1 name of the first player
	 * @param Player2 name of the second player
	 * @param pos1 position of the first player
	 * @param pos2 position of the second player
	 */
	
	
	/**default constructor*/
	public LadderAndSnake() {}
	
	/**parameterize constructor 
	 * that take number of players
	 * @param NumOfPlayer number of players playing the game
	 */
	public LadderAndSnake(int NumOfPlayer)
	{
		this.NumOfPlayers = NumOfPlayer;
	}
	
	/**parameterize constructor 
	 * take name of players
	 * @param Player1 name of first player
	 * @param Player2 name of second player
	 */
	public LadderAndSnake( String Player1, String Player2)
	{
		this.Player1 = Player1;
		this.Player2=Player2;
	}

	/**
	 * This method display the board game
	 */
	public void displayBoard() {
		System.out.println("          --------------------------------");
		System.out.println("                    Welcome to            ");
		System.out.println("              Ladder And Snake Game       ");
		System.out.println("          --------------------------------");
		
		System.out.println("____________________________________________________");
	
		int a=1;
	
		for (int i=0; i<10; i++) {
			   // System.out.println("____________________________________________________________");
				for ( int j=0; j<10; j++)
				{ this.Board[i][j]=a;
				 //System.out.print("____________________________________________________________");
				System.out.printf("|%4s", a);
				a++;
				}
				System.out.printf("%4s", "|\n");
				System.out.println("____________________________________________________");
		}
		
		 
		 
		
	}
	/**
	 * method to flip dice and return a random value between 1 and 6
	 * @return a random value between 1 and 6
	 */
	public int flipDice() {
		
		int DiceValue=((int)(Math.random()*6+1));
		if (DiceValue==0)
			DiceValue=1;
		
		System.out.println("Dice Value: "+ DiceValue);
		return DiceValue;
		
	}

	/**method to determine which player will play first and count how many
	 *  attempts it took to determine the order
	 */
	public void getOrder()
	{
	   int count=0;
	   do {
		
	    pos1=flipDice();
	    pos2=flipDice();
	    
	    
	  
	    if (pos1>pos2) 
			System.out.print( Player1+ " will play first. ");
	        
	        
	    	
	    if(pos2>pos1)
		System.out.print( Player2+ " will play first. ");
	    
		
	    else if(pos2==pos1)
		  System.out.println("A tie was achieved, try again");

	    
	    count ++;
	    
		}while(pos1==pos2);
		
		System.out.println("It took "+ count+" attempts before a decision was made.");
		
	}
	
	/**method that return a string of the first player and 
	 * reset players position to 0
	 * @return first player's name
	 */
	public String firstPlayer() {
	
		if (pos1>pos2) {
			pos1=0;
			pos2=0;
			return Player1;}
		
		else {
			pos1=0;
		    pos2=0;
			return Player2;}
		
	
	}
	
	/**method that returns position of the first player
	 * if the position is greater than 100, player move backwards with the excessive amount
	 * @return position of first player
	 */
    public int PositionP1() {
    	
    	pos1=pos1+flipDice();
    	if (pos1>100)
    	pos1=100-(pos1-100);
    	
    	return pos1;
    }
    
  /**method that returns position of the second player player
   * if the position is greater than 100, player move backwards with the excessive amount
   * @return position of second player
   */
    public int PositionP2() {
    	pos2=pos2+flipDice();
    	if (pos2>100)
        	pos2=100-(pos2-100);
        	
        	return pos2;
    }
	
   
    /**Method that returns to position of the first player on LadderAndSnake Board
     * if position of first player on the initial board is the same  as the one after going through ladders and snakes board,
     * the position on the initial board is returned otherwise, 
     * the position on the LadderAndSnake Board is returned
     * @return position of first player
     */
    public int Pos1onLadderAndSnakeBoard()
    {
    

    int [] [] LadderAndSnakeBoard = {{38,2,3,14,5,6,7,8,31,10},{11,12,13,14,15,6,17,18,19,20},{42,22,23,24,25,26,27,84,29,30},{31,32,33,34,35,44,37,38,39,40},{41,42,43,44,45,46,47,30,49,50},{67,52,53,54,55,56,57,58,59,60},{61,62,63,60,65,66,67,68,69,70},{91,72,73,74,75,76,77,78,19,100},{81,82,83,84,85,86,87,88,89,90},{91,92,68,94,24,96,76,78,99,100}};
    int a=1;
    
    for (int i=0; i<10; i++) {
		
		for ( int j=0; j<10; j++)
		{
			
			Board[i][j]=a;
			
			
			if (pos1==Board[i][j]) 
			{
			
		      if(Board[i][j]==LadderAndSnakeBoard[i][j])
		    	  pos1=Board[i][j];
		      else {
		    	  pos1=LadderAndSnakeBoard[i][j];
		    	  
		    	  if(Board[i][j]<LadderAndSnakeBoard[i][j])
		    		  System.out.println("Player has reached a Ladder, go up");
		    	  if(Board[i][j]>LadderAndSnakeBoard[i][j])
		    		  System.out.println("Player has reached a Snake, go down");
		      }
		    }
			
			a++;
		
	}
    }
    return pos1;
    
    }
    

    /**Method that returns to position of the second
     * player on LadderAndSnake Board (same as previous one)
     *  @return position of second player
     */
    public int Pos2onLadderAndSnakeBoard()
    {
    	
    
    int [] [] LadderAndSnakeBoard = {{38,2,3,14,5,6,7,8,31,10},{11,12,13,14,15,6,17,18,19,20},{42,22,23,24,25,26,27,84,29,30},{31,32,33,34,35,44,37,38,39,40},{41,42,43,44,45,46,47,30,49,50},{67,52,53,54,55,56,57,58,59,60},{61,62,63,60,65,66,67,68,69,70},{91,72,73,74,75,76,77,78,19,100},{81,82,83,84,85,86,87,88,89,90},{91,92,68,94,24,96,76,78,99,100}};
    int a=1;
    
    for (int i=0; i<10; i++) {
		
		for ( int j=0; j<10; j++)
		{
			Board[i][j]=a;
			
			
			if (pos2==Board[i][j]) 
			{
		      if(Board[i][j]==LadderAndSnakeBoard[i][j])
		    	  pos2=Board[i][j];
		      else {
		    	  pos2=LadderAndSnakeBoard[i][j];
		    	  if(Board[i][j]<LadderAndSnakeBoard[i][j])
		    		  System.out.println("Player has reached a Ladder");
		    	  if(Board[i][j]>LadderAndSnakeBoard[i][j])
		    		  System.out.println("Player has reached a Snake");
		      }
		    	  
		    }
			
			a++;
		
	}
    }
    return pos2;   
    }
   
    
    /**method for special case when 2 players are on the same case.
     *  when pos1=pos2, pos1 is reset to 0 
     */
    public void SpecialCase1() {
    	if(pos1==pos2) {
    		pos1=0;
    System.out.println( Player1 +" position is reset to 0");}
    }
    
    /**method for special case when 2 players are on the same case.
     *  when pos1=pos2, pos1 is reset to 0 
     */
    public void SpecialCase2() {
    	
    	if(pos1==pos2) {
    		pos2=0;
    	 System.out.println( Player2 +" position is reset to 0");}
    }

 
    
    /**Method that initiate the core engine of the game 
     * as long as position of both player is less then 100, game still on
     * the loop breaks once one of the players' position reach 100
     */
	public void play() {
	
		Scanner keyboard = new Scanner (System.in);
		
	
		System.out.println("\nNow deciding which player will start playing: ");
		getOrder();
		System.out.println("");
		
		
		if (firstPlayer().equals(Player1)) {
		
		while (pos1<100 && pos2<100) {
		
		System.out.println(Player1+"'s turn (tap to flip dice)");
		String a=keyboard.next();
		PositionP1();
		SpecialCase2();
		System.out.println(Player1 +" is now in case "+Pos1onLadderAndSnakeBoard()+"\n");
		
		if (pos1==100) {
			System.out.println(Player1+ " Wins!\nEnd of game");
		    break;
		}
		
		
		System.out.println(Player2+"'s turn (tap to flip dice)");
		a =keyboard.next();
		PositionP2();
		SpecialCase1();
		System.out.println(Player2 +" is now in "+Pos2onLadderAndSnakeBoard()+"\n");
		
		if (pos2==100) {
			System.out.println(Player2+ " Wins!\nEnd of game");
		    break;}	

		}
		}
		
		if (firstPlayer().equals(Player2)) {
			
			while (pos1<100||pos2<100) {

			
			System.out.println(Player2+"'s turn (tap to flip dice)");
			String a=keyboard.next();
			PositionP2();
			SpecialCase1();
			System.out.println(Player2 +" is now in "+Pos2onLadderAndSnakeBoard()+"\n");
		
			if (pos2==100) {
				System.out.println(Player2+ " Wins!\nEnd of game");
				break;
			}
			
			

			System.out.println(Player1+"'s turn (tap to flip dice)");
			a =keyboard.next();
			PositionP1();
			SpecialCase2();
			System.out.println(Player1 +" is now in "+Pos1onLadderAndSnakeBoard()+"\n");
		
			if (pos1==100) {
				System.out.println(Player1+ " Wins!\nEnd of game");
			    break;
			}
			
		


			}
			
			keyboard.close();
			}		
}

	
	/**
	 * accessor method to get number of players
	 * @return  number of players
	 */
	public int getNumOfPlayers() {
		return NumOfPlayers;
	}
	
	/**
	 * mutator method to set number of players
	 * @param numOfPlayers number of players
	 */
	public void setNumOfPlayers(int numOfPlayers) {
		NumOfPlayers = numOfPlayers;
	}
/**
 * accessor method to get Player1's name
 * @return Player1's name
 */
	public String getPlayer1() {
		return Player1;
	}

	/**
	 * mutator method to set player1's name
	 * @param player1 Player1 name
	 */
	public void setPlayer1(String player1) {
		Player1 = player1;
	}

	/**
	 * accessor method to get player2's name
	 * @return Player 2 name 
	 */
	public String getPlayer2() {
		return Player2;
	}

	/**
	 * mutator method to set player2's name
	 * @param player2 player2
	 */
	public void setPlayer2(String player2) {
		Player2 = player2;
	}

	/**
	 * accessor method to get player1's position
	 * @return position of first player
	 */
	public int getPos1() {
		return pos1;
	}

	/**
	 * mutator method to set position of player 1
	 * @param pos1 position of first player
	 */
	public void setPos1(int pos1) {
		this.pos1 = pos1;
	}

	/**
	 * accessor method to get player2's position 
	 * @return position of second player
	 */
	public int getPos2() {
		return pos2;
	}

	/**
	 * mutator method to set position of player 2
	 * @param pos2 position of second player
	 */
	public void setPos2(int pos2) {
		this.pos2 = pos2;
	}

	
	
	
	
}
	
	
	
	

	
	

