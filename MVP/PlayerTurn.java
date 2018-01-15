import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class PlayerTurn {
    private static boolean gameOver;
    private static int moveCount;
    private static final String _numbers = "12345678";
    private static final String _letters = "ABCDEFGH";
	private static InputStreamReader isr;
	private static BufferedReader in;
    private static ChessBoard cBoard;

    public PlayerTurn() {
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

        int currentPlayerNum=1;

		String userInput,LetterOne;
		boolean didPlayerEnterValidPair;
		int oldX,oldY,newX,newY;
		//====================user selects piece========================
		System.out.println("Choose the piece you want to move (E2)"); //E2

		String errorMessage = "Invalid Input, please try again";
		try {
			userInput = in.readLine();
			didPlayerEnterValidPair = false;
			if (userInput.length() == 2){
				while (!didPlayerEnterValidPair){
					if (!isInNumbers(userInput.substring(1,2))) { //makes sure user inputs a VALID number
						System.out.println("Numbers must be between 1 and 8");
						try {
						userInput = in.readLine();
						} catch (IOException e){
							System.out.println(errorMessage);
						} catch (StringIndexOutOfBoundsException siobe){
							System.out.println(errorMessage);
						}
					} else if (! isInLetters(userInput.substring(0,1))) { //makes sure user inputs a VALID letter
						System.out.println("Letters must be between A and H");
						try {
						userInput = in.readLine();
						} catch (IOException e){
							System.out.println(errorMessage);
						} catch (StringIndexOutOfBoundsException siobe){
							System.out.println(errorMessage);
						}
					} else {
						didPlayerEnterValidPair = true;
					}
				}

                //OLDX and OLDY are coordinates on the board

				oldX = convertLetter(userInput.substring(0,1)); //sets the position of the piece you want to move
				oldY = Integer.parseInt(userInput.substring(1,2)) - 1;

                if (cBoard.isPieceOnSquare(oldX,oldY)) { //check f there is a piece on the square
    
                    if ( cBoard.getPiece(oldX,oldY).getPlayerNum() == currentPlayerNum) { //check if matching playernumber
                        System.out.println("Choose the location you want to move the piece to"); //request user input
        				//====================user selects destination========================

        				userInput = in.readLine();
        				didPlayerEnterValidPair = false;

        				while (!didPlayerEnterValidPair){
        					if (!isInNumbers(userInput.substring(1,2))) { //makes sure user inputs a VALID number
        						System.out.println("Numbers must be between 1 and 8");
        						try {
        						userInput = in.readLine();
        						} catch (IOException e){
        							System.out.println(errorMessage);
        						} catch (StringIndexOutOfBoundsException siobe){
        							System.out.println(errorMessage);
        						}
        					} else if (! isInLetters(userInput.substring(0,1))) { //makes sure user inputs a VALID letter
        						System.out.println("Letters must be between A and H");
        						try {
        						userInput = in.readLine();
        						} catch (IOException e){
        							System.out.println(errorMessage);
        						} catch (StringIndexOutOfBoundsException siobe){
        							System.out.println(errorMessage);
        						}
        					} else {
        						didPlayerEnterValidPair = true;
        					}
        				}

        				newX = convertLetter(userInput.substring(0,1)); //sets the new position of the piece you want to move
        				newY = Integer.parseInt(userInput.substring(1,2)) - 1;

                        if (cBoard.checkIfLegal(oldX, oldY, newX,newY)) {
                            cBoard.movePiece(oldY,oldX,newY,newX);
                            if (currentPlayerNum==1) {
                                currentPlayerNum=2;
                            }
                            else {
                                currentPlayerNum=1;
                            }
                        }
                        else {
                            System.out.println("Illegal Move. You can't do that. Pick up a rule book. Try again.");
                        }
                    }
                    else {
                        System.out.println("That's not your piece. Try again");
                    }
                }
                else {
                    System.out.println("There's no Piece on that Square. Try again");
                }


            }else {
                System.out.println(errorMessage);
            }
		} catch (IOException e){
			System.out.println(errorMessage);
		} catch (StringIndexOutOfBoundsException siobe){
			System.out.println(errorMessage);
		}

		//=================================================================================

		moveCount += 1; //+1 move

		if (cBoard.checkMate()) { //if in checkmate, end game
			gameOver = false;
		}
	}





    public static void main(String[] args) {
	cBoard = new ChessBoard();
	cBoard.setUp();

	while (!gameOver) {
	    System.out.println(cBoard);
	    play();
	}
	System.out.println("Game Over!");
    }
}
