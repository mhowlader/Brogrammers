public class Bishop extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public Bishop(int x,int y) { //use coor index at 0
	col = x;
	row = y;
    }
    public String[] validMoves() {
	return null;
    }
    public String toString() {
	return "B";
    }
}
