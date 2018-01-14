
import java.util.ArrayList;
import java.util.Scanner;
public class PlayerTurn {
    private static boolean gameOver;
    private static int moveCount;
    private static int[] numbers;
    private static String[] letters;
    public PlayerTurn() {
	gameOver = false;
	moveCount = 0;
    }
    public static int convertLetter(char letter) {
	int output = 0;
	char c;
	for(c = 'A'; c <= 'H'; c++) { //c++ vs. ++c
	    if (c == letter) {
		return output;
	    }
	    else {
		output += 1;
	    }
	}
	return 0; //change maybe
    }
    public static void fillNumbers() {
	numbers = new int[8];
	for (int ctr = 0; ctr < 8; ctr++) {
	    numbers[ctr] = ctr+1;
	}
    }
    public static void fillLetters() {
	int ctr = 0;
	char c;
	letters = new String[8];
	for(c = 'A'; c <= 'H'; c++) {
	    letters[ctr] = c + "";
	}
    }
    public static boolean intInArray(int x, int[] y) {
	for(int num : y) {
	    if (num == x) {
		return true;
	    }
	}
	return false;
    }
    public static boolean stringInArray(String x, String[] y) {
	for(String letter : y) {
	    if (letter.equals(x)) {
		return true;
	    }
	}
	return false;
    }
    public static void play() {
	Scanner in = new Scanner(System.in);
	String line,LetterOne;
	int oldX,oldY,newX,newY;
	System.out.println("Choose the piece you want to move"); //E2
	line = in.nextLine();
	if (!intInArray(Integer.parseInt(line.substring(1,2)),numbers)) {
	    System.out.println("Numbers must be between 1 and 8");
	    line = in.nextLine();
	}
	if (!stringInArray(line.substring(1,2),letters)) {
	    System.out.println("Letters must be between A and E");
	    line = in.nextLine();
	}
	LetterOne = line.substring(0,1);
	char letterOnePosition = LetterOne.charAt(0);
	oldX = convertLetter(letterOnePosition);
	oldY = (-1 * Integer.parseInt(line.substring(1,2))) + 8;
	System.out.println("Choose the location you want to move the piece to"); //E3}
	line = in.nextLine();
	LetterOne = line.substring(0,1);
	char letterOneDestination = LetterOne.charAt(0);
	newX = convertLetter(letterOneDestination);
	newY = (-1 * Integer.parseInt(line.substring(1,2))) + 8;
	ChessBoard.movePiece(oldY,oldX,newY,newX);
	if (ChessBoard.checkMate()) {
	    gameOver = false;
	}
    }
    public static void main(String[] args) {
	ChessBoard m1 = new ChessBoard();
	m1.setUp();
	fillNumbers();
	fillLetters();
	while (!gameOver) {
	    System.out.println(m1);
	    play();
	}
	System.out.println("Game Over!");
    }
}
