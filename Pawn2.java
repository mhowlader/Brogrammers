import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Pawn2 extends ChessPiece {
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
            if (!ChessBoard2.isPieceOnSquare(row+1,col)) {
                validMoves.add(new int[]{row+1,col});
                if (row==1 && !ChessBoard2.isPieceOnSquare(row+2,col)) {
                    validMoves.add(new int[]{row+2,col});
                }
            }

            if (ChessBoard2.squareExists(row+1,col+1) && ChessBoard2.isPieceOnSquare(row+1,col+1) && !sameColor(ChessBoard2.getPiece(row+1,col+1))) {
                validMoves.add(new int[]{row+1,col+1});
            }

            if (ChessBoard2.squareExists(row+1,col-1) && ChessBoard2.isPieceOnSquare(row+1,col-1) && !sameColor(ChessBoard2.getPiece(row+1,col-1))) {
                validMoves.add(new int[]{row+1,col-1});
            }
        }

        else if (color.equals("Black") ) {
            if (!ChessBoard2.isPieceOnSquare(row-1,col)) {
                validMoves.add(new int[]{row-1,col});
                if (row==6 && !ChessBoard2.isPieceOnSquare(row-2,col)) {
                    validMoves.add(new int[]{row-2,col});
                }
            }

            if (ChessBoard2.squareExists(row-1,col-1) && ChessBoard2.isPieceOnSquare(row-1,col-1) && !sameColor(ChessBoard2.getPiece(row-1,col-1))) {
                validMoves.add(new int[]{row-1,col-1});
            }

            if (ChessBoard2.squareExists(row-1,col+1) && ChessBoard2.isPieceOnSquare(row-1,col+1) && !sameColor(ChessBoard2.getPiece(row-1,col+1))) {
                validMoves.add(new int[]{row-1,col+1});
            }
        }
    }
}
