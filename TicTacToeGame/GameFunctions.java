package TicTacToeGame;

import java.util.Random;

public class GameFunctions {
	
	protected static int[][] autoMove(int[][] board, int round) {
		Random random = new Random();
		int[] entry = new int[2];
		int[][] newBoard = board;
		
		if (round == 2 && board[1][1] == 1) {
			entry = corner();
			newBoard = assign(board, entry, 2);
			return newBoard;
		} else if (round == 2) {
			do {
				entry = corner();
			} while (overlap(board, entry));
			return newBoard = assign(board, entry, 2);
		}
		
		if (round > 2 && testAtt(board)) {
			entry = attPlay(board);
			newBoard = assign(board, entry, 2);
			return newBoard;
		} else if (round > 2 && testBlocks(board)) {
			entry = blockPlay(board);
			newBoard = assign(board, entry, 2);
			return newBoard;
		}  
		
		do {
			entry[0] = random.nextInt(3);
			entry[1] = random.nextInt(3);
		} while (overlap(board, entry));
		newBoard = assign(board, entry, 2);
		return newBoard;
	}
	
	private static int[] attPlay(int[][] board) {
		Random random = new Random();
		int[] entry = new int[2];
		
		if (fallDiagonal(board, 1)) {
			for (int i = 0; i < 3; i++) {
				entry[0] = i;
				entry[1] = i;
				if (!overlap(board, entry)) {
					return entry;
				}
			}
		}
		
		if (riseDiagonal(board, 1)) {
			for (int i = 0; i < 3; i++) {
				entry[0] = i;
				entry[1] = 2-i;
				if (!overlap(board, entry)) {
					return entry;
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (hBlock(board, i, 1)) {
				do {
					entry[0] = i;
					entry[1] = random.nextInt(3);
				} while (overlap(board, entry));
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (vBlock(board, i, 1)) {
				do {
					entry[0] = random.nextInt(3);
					entry[1] = i;
				} while (overlap(board, entry));
			}
		}
		
		return entry;
	}
	
	private static boolean testAtt(int[][] board) {
		for (int i = 0; i < 3; i++) {
			if (hBlock(board, i, 2)) {
				return true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (vBlock(board, i, 2)) {
				return true;
			}
		}
		
		if (fallDiagonal(board, 2)) {
			return true;
		} else if (fallDiagonal(board, 2)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean testBlocks(int[][] board) {
		for (int i = 0; i < 3; i++) {
			if (hBlock(board, i, 1)) {
				return true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (vBlock(board, i, 1)) {
				return true;
			}
		}
		
		if (fallDiagonal(board, 1)) {
			return true;
		} else if (riseDiagonal(board, 1)) {
			return true;
		}
		
		return false;
	}
	
	private static int[] blockPlay(int[][] board) {
		Random random = new Random();
		int[] entry = new int[2];
		
		if (fallDiagonal(board, 1)) {
			for (int i = 0; i < 3; i++) {
				entry[0] = i;
				entry[1] = i;
				if (!overlap(board, entry)) {
					return entry;
				}
			}
		}
		
		if (riseDiagonal(board, 1)) {
			for (int i = 0; i < 3; i++) {
				entry[0] = i;
				entry[1] = 2-i;
				if (!overlap(board, entry)) {
					return entry;
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (hBlock(board, i, 1)) {
				do {
					entry[0] = i;
					entry[1] = random.nextInt(3);
				} while (overlap(board, entry));
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (vBlock(board, i, 1)) {
				do {
					entry[0] = random.nextInt(3);
					entry[1] = i;
				} while (overlap(board, entry));
			}
		}
		
		return entry;
	}
	
	private static boolean fallDiagonal(int[][] board, int num) {
		if (board[0][0] == num && board[1][1] == num && board[2][2] == 0) {
			return true;
		} else if (board[0][0] == num && board[1][1] == 0 && board[2][2] == num) {
			return true;
		} else if (board[0][0] == 0 && board[1][1] == num && board[2][2] == num) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean riseDiagonal(int[][] board, int num) {
		if (board[2][0] == num && board[1][1] == num && board[0][2] == 0) {
			return true;
		} else if (board[2][0] == num && board[1][1] == 0 && board[0][2] == num) {
			return true;
		} else if (board[2][0] == 0 && board[1][1] == num && board[0][2] == num) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean hBlock(int[][] board, int row, int num) {
		if (board[row][1] == num && board[row][2] == num && board[row][0] == 0) {
			return true;
		} else if (board[row][0] == num && board[row][2] == num && board[row][1] == 0) {
			return true;
		} else if (board[row][0] == num && board[row][1] == num && board[row][2] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean vBlock(int[][] board, int col, int num) {
		if (board[1][col] == num && board[2][col] == num && board[0][col] == 0) {
			return true;
		} else if (board[0][col] == num && board[2][col] == num && board[1][col] == 0) {
			return true;
		} else if (board[0][col] == num && board[1][col] == num && board[2][col] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private static int[] corner() {
		Random random = new Random();
		int[] entry = new int[2];
		int temp = 0;
		
		for (int i = 0; i < 2; i++) {
			temp = random.nextInt(2);
			if (temp == 0) {
				entry[i] = 0;
			} else {
				entry[i] = 2;
			}
		}
		
		return entry;
	}
	
	protected static int testWin(int[][] board) {
		int winner = 0;
		
		// Scans for horizontal wins
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == board[row][1] && board[row][0] == board[row][2]) {
				winner = board[row][0];
				return winner;
			}
		}
		
		// Scans for vertical wins
		for (int col = 0; col < 3; col++) {
			if (board[0][col] == board[1][col] && board[0][col] == board[2][col]) {
				winner = board[0][col];
				return winner;
			}
		}
		
		// Scans for falling diagonal wins
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			winner = board[0][0];
			return winner;
		}
		
		// Scans for rising diagonal wins
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			winner = board[0][2];
			return winner;
		}
		
		return winner;
	}
	
	protected static boolean overlap(int[][] board, int[] entry) {
		
		if (board[entry[0]][entry[1]] > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	protected static int[][] assign(int[][] board, int[] entry, int num) {
		
		board[entry[0]][entry[1]] = num;
		
		return board;
	}
	
	protected static void printBoard(int[][] board) {
		//System.out.println("-------------");
		//System.out.println("| O | O | O |");
		//System.out.println("-------------");
		//System.out.println("| O | X | O |");
		//System.out.println("-------------");
		//System.out.println("| O | O | O |");
		//System.out.println("-------------");
		
		System.out.println("\n-------------");
		for (int row = 0; row < 3; row++) {
			
			System.out.print("|");
			for (int col = 0; col < 3; col++) {
				System.out.print(" " + convertToString(board[row][col]) + " ");
				if (col < 2) {
					System.out.print("|");
				}
			}
			System.out.print("|");
			
			if (row < 2) {
				System.out.println("\n-------------");
			}
		}
		System.out.println("\n-------------");
		
	}// Method End
	
 	private static String convertToString(int num) {
		if (num == 0) {
			return " ";
		} else if (num == 1) {
			return "X";
		} else if (num == 2) {
			return "O";
		} else {
			System.out.println("\n Invalid Entry number");
			return "Error";
		}
	}
	
 	// Scrapped method
 	protected static void fillArray(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board[i].length; k++) {
				board[i][k] = 2;
			}
		}
	}

}