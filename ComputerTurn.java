import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class ComputerTurn {
    public static boolean gameOver;
    private static int moveCount;
    private static final String _numbers = "12345678";
    private static final String _letters = "ABCDEFGH";
	  private static InputStreamReader isr;
  	private static BufferedReader in;
    public static ChessBoard cBoard;
    private static int currentPlayerNum=1;
    private static String endGameMessage;

    public ComputerTurn() {
        cBoard=new ChessBoard();
        cBoard.setUp();
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


  public static boolean is1000turns(){
      if (moveCount == 2000){
        endGameMessage = "Game Over! 1000 Turns has elapsed.";
        return true;
      } else {
        return false;
      }
  }

  public static void resetMoveCount(){
    moveCount = 0;
  }

    public static void play() {
  		isr = new InputStreamReader(System.in);
  		in = new BufferedReader(isr);



  		String userInput,LetterOne;
  		boolean didPlayerEnterValidPair, legalMove;
  		int oldR,oldC,newR,newC;

      if (is1000turns()){
        gameOver = true; //ends game and displays endgamemessage
      }
/**
      if (King.isCheckMate()) { //if in checkmate, end game
  			//gameOver = true;
  		}
      **/
  		//====================user selects piece========================
  		System.out.println("Choose the piece you want to move (E2)"); //E2

  		String errorMessage = "Invalid Input, please try again";
      oldR = 999;
      oldC = 999; //initializing values
      newR = 999;
      newC = 999;
  		try {
  			userInput = in.readLine();
  			didPlayerEnterValidPair = false;

  				while (!didPlayerEnterValidPair){
            oldC = convertLetter(userInput.substring(0,1)); //sets the position of the piece you want to move
    				oldR = Integer.parseInt(userInput.substring(1,2)) - 1;

            System.out.println(oldC);
            System.out.println(oldR);
            System.out.println(currentPlayerNum);
            System.out.println(cBoard.getPiece(oldR,oldC).getPlayerNum());
            if (userInput.equals("Concede")) {
                if (currentPlayerNum == 1){
                    endGameMessage = Woo.getPlayer1Name() + " has conceded!";
                    errorMessage = Woo.getPlayer1Name() + " has conceded!";
                }
                if (currentPlayerNum == 2){
                    endGameMessage = Woo.getPlayer2Name() + " has conceded!";
                    errorMessage = Woo.getPlayer1Name() + " has conceded!";
                }
                didPlayerEnterValidPair = true;
                gameOver = true;
                break;
              } else if (!isInNumbers(userInput.substring(1,2))) { //makes sure user inputs a VALID number
  						System.out.println("Numbers must be between 1 and 8");

  					} else if (! isInLetters(userInput.substring(0,1))) { //makes sure user inputs a VALID letter
  						System.out.println("Letters must be between A and H");

              userInput = in.readLine();

  					} else if (!(userInput.length() == 2)){
              System.out.println("Not a valid Combination, Try Again");
              userInput = in.readLine();

            } else if (!(cBoard.isPieceOnSquare(oldR,oldC))) { //check f there is a piece on the square
              System.out.println("There is no piece here, Try Again");
              userInput = in.readLine();

            } else if (!((cBoard.getPiece(oldR,oldC)).getPlayerNum() == 1)){
              System.out.println("This is not your piece, Try Again");
              userInput = in.readLine();
            } else{
                for (int[] a: cBoard.getPiece(oldR,oldC).validMoves) {
                    System.out.println(Arrays.toString(a));
                }
                System.out.println(cBoard.getPiece(oldR,oldC).getColor());
                System.out.println(oldR);
                System.out.println(oldC);
                didPlayerEnterValidPair = true;
            }
          }


          System.out.println("Choose the location you want to move the piece to"); //request user input
          userInput = in.readLine();
          didPlayerEnterValidPair = false;
        //====================user selects destination========================
          while (!didPlayerEnterValidPair){
            newC = convertLetter(userInput.substring(0,1)); //sets the new position of the piece you want to move
            newR = Integer.parseInt(userInput.substring(1,2)) - 1;

            if (userInput.equals("Concede")) {
                if (currentPlayerNum == 1){
                    endGameMessage = Woo.getPlayer1Name() + " has conceded!";
                    errorMessage = Woo.getPlayer1Name() + " has conceded!";
                }
                if (currentPlayerNum == 2){
                    endGameMessage = Woo.getPlayer2Name() + " has conceded!";
                    errorMessage = Woo.getPlayer1Name() + " has conceded!";
                }
                didPlayerEnterValidPair = true;
                gameOver = true;
                break;
              } else if (!isInNumbers(userInput.substring(1,2))) { //makes sure user inputs a VALID number
                System.out.println(cBoard.getBoard());

              System.out.println("Numbers must be between 1 and 8");

  					} else if (! isInLetters(userInput.substring(0,1))) { //makes sure user inputs a VALID letter
              System.out.println(cBoard.getBoard());

  						System.out.println("Letters must be between A and H");

              userInput = in.readLine();

  					} else if (!(userInput.length() == 2)){
              System.out.println(cBoard.getBoard());

              System.out.println("Not a valid Combination, Try Again");
              userInput = in.readLine();


            } else if (!(cBoard.isPieceOnSquare(oldR,oldC))) { //check f there is a piece on the square
              System.out.println(cBoard.getBoard());

              System.out.println("There is no piece here, Try Again");
              System.out.println(cBoard.getBoard());

              userInput = in.readLine();

            } else if (!(cBoard.getPiece(oldR,oldC).getPlayerNum() == currentPlayerNum)){
              System.out.println(cBoard.getBoard());

              System.out.println("This is not your piece, Try Again");
              userInput = in.readLine();
            } else if (!(cBoard.checkIfLegal(oldR,oldC,newR,newC))) {
              System.out.println(cBoard.getBoard());

              System.out.println("You can't move there, Try Again");
              userInput = in.readLine();
            }else {
                for (int[] a: cBoard.getPiece(oldR,oldC).validMoves) {
                    System.out.println(Arrays.toString(a));
                }
                System.out.println(cBoard.getPiece(oldR,oldC).getColor());
                System.out.println(oldR);
                System.out.println(oldC);
                didPlayerEnterValidPair = true;
            }
          }

          cBoard.movePiece(oldR,oldC,newR,newC);

        } catch (IOException e){
            System.out.println(errorMessage);
          } catch (StringIndexOutOfBoundsException siobe){
            System.out.println(errorMessage);
          } catch (NumberFormatException nfe){
            System.out.println(errorMessage);
          }

          System.out.println(cBoard.getBoard());


          Computer.moveRandomPiece();

          System.out.println(cBoard.getBoard());


}}
/**
public static void main(String[] args) {
  cBoard = new ChessBoard();
  cBoard.setUp();
  resetMoveCount();

  endGameMessage = "Checkmate! Game over.";
   while (!gameOver) {
      System.out.println(cBoard);
       play();
      }
   System.out.println(endGameMessage);
}
}
**/
