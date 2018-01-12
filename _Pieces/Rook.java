public class Rook extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public Rook(int x, int y) { //use coor index at 0
	row = x;
	col = y;
    }
     public static char convertInt(int x) {
	char c;
	int ctr;
	for(c = 'A'; c <= 'H'; c++) {
	    ctr = 0; //maybe error 
	    if (ctr == x) {
		return c;
	    }
	    ctr += 1;
	}
	return 'z'; //maybe error
    }
    public String[] validMoves() { //edit so it works at any pos of board instead of just corners
	validMoves = new String[1000]; //Change to a func that doubles if nec.
	char c;
	int ctr, x;
	for(ctr = 0; ctr <= 6; ctr ++) {
	    for(c = 'A'; c <= 'H'; c++) {
		validMoves[ctr] += "" + c + row;
	    }
	}
	for(ctr = 7; ctr <= 13; ctr ++) {
	    for(x = 0; x <= 7; x++) {
		validMoves[ctr] = "" + convertInt(col) + x;
	    }
	}
	return validMoves;
    }
}
