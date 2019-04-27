/* Tick tack tow game using console (i.e. X   O
 * 										  O X O
 * 										  X X O)
 * Inputs two number (e.g. 3, 3)
 * Option for two players or AI
 * 
 */

package TicTacToeGame;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe extends GameFunctions {

	static Scanner input = new Scanner(System.in);
	
	static int[][] gameBoard = new int[3][3];
	/* rows before column
	 * (1,1) (1,2) (1,3)
	 * (2,1) (2,2) (2,3)
	 * (3,1) (3,2) (3,3)
	 * States:
	 * 0 - *space*
	 * 1 - X
	 * 2 - O
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.deepToString(gameBoard));
		//fillArray(gameBoard);
		//printBoard(gameBoard);
		
		play();
		
	}
	
	private static void play() {
		int mode = 0;
		/* 1 - PvP
		 * 2 - AI (player goes first)
		 */
		
		System.out.print("1 for PvP, 2 for AI: ");
		do {
			mode = input.nextInt();
			if (mode != 1 && mode != 2) {
				System.out.println("Invalid entry - enter again");
			}
		} while (mode != 1 && mode != 2);
		
		
		// Repeats for all the rounds
		for (int round = 1; round <= 9; round++) {
			switch (mode) {
			case 1: PvP(round); break;
			case 2: AI(round); break;
			default: break;
			}
			
			printBoard(gameBoard);
			
			if (round >= 3 && testWin(gameBoard) > 0) {
				break;
			}
		}
		
		if (testWin(gameBoard) > 0) {
			
			if (testWin(gameBoard) == 2 && mode == 2) {
				System.out.println("Computer wins");
			} else {
				System.out.println("Player" + testWin(gameBoard) + " wins");
			}
			
		}  else {
			System.out.println("Tie");
		}
		
	}
	
	private static void PvP(int round) {

		if (round%2 == 0) {
			player(2);
		} else {
			player(1);
		}
		
	}
	
	private static void player(int num) {
		int[] entry = new int[2];

		do {
			System.out.print("Player" + num + " enter row: ");
			entry[0] = input.nextInt() - 1;
			System.out.print("Player" + num + " enter column: ");
			entry[1] = input.nextInt() - 1;
			
			if (0 > entry[0] || 0 > entry[1] || 2 < entry[0] || 2 < entry[1] || overlap(gameBoard, entry)) {
				System.out.println("Invalid entry - enter again");
			}
			
		} while (0 > entry[0] || 0 > entry[1] || 2 < entry[0] || 2 < entry[1] || overlap(gameBoard, entry));

		gameBoard = assign(gameBoard, entry, num);
	}
	
	private static void AI(int round) {
		
		if (round%2 == 0) {
			gameBoard = autoMove(gameBoard, round);
		} else {
			player(1);
		}
		
	}

}
































