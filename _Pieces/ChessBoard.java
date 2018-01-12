public class ChessBoard {
    private final static int BOARD_SIZE = 8; //sets size of the board 
    private static ChessPiece[][] board; //creates a variable board 
    public ChessBoard() {
	board = new ChessPiece[BOARD_SIZE][BOARD_SIZE]; //initalizes varaible board 
    }
    public static ChessPiece[][] getBoard() { //returns the board  
	return board; 
    }
    private static void setPieceOnBoard( int row, int col, ChessPiece newPiece ) { //allows you to place new pieces on the board 
	board[row][col] = newPiece;
    }
    public static void movePiece( int oldRow, int oldCol, int newRow, int newCol) { //allows you to move a piece 
	board[newRow][newCol] = board[oldRow][oldCol];
    }
    private void setUp() { //FINISH
	for(int 
    }
    public static hasValidMoves() { //FINISH
	
    }
    public static boolean checkMate() {
	if (hasValidMoves()) { // CREATE HAS VALID MOVES FOR KING
	    return true;
	}
	else {
	    return false;
	}
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
}
