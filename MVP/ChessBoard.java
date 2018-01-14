public class ChessBoard {
    private final static int BOARD_SIZE = 8; //sets the size of the board
    public static ChessPiece[][] board; // creates a variable board
    public ChessBoard() {
	board = new ChessPiece[BOARD_SIZE][BOARD_SIZE]; //initializes variable board
    }
    public static ChessPiece[][] getBoard() {
	return board; //returns the board
    }
    private static void setPieceOnBoard(int row, int col, ChessPiece newPiece) { //allows you to place new pieces on the board 
	board[row][col] = newPiece;
    }
    public static void movePiece( int oldRow, int oldCol, int newRow, int newCol) { //allows you to move a piece
	board[newRow][newCol] = board[oldRow][oldCol]; // sets whatevers on the new position as what was at the old position
	board[oldRow][oldCol] = null;  //null converted to "" in toString()
    }
    public void setUp() {
	for (int c=0;c<8;c++) {
	    setPieceOnBoard(1,c,new Pawn(1,c)); //white pawns
	}
	for (int c=0;c<8;c++) {
	    setPieceOnBoard(6,c,new Pawn(1,c)); //black pawns
	}
	setPieceOnBoard(0,0,new Rook(0,0));
	setPieceOnBoard(0,1,new Knight(0,1));
	setPieceOnBoard(0,2,new Bishop(0,2));
	setPieceOnBoard(0,3,new Queen(0,3));
	setPieceOnBoard(0,4,new King(0,4));
	setPieceOnBoard(0,5,new Bishop(0,5));
	setPieceOnBoard(0,6,new Knight(0,6));
	setPieceOnBoard(0,7,new Rook(0,7));
	setPieceOnBoard(7,0,new Rook(7,0));
	setPieceOnBoard(7,1,new Knight(7,1));
	setPieceOnBoard(7,2,new Bishop(7,2));
	setPieceOnBoard(7,3,new Queen(7,3));
	setPieceOnBoard(7,4,new King(7,4));
	setPieceOnBoard(7,5,new Bishop(7,5));
	setPieceOnBoard(7,6,new Knight(7,6));
	setPieceOnBoard(7,7,new Rook(7,7));
    }
    public static boolean hasValidMoves() { //FINISH
	return true;
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
