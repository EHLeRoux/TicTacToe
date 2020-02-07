import java.util.Scanner;

/**
 * @author Eduard Le Roux
 */

public class TicTacToe {

	private static String[][] Board = new String[3][3];

	//constructor clears the board for a new game
	public TicTacToe() {
		clearBoard();
	}

	public void clearBoard() {
		//simply clears the board with a - character
		for (int i = 0; i < Board.length; i++) {
			for (int j = 0; j < Board[0].length; j++) {
				Board[i][j] = "-";
			}
		}

		printBoard(Board);
	}

	//prints out the board structure
	public void printBoard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println("---------");
			for (int j = 0; j < board[0].length; j++) {
				System.out.print("|" + board[i][j] + "|");
			}
			System.out.println();

		}
		System.out.println("---------");
	}

	//runnning of the game and updating the board as the players choose their positions
	public void run(String[][] board) {

		int player = 1;

		Scanner userChoiceX = new Scanner(System.in);
		Scanner userChoiceY = new Scanner(System.in);
		int userXPosition = 0;
		int userYPosition = 0;

		while (true) {
			System.out.println("Please choose your X position player" + player);
			userXPosition = userChoiceX.nextInt();

			System.out.println("Please choose your Y position player" + player);
			userYPosition = userChoiceY.nextInt();

			//Checks that duplicates are not played on the board
			while (board[userXPosition][userYPosition] == "X" || board[userXPosition][userYPosition] == "O" ) {
				printBoard(board);
				System.out.println("Invalid play, please choose again:");
				
				System.out.println("Please choose your X position player" + player);
				userXPosition = userChoiceX.nextInt();

				System.out.println("Please choose your Y position player" + player);
				userYPosition = userChoiceY.nextInt();
				
			}
			if (player == 1) {

				board[userXPosition][userYPosition] = "X";
			} else if (player == 2) {
				board[userXPosition][userYPosition] = "O";
			}

			if (player == 1) {
				player++;
			} else if (player == 2) {
				player--;
			}
			printBoard(board);
		
			if (checkWin(board) == "X") { 
				System.out.println("The Winner is " + checkWin(board));
				break;
			} else if (checkWin(Board) == "O") { 
				System.out.println("The Winner is " + checkWin(board));
				break;
			}

		}
		
		System.out.println("Thanks for playing!");

	}

	//Checks which player wins
	public String checkWin(String[][] board) {
		String winner = "Game not over";
		//top row
		if (board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X") winner = "X";
		else if (board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O") winner = "O";
		//middle row
		else if (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X") winner = "X";
		else if (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O") winner = "O";
		//bottom row
		else if (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X") winner = "X";
		else if (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O") winner = "O";
		//left column
		else if (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") winner = "X";
		else if (board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O") winner = "O";
		//middle column
		else if (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X") winner = "X";
		else if (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O") winner = "O";
		//right column
		else if (board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X") winner = "X";
		else if (board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O") winner = "O";
		//right diagonal 
		else if (board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") winner = "X";
		else if (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O") winner = "O";
		//left diagonal
		else if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") winner = "X";
		else if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") winner = "O";
		
		return winner;
	}

	public static void main(String[] args) {
		Scanner userChoice = new Scanner(System.in);

		TicTacToe game = new TicTacToe();
		game.run(Board);

	}
}
