public class ChessBoard {
    private static ChessPiece[][] board;
    public ChessBoard() {
	board = new ChessPiece[8][8];
    }
    public static ChessPiece[][] getBoard() {
	return board;
    }
    private void add(ChessPiece piece) {
	
    }
    public String toString() {
	String output = "";
	for( int i =0; i < 8; i++ ) {
	    output += "| ";
	    for( int j=0; j < 8; j++ ) {
		if (board[i][j] == null) {
		    output +="  ";
		}
		else {	
		    output += board[i][j] + " "; //get(i+1,j+1)
		}
	    }
	    output += "|\n";
	}
	return output;
    }
    public static void main(String[] args) {
    }
}