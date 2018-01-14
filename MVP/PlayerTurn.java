import java.util.Scanner;
public class PlayerTurn {
    private static boolean gameOver;
    private static int moveCount; 
    public PlayerTurn() {
	gameOver = false;
	moveCount = 0; 
    }
    public static int convertLetter(char letter) {
	char c;
	int output = 0;
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
    public static void play() {
	while (!gameOver) {
	    Scanner in = new Scanner(System.in);
	    String line,LetterOne;
	    int oldX,oldY,newX,newY;
	    System.out.println("Choose the piece you want to move"); //E2
	    line = in.nextLine();
	    LetterOne = line.substring(0,1);
	    char letterOnePosition = LetterOne.charAt(0);
	    oldX = convertLetter(letterOnePosition);
	    oldY = (-1 * Integer.parseInt(line.substring(1,2))) + 8;
	    System.out.println("Choose the location you want to move the piece to"); //E3
	    line = in.nextLine();
	    LetterOne = line.substring(0,1);
	    char letterOneDestination = LetterOne.charAt(0);
	    newX = convertLetter(letterOneDestination);
	    newY = (-1 * Integer.parseInt(line.substring(1,2))) + 8;
	    ChessBoard.movePiece(oldY,oldX,newY,newX);
	    if (ChessBoard.checkMate()) {
		gameOver = true;
	    }
	}
	System.out.println("Game Over!");
    }
    public static void main(String[] args) {
	ChessBoard m1 = new ChessBoard();
	m1.setUp();
	System.out.println(m1);
	play();
        System.out.println(m1);
    }
}

