import java.util.ArrayList;
import java.util.Arrays;
public class ChessBoard {
    private final static int BOARD_SIZE = 8; //sets the size of the board
    public static ChessPiece[][] board; // creates a variable board
    public static ArrayList<int[]> blackValidMoves;
    public static ArrayList<int[]> whiteValidMoves;
    public ChessBoard() {
        board = new ChessPiece[BOARD_SIZE][BOARD_SIZE]; //initializes variable board
    }
    public static ChessPiece[][] getBoard() {
        return board; //returns the board
    }
    public static void setPieceOnBoard(int row, int col, ChessPiece newPiece) { //allows you to place new pieces on the board
        board[row][col] = newPiece;
    }

    public static boolean checkIfLegal( int oldRow, int oldCol, int newRow, int newCol) {
        ChessPiece piece=board[oldRow][oldCol];
        int[] coord = new int[]{newRow,newCol};
        for (int[] a:piece.getValidMoves()) {
            if (Arrays.equals(a,coord)) {
                return true;
            }
        }
        return false;
    }
    public static void movePiece( int oldRow, int oldCol, int newRow, int newCol) { //allows you to move a piece

        board[newRow][newCol] = board[oldRow][oldCol]; // sets whatevers on the new position as what was at the old position
        board[oldRow][oldCol] = null; //null converted to "" in toString()

    }
    public void setUp() {
        for (int c=0;c<8;c++) {
            setPieceOnBoard(1,c,new Pawn(1,c,1)); //white pawns
        }
        for (int c=0;c<8;c++) {
            setPieceOnBoard(6,c,new Pawn(6,c,2)); //black pawns
        }

        //White pieces
        setPieceOnBoard(0,0,new Rook(0,0,1));
        setPieceOnBoard(0,1,new Knight(0,1,1));
        setPieceOnBoard(0,2,new Bishop(0,2,1));
        setPieceOnBoard(0,3,new Queen(0,3,1));
        setPieceOnBoard(0,4,new King(0,4,1));
        setPieceOnBoard(0,5,new Bishop(0,5,1));
        setPieceOnBoard(0,6,new Knight(0,6,1));
        setPieceOnBoard(0,7,new Rook(0,7,1));
        //black pieces
        setPieceOnBoard(7,0,new Rook(7,0,2));
        setPieceOnBoard(7,1,new Knight(7,1,2));
        setPieceOnBoard(7,2,new Bishop(7,2,2));
        setPieceOnBoard(7,3,new Queen(7,3,2));
        setPieceOnBoard(7,4,new King(7,4,2));
        setPieceOnBoard(7,5,new Bishop(7,5,2));
        setPieceOnBoard(7,6,new Knight(7,6,2));
        setPieceOnBoard(7,7,new Rook(7,7,2));
    }
    public static boolean isPieceOnSquare(int x, int y) {
        if (board[x][y] instanceof ChessPiece) {
            return true;
        }
        return false;
    }

    //checks if the square exists
    public static boolean squareExists(int x, int y) {
        if (x>=0 && x<=7 && y>=0 && y<=7) {
            return true;
        }
        return false;
    }

    public static ChessPiece getPiece(int r, int c) {
        return board[r][c];
    }

    public static String colorOfSquare(int r, int c) {
        return board[r][c].getColor();
    }
    public static void blackValidMoves() {
        ChessPiece piece;
	blackValidMoves = new ArrayList<int[]>();
	for (int x = 0; x < 8; x++) {
	    for (int y = 0; y < 8; y++) {
		piece = board[x][y];
		if (piece.getColor() == "Black") {
		    for(int[] coord: piece.getValidMoves()) {
			blackValidMoves.add(coord);
		    }
		}
	    }
	}
    }

    public static ArrayList<int[]> getBlackValidMoves() {
	return blackValidMoves;
    }
    public static void whiteValidMoves() {
        ChessPiece piece;
	whiteValidMoves = new ArrayList<int[]>();
	for (int x = 0; x < 8; x++) {
	    for (int y = 0; y < 8; y++) {
		piece = board[x][y];
		if (piece.getColor() == "White") {
		    for(int[] coord: piece.getValidMoves()) {
			whiteValidMoves.add(coord);
		    }
		}
	    }
	}
    }

    public static ArrayList<int[]> getWhiteValidMoves() {
	return whiteValidMoves;
    }

    public String toString() {
	String output = "";
	String letters="abcdefgh";
	output+="\n   ";

	for (int i=0;i<8;i++) {
	    output+= "- ";
	}
	output+="\n";
	for( int i =0; i < 8; i++ ) {
	    output += (i+1) + "| ";
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
	output+="   ";
	for (int i=0;i<8;i++) {
	    output+= "- ";
	}
	output+="\n   ";

	for (int i=0;i<8;i++) {
	    output+= letters.substring (i,i+1) + " ";
	}
	return output;
    }

    public static void main (String[] args) {
	ChessBoard c = new ChessBoard();
	c.setUp();
	for (int[] a: c.getPiece(6,1).getValidMoves()) {
	    System.out.println(Arrays.toString(a));
	}
    }
}
