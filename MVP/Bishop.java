import java.util.ArrayList;

public class Bishop extends ChessPiece {
    private static int row,col;
    public static ArrayList<int[]> validMoves;
    public Bishop(int x,int y) { //use coor index at 0
	col = x;
	row = y;
    }

    public ArrayList<int[]> fillValidMoves() {
		validMoves = new ArrayList<int[]>();
        return validMoves;


        /*
		for (int i = 0; i < 8; i++){
			validMoves[(i * 4)] = ((row + i + 1)* 10 + (col + i + 1)); //row is in the tens value, col is in the ones val
			validMoves[(i * 4) + 1] = ((row + i + 1)* 10 + (col - i - 1));
			validMoves[(i * 4) + 2] = ((row - i - 1) * 10 + (col + i + 1));
			validMoves[(i * 4) + 3] = ((row - i - 1)* 10 + (col - i - 1));
		}
        */
    }

    public String toString() {
	return "B";
    }
}
