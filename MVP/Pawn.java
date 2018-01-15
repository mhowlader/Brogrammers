
import java.util.ArrayList;
public class Pawn extends ChessPiece {
    //private static int row,col;
    public static ArrayList<int[]> validMoves;
    public Pawn(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public ArrayList<int[]> fillValidMoves() {
		validMoves = new ArrayList<int[]>();

        if (color.equals("White") ) {
            if (!ChessBoard.isPieceOnSquare(row+1,col)) {
                validMoves.add(new int[]{row+1,col});
                if (row==1 && !ChessBoard.isPieceOnSquare(row+2,col)) {
                    validMoves.add(new int[]{row+2,col});
                }
            }

            if (!ChessBoard.squareExists(row+1,col+1) && ChessBoard.isPieceOnSquare(row+1,col+1) && !sameColor(ChessBoard.getPiece(row+1,col+1))) {
                validMoves.add(new int[]{row+1,col+1});
            }

            if (!ChessBoard.squareExists(row+1,col-1) && ChessBoard.isPieceOnSquare(row+1,col-1) && !sameColor(ChessBoard.getPiece(row+1,col-1))) {
                validMoves.add(new int[]{row+1,col-1});
            }
        }

        if (color.equals("Black") ) {
            if (!ChessBoard.isPieceOnSquare(row-1,col)) {
                validMoves.add(new int[]{row-1,col});
                if (row==1 && !ChessBoard.isPieceOnSquare(row-2,col)) {
                    validMoves.add(new int[]{row-2,col});
                }
            }

            if (!ChessBoard.squareExists(row-1,col-1) && ChessBoard.isPieceOnSquare(row-1,col-1) && !sameColor(ChessBoard.getPiece(row-1,col-1))) {
                validMoves.add(new int[]{row-1,col-1});
            }

            if (!ChessBoard.squareExists(row-1,col+1) && ChessBoard.isPieceOnSquare(row-1,col+1) && !sameColor(ChessBoard.getPiece(row-1,col+1))) {
                validMoves.add(new int[]{row-1,col+1});
            }
        }

        return validMoves;
    }
    public String toString() {
	return "P";
    }
}
