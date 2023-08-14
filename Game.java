/* Jason Lahoda
 * Section 4
 * The purpose of this program is to execute a game. I took suggestions from the teachers in the lab session. */

/* OUTLINE:
 * intro within the main execution function
 * establishing variables, setting up scanners/randoms within main function
 * iteration for the game to keep going, with stats showing each time
 * game stats function
 * helper functions (to ensure the program doesn't need to be restarted for misinputs)
 * game execution function
 * random computer selection function
 * judge/comparison function (between computer and player)
 * intro function
 * end */

import java.util.*;

public class Game {

	
	public static void main(String[] args) {

		introduction();
		
		Scanner console = new Scanner(System.in);
		Random numberGenerator = new Random();
		
		int timesWon = 0;
		
		int timesPlayed = 0;
		
		System.out.println("Enter y to play the game or n to finish");
		
		Boolean gameCondition = choiceHelper(console);
		
		while (gameCondition == true) {
			String computerMove = getComputerMove(numberGenerator);
			int gameResult = playGame(console, computerMove);
			if (gameResult == 1) {
				System.out.println();
				System.out.println("You win");
				timesWon += 1;
			}
			else {
				System.out.println();
				System.out.println("You lose");
			}
			timesPlayed += 1;
			System.out.println();
			System.out.println("Enter y to play again or n to finish");
			gameCondition = choiceHelper(console);
		}
		getGameStats(timesPlayed, timesWon);
		
	}
	//END OF MAIN
	
	public static void getGameStats(int timesPlayed, int timesWon) {
		
		System.out.println();
		System.out.println("Times played: " + timesPlayed);
		System.out.println("Times you won: "+ timesWon);
		System.out.println("Times you lost: "+ (timesPlayed - timesWon));
		
	}
	
	public static Boolean choiceHelper(Scanner console) {
		
		String playChoice = console.nextLine().toLowerCase();
		while ((!playChoice.equals("n")) && (!playChoice.equals("y"))) {
			System.out.println("Invalid input, enter y or n");
			playChoice = console.nextLine().toLowerCase();
		}
		if (playChoice.equals("y")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static int moveHelper(String userMove) {
		
		int moveNum = -1;
		switch(userMove) {
		case "skadis" :
			moveNum = 1;
			break;
		case "tjusig" :
			moveNum = 1;
			break;
		case "klyket" :
			moveNum = 1;
			break;
		case "hovolm" :
			moveNum = 1;
			break;
		case "pershult" :
			moveNum = 1;
			break;
		default:
			moveNum = -1;
		}
	return moveNum;
	}
	
	public static int playGame(Scanner console, String computerMove) {
		
		System.out.println("Enter your move:");
		String userMove = console.nextLine().toLowerCase();
		
		while(moveHelper(userMove) == -1) {
			System.out.println("Invalid input, enter a valid move");
			userMove = console.nextLine().toLowerCase();
		}
		
		System.out.println();
		System.out.println("Your move is " + userMove);
		System.out.println("CPU move is " + computerMove);
		int gameResult = gameJudge(userMove, computerMove);
		return gameResult;
		
	}
	
	public static int gameJudge(String userMove, String computerMove) {
		int gameResult = 0;
		if (userMove.equals("pershult")) {
			if (computerMove.equals("klyket")) {
				gameResult = 1;
			}
			else if (computerMove.equals("skadis")) {
				gameResult = 1;
			}
		}
		
		else if (userMove.equals("klyket")) {
			if (computerMove.equals("tjusig")) {
				gameResult = 1;
			}
			else if (computerMove.equals("hovolm")) {
				gameResult = 1;
			}
		}
		
		else if (userMove.equals("tjusig")) {
			if (computerMove.equals("pershult")) {
				gameResult = 1;
			}
			else if (computerMove.equals("skadis")) {
				gameResult = 1;
			}
		}
		
		else if (userMove.equals("skadis")) {
			if (computerMove.equals("hovolm")) {
				gameResult = 1;
			}
			else if (computerMove.equals("klyket")) {
				gameResult = 1;
			}
		}
		
		else if (userMove.equals("hovolm")) {
			if (computerMove.equals("pershult")) {
				gameResult = 1;
			}
			else if (computerMove.equals("tjusig")) {
				gameResult = 1;
			}
		}
		return gameResult;
	}
	
	public static String getComputerMove(Random numberGenerator) {
		
		String computerMove = "";
		int number = numberGenerator.nextInt(4);
		switch(number) {
		case 0 :
			computerMove = "skadis";
			break;
		case 1 :
			computerMove = "tjusig";
			break;
		case 2 :
			computerMove = "klyket";
			break;
		case 3 :
			computerMove = "hovolm";
			break;
		case 4 :
			computerMove = "pershult";
			break;
		}
		return computerMove;
	}
	
	public static void introduction() {
		
		System.out.println("During each round, players choose a move, which may be either Skadis, Tjusig, Klyket, Hovolm, or Pershult. The rules are:");
		System.out.println("Pershult beats Klyket, Skadis");
		System.out.println("Klyket beats Tjusig, Hovolm");
		System.out.println("Tjusig beats Pershult, Skadis");
		System.out.println("Skadis Beats Hovolm, Klyket");
		System.out.println("Hovolm beats Pershult, Tjusig");
		System.out.println("The CPU wins in the event of a tie.");
		
	}
}
