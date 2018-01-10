public class Pawn extends ChessPiece {
    int row,col;
    public Pawn(int x,int y) {
	col = x;
	row = y;
    }
    public boolean validMoves() {
	if (row != (row +1)) {
	    throw new IllegalArgumentException("Invalid move");
	}
	else {
	    return true; 
	}
    }
}
    
