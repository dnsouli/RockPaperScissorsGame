import java.util.Random;
import java.util.Scanner;

//Rock, Paper, Scissors Game///////////////
//Author: Danny Nsouli////////////////////

public class RPS_Game { //to run the game, simple run the one method called in the main method below
	
	static String gtype = "";
	static String pmove = "";
	static String cmove = "";
	
	public static void startGame(){ //main game method
		System.out.println("Welcome to Rock! Paper! Scissors!");
		System.out.println("*********************************");
		
		while(true){
		System.out.println("Select game type by inputting '1' (Quick Round) or '2' (2 out of 3)");
		Scanner scan = new Scanner(System.in);
        gtype = scan.nextLine();
        
        	if(gtype.equals("1") || gtype.equals("2")){
        		break;
        	}
        	else{
        		System.out.println("Invalid game type, please select again.");
        		System.out.println("*********************************");
        	}
		}
        System.out.println("*********************************");
        
        //////////////////////////////////////////////////////////////////////
        //Game Type 1////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////
        
        if(gtype.equals("1")){
        	int roundcount = 1;
        	int res = 0;
        	while(true){
        	System.out.println("Round " + roundcount + ":");
        	System.out.println("Please input 'r' (Rock), 'p' (Paper), or 's' (Scissors).");
    		Scanner scan2 = new Scanner(System.in);
            String pmove = scan2.nextLine();
            	if(pmove.equals("r") || pmove.equals("p") || pmove.equals("s")){
            		String cmove = CompPlayerMove();
            		AnalyzeCMove(cmove);
            		
                    res = Result(pmove, cmove);
                    if(res == 1){
                    	System.out.println("You Won!");
                    	System.out.println("*********************************");
                    	break;
                    }
                    if(res == 0){
                    	System.out.println("You Lose.");
                    	System.out.println("*********************************");
                    	break;
                    }
                    roundcount++;
            	}
            	else{
            		System.out.println("Invalid selection, try again.");
            		System.out.println("*********************************");
            	}
        	}
        }
        
        //////////////////////////////////////////////////////////////////////
        //Game Type 2////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////
        
        if(gtype.equals("2")){
        	int roundcount2 = 1;
        	int res2 = 0;
        	int playerScore = 0;
        	int compPlayerScore = 0;
        	while(true){
        	System.out.println("Round " + roundcount2 + ":");
        	System.out.println("Please input 'r' (Rock), 'p' (Paper), or 's' (Scissors).");
    		Scanner scan3 = new Scanner(System.in);
            String pmove = scan3.nextLine();
            	if(pmove.equals("r") || pmove.equals("p") || pmove.equals("s")){
            		String cmove = CompPlayerMove();
            		AnalyzeCMove(cmove);
                    res2 = Result(pmove, cmove);
                    if(res2 == 1){
                    	playerScore++;
                    	if(playerScore == 2){
                    		System.out.println("You Won!");
                    		System.out.println("*********************************");
                    		break;
                    	}
                    }
                    if(res2 == 0){
                    	compPlayerScore++;
                    	if(compPlayerScore == 2){
                    		System.out.println("You Lose!");
                    		System.out.println("*********************************");
                    		break;
                    	}
                    }
                    roundcount2++;
            	}
            	else{
            		System.out.println("Invalid selection, try again.");
            		System.out.println("*********************************");
            	}
        	}
        }
        
        while(true){
        	System.out.println("Would you like to play again? Input 'y' (YES) or 'n' (NO)");
        	Scanner scan4 = new Scanner(System.in);
        	String select = scan4.nextLine();
        	if(select.equals("y")){
        		System.out.println("*********************************");
        		startGame();
        	}
        	else if(select.equals("n")){
        		System.out.println("Thank you for playing!");
        		System.exit(0);
        	}
        	else{
        		System.out.println("Invalid selection, try again.");
        		System.out.println("*********************************");
        	}
        }
        
        
	}
	
	public static String CompPlayerMove(){ //randomly selects a number between 0 and 2 to choose computer player's move
		String move = ""; 
		Random r = new Random(); 
        int rval = r.nextInt(3); 
		
        if(rval == 0){
        	move = "r";
        }
        if(rval == 1){
        	move = "p";
        }
        if(rval == 2){
        	move = "s";
        }
        
		return move;
	}
	
	public static int Result(String x, String y){ //describes the result of both players' moves
		if(x.equals("r") && y.equals("p")){
			System.out.println("Computer Player Scored!");
			System.out.println("*********************************");
			return 0;
		}
		if(x.equals("r") && y.equals("s")){
			System.out.println("Player Scored!");
			System.out.println("*********************************");
			return 1;
		}
		if(x.equals("p") && y.equals("s")){
			System.out.println("Computer Player Scored!");
			System.out.println("*********************************");
			return 0;
		}
		if(x.equals("p") && y.equals("r")){
			System.out.println("Player Scored!");
			System.out.println("*********************************");
			return 1;
		}
		if(x.equals("s") && y.equals("r")){
			System.out.println("Computer Player Scored!");
			System.out.println("*********************************");
			return 0;
		}
		if(x.equals("s") && y.equals("p")){
			System.out.println("Player Scored!");
			System.out.println("*********************************");
			return 1;
		}
		if(x.equals("s") && y.equals("s") || x.equals("p") && y.equals("p") || x.equals("r") && y.equals("r")){
			System.out.println("DRAW!");
			System.out.println("*********************************");
			return 2;
		}
		return 4;
	}
	
	public static void AnalyzeCMove(String x){	//analyzes computer player's move to describe it to player
		if(x.equals("r")){
			System.out.println("Computer Player used rock.");
		}
		if(x.equals("p")){
			System.out.println("Computer Player used paper.");
		}
		if(x.equals("s")){
			System.out.println("Computer Player used scissors.");
		}
	}

	public static void main(String[] args) {
		
		startGame();
	}

}
