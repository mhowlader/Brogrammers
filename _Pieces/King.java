public class King extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public King(int x, int y) { //use coor index at 0
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
    public static edgeDetect() {
	
    }
    public String[] validMoves() {
	validMoves = new String[1000];







    //create converter from E3 to index starting from 0

