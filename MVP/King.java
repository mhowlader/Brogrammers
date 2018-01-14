import java.util.ArrayList;

public class King extends ChessPiece {
    private static int row,col;
    public static ArrayList<int[]> validMoves;
    public King(int x,int y) { //use coor index at 0
	col = x;
	row = y;
    }
    public ArrayList<int[]> fillValidMoves() {
		validMoves = new ArrayList<int[]>();
        return validMoves;
    }
    public String toString() {
	return "K";
    }
}
