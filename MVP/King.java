import java.util.ArrayList;

public class King extends ChessPiece {
    //private static int row,col;
    public static ArrayList<int[]> validMoves;
    public King(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public ArrayList<int[]> fillValidMoves() {
		validMoves = new ArrayList<int[]>();
        return validMoves;
    }
    public String toString() {
	return "K";
    }
}
