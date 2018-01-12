public class Pawn extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public Pawn(int x,int y) { //use coor index at 0
	col = x;
	row = y;
    }
    public static char convertInt(int x) {
	char c;
	int ctr = 0;
	for(c = 'A'; c <= 'H'; c++) {
	    if (ctr == x) {
		return c;
	    }
	    ctr += 1;
	}
	return 'z'; //maybe error
    }
    public String[] validMoves() {
	if ((row == 1) || (row == 6)) {
	    validMoves = new String[2];
	    validMoves[0] = "" + convertInt(col) + (row+2); //adds 1 makes up for index at 0 
	    validMoves[1] = "" + convertInt(col) + (row+3); //adds 1 makes up for index at 0 
	}
	else {
	    validMoves = new String[1]; 
	    validMoves[0] = "" + convertInt(col) + (row+2);
	}
	return validMoves;
    }
    // Test
    //public static void main(String[] args) {
    //	Pawn m1 = new Pawn(0,1); 
    //	m1.validMoves();
    //  System.out.println(java.util.Arrays.toString(validMoves));
    //}
}
