public class King extends ChessPiece {
    private static int row,col;
    public static String[] validMoves;
    public King(int x, int y) { //use coor index at 0
	row = x;
	col = y;
    }

    public void fillValidMoves() {
		validMoves = new String[8];
			validMoves[0] = row  //row is in the tens value, col is in the ones val
			validMoves[1] = 
			validMoves[2] = 
			validMoves[3] = 
			validMoves[4] = 
			validMoves[5] = 
			validMoves[6] = 
			validMoves[7] = 
		}

	public String[] getValidMoves(){
		return validMoves;
	}
}

