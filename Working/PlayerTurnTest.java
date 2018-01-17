import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class PlayerTurnTest {
    private static boolean gameOver;
    private static int moveCount;
    private static final String _numbers = "12345678";
    private static final String _letters = "ABCDEFGH";
	private static InputStreamReader isr;
	private static BufferedReader in;

    public PlayerTurnTest() {
	gameOver = false;
	moveCount = 0;

    }
    public static int convertLetter(String letter) {
		int output = 999;
		for(int i = 0; i < 8; i++) {
			if (letter.equals(_letters.substring(i, i + 1))){
				output = i;
			}
		}
		return output;
    }

    public static boolean isInLetters(String str){ //str can only be 1 letter
		for (int i = 0; i < 8; i++){
			if (str.equals(_letters.substring(i, i + 1))){
				return true;
			}
		}
		return false;
	}

	public static boolean isInNumbers(String numStr){ // numStr = num in string form
		for (int i = 0; i < 8; i++){
			if (numStr.equals(_numbers.substring(i, i + 1))){
				return true;
			}
		}
		return false;
	}

    public static void play() {
		isr = new InputStreamReader(System.in);
		in = new BufferedReader(isr);

		String userInput,LetterOne;
		boolean didPlayerEnterValidPair;
		int oldX,oldY,newX,newY;

		System.out.println("Choose the piece you want to move (E2)"); //E2


		userInput = in.readLine();


		didPlayerEnterValidPair = false;

		while (!didPlayerEnterValidPair){
			if (!isInNumbers(userInput.substring(1,2))) { //makes sure user inputs a VALID number
				System.out.println("Numbers must be between 1 and 8");
				userInput = in.readLine();
			} else if (! isInLetters(userInput.substring(0,1))) { //makes sure user inputs a VALID letter
				System.out.println("Letters must be between A and H");
				userInput = in.readLine();
			} else {
				didPlayerEnterValidPair = true;
			}
		}
		/**
			try {
			userInput = in.readLine();

		} catch (IOException e) {
			System.out.println ("bad");
		}
		**/

		oldX = convertLetter(userInput.substring(0,1));
		oldY = Integer.parseInt(userInput.substring(1,2)) - 1;

		System.out.println("Choose the location you want to move the piece to");
		userInput = in.readLine();
		didPlayerEnterValidPair = false;

		while (!didPlayerEnterValidPair){
			if (!isInNumbers(userInput.substring(1,2))) { //makes sure user inputs a VALID number
				System.out.println("Numbers must be between 1 and 8");
				userInput = in.readLine();
			} else if (! isInLetters(userInput.substring(0,1))) { //makes sure user inputs a VALID letter
				System.out.println("Letters must be between A and H");
				userInput = in.readLine();
			} else {
				didPlayerEnterValidPair = true;
			}
		}

		newX = convertLetter(userInput.substring(0,1));
		newY = Integer.parseInt(userInput.substring(1,2)) - 1;

		ChessBoard.movePiece(oldY,oldX,newY,newX);

		moveCount += 1; //+1 move

		if (ChessBoard.checkMate()) {
			gameOver = false;
		}
	}



    public static void main(String[] args) {
	ChessBoard m1 = new ChessBoard();
	m1.setUp();

	while (!gameOver) {
	    System.out.println(m1);
	    play();
	}
	System.out.println("Game Over!");
    }
}
