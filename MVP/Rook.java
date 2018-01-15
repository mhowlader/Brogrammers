import java.util.ArrayList;

public class Rook extends ChessPiece {
    //private static int row,col;
    public static ArrayList<int[]> validMoves;
    public Rook(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public ArrayList<int[]> fillValidMoves() {
		validMoves = new ArrayList<int[]>();

        //generates coordinates at the right
        for (int c=col+1;col<8;c++) {
            if (!ChessBoard.isPieceOnSquare(row,c)) {
                validMoves.add(new int[]{row,c});
            }
        }

        //coordinates at the left
        for (int c=col-1;col>=0;c--) {
            if (!ChessBoard.isPieceOnSquare(row,c)) {
                validMoves.add(new int[]{row,c});
            }
        }

        //generates coordinates downwards
        for (int r=row+1;r<8;r++) {
            if (!ChessBoard.isPieceOnSquare(r,col)) {
                validMoves.add(new int[]{r,col});
            }
        }

        //generates coordinates upwards
        for (int r=row-1;r>=0;r--) {
            if (!ChessBoard.isPieceOnSquare(r,col)) {
                validMoves.add(new int[]{r,col});
            }
        }

        return validMoves;
    }
    public String toString() {
	return "R";
    }
}
