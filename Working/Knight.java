import java.util.ArrayList;

public class Knight extends ChessPiece {
    //private static int row,col;
    public Knight(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public void fillValidMoves() {
        validMoves=new ArrayList<int[]>();

        //2d array of all possible moves for a knight
        int[][] tempCol= new int[][]{
            {row-2,col-1},
            {row-2,col+1},
            {row-1,col+2},
            {row-1,col-2},
            {row+1,col+2},
            {row+1,col-2},
            {row+2,col+1},
            {row+2,col-1}
        };

        //adds those 2d arrays to validMoves
        for (int[] b:tempCol) {
            int r=b[0]; //row of tempCol
            int c=b[1]; //column of tempCol
            if (ChessBoard.squareExists(r,c)) { //checks if the square is on the chessboard
		if (!ChessBoard.isPieceOnSquare(r,c) || !sameColor(ChessBoard.getPiece(r,c)) ) { //it's either an empty square or a square with an enemy piece
		    validMoves.add(b); //add itto validmoves if so
		}
            }
        }


        //deletes invalid ones
        for (int[] a: validMoves) {
            if (!ChessBoard.squareExists(a[0],a[1])) {
                validMoves.remove(a);
            }
	}
    }
    public  ArrayList<int[]> getValidMoves() {
	return validMoves;
    }

    public String toString() {
        return "H";
    }
}
