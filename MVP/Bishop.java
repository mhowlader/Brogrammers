public class Bishop extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public Bishop(int x,int y) { //use coor index at 0
	col = x;
	row = y;
    }
    public String[] fillValidMoves() {
		validMoves = new String[70];
		for (int i = 1; i < 9; i++){
			validMoves[(row + i)* 10 +(col + i)]; //row is in the tens value, col is in the ones val
			validMoves[(row + i)* 10 +(col - i)];
			validMoves[(row - i)* 10 +(col + i)];
			validMoves[(row - i)* 10 +(col - i)];
		}
    }
    public String toString() {
	return "B";
    }
}
