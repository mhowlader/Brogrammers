public class Knight extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public Knight(int x,int y) { //use coor index at 0
	col = x;
	row = y;
    }
    public String[] validMoves() {
	return null;
    }
    public String toString() {
	return "K";
    }
}
