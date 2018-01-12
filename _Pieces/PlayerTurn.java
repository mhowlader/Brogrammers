import java.util.Scanner;
public class PlayerTurn {
    private boolean gameOver;
    private int moveCount; 
    public PlayerTurn() {
	gameOver = false;
	moveCount = 0; 
    }
    public int convertLetter(char letter) {
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
    public void play() {
	while (!gameOver) {
	    Scanner in = new Scanner(System.in);
	    String line,LetterOne;
	    int oldX,oldY,newX,newY;
	    System.out.println("Choose the piece you want to move"); //E3
	    line = in.nextLine();
	    LetterOne = line.substring(0,1);
	    char letterOnePosition = LetterOne.charAt(0);
	    oldX = convertLetter(letterOnePosition);
	    oldY = Integer.parseInt(line.substring(1,2)) - 1;
	    System.out.println("Choose the location you want to move the piece to"); //E3
	    line = in.nextLine();
	    LetterOne = line.substring(0,1);
	    char letterOneDestination = LetterOne.charAt(0);
	    newX = convertLetter(letterOneDestination);
	    newY = Integer.parseInt(line.substring(1,2)) - 1;
	    ChessBoard.movePiece(oldX,oldY,newX,newY);
	    if (ChessBoard.checkMate()) {
		gameOver = true;
	    }
	}
	System.out.println("Game Over!");
    }
}

