public class Queen extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public Queen(int x,int y) { //use coor index at 0
	col = x;
	row = y;
    }
    public String[] validMoves() {
	return null;
    }
    public String toString() {
	return "Q";
    }
}
