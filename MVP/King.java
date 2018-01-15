import java.util.ArrayList;

public class King extends ChessPiece {
    //private static int row,col;
    public King(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public ArrayList<int[]> fillValidMoves() {
		validMoves = new ArrayList<int[]>();
        int[][] tempCol= new int[][]{
            {row+1,col},
            {row+1,col+1},
            {row+1,col-1},
            {row,col-1},
            {row,col+1},
            {row-1,col-1},
            {row-1,col},
            {row-1,col+1}
        };

        for (int[] b:tempCol) {
            int r=b[0]; //row of tempCol
            int c=b[1]; //column of tempCol
            if (ChessBoard.squareExists(r,c)) { //checks if the square is on the chessboard
              if (!ChessBoard.isPieceOnSquare(r,c) || !sameColor(ChessBoard.getPiece(r,c)) ) { //it's either an empty square or a square with an enemy piece
                  validMoves.add(b); //add itto validmoves if so
              }
            }
        }
        return validMoves;
    }
    public String toString() {
	return "K";
    }
}
