import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Pawn extends ChessPiece {
    //private static int row,col;

	private static InputStreamReader isr;
	private static BufferedReader in;


    public Pawn(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public void fillValidMoves() {
		validMoves = new ArrayList<int[]>();


        //generates all valid moves for any given pawn
        if (color.equals("White") ) {
            if (!ChessBoard.isPieceOnSquare(row+1,col)) {
                validMoves.add(new int[]{row+1,col});
                if (row==1 && !ChessBoard.isPieceOnSquare(row+2,col)) {
                    validMoves.add(new int[]{row+2,col});
                }
            }

            if (ChessBoard.squareExists(row+1,col+1) && ChessBoard.isPieceOnSquare(row+1,col+1) && !sameColor(ChessBoard.getPiece(row+1,col+1))) {
                validMoves.add(new int[]{row+1,col+1});
            }

            if (ChessBoard.squareExists(row+1,col-1) && ChessBoard.isPieceOnSquare(row+1,col-1) && !sameColor(ChessBoard.getPiece(row+1,col-1))) {
                validMoves.add(new int[]{row+1,col-1});
            }
        }

        else if (color.equals("Black")) {
            if (!ChessBoard.isPieceOnSquare(row-1,col)) {
                validMoves.add(new int[]{row-1,col});
                if (row==6 && !ChessBoard.isPieceOnSquare(row-2,col)) {
                    validMoves.add(new int[]{row-2,col});
                }
            }

            if (ChessBoard.squareExists(row-1,col-1) && ChessBoard.isPieceOnSquare(row-1,col-1) && !sameColor(ChessBoard.getPiece(row-1,col-1))) {
                validMoves.add(new int[]{row-1,col-1});
            }

            if (ChessBoard.squareExists(row-1,col+1) && ChessBoard.isPieceOnSquare(row-1,col+1) && !sameColor(ChessBoard.getPiece(row-1,col+1))) {
                validMoves.add(new int[]{row-1,col+1});
            }
        }
    }


    public void upgradePawn(int row, int col, int player){
		isr = new InputStreamReader(System.in);
		in = new BufferedReader(isr);
		String userInput;

		String errorMessage = "Invalid piece name, available pieces : Bishop, Knight, Queen, Rook";
		System.out.println("What piece do you want to promote your pawn into? Enter full name of the piece");
		try {
			userInput = in.readLine();
			//checks userinput for a valid choice
			if(userInput.equals("Bishop")){
			ChessBoard.setPieceOnBoard(row, col, new Bishop(row, col, player));
			} else if(userInput.equals("Knight")){
			ChessBoard.setPieceOnBoard(row, col, new Knight(row, col, player));
			} else if (userInput.equals("Queen")){
			ChessBoard.setPieceOnBoard(row, col, new Queen(row, col, player));
			} else if (userInput.equals("Rook")){
			ChessBoard.setPieceOnBoard(row, col, new Rook(row, col, player));
			} else {
			System.out.println(errorMessage);
			}
		} catch (IOException e){
			System.out.println(errorMessage);
		}
    }

    public String toString() {
	return "P";
    }
}
