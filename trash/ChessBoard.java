public class ChessBoard {
	private final static int BOARD_SIZE=8;
	
    private static ChessPiece[][] board;
    public ChessBoard() {
		board = new ChessPiece[8][8];
	}
    private ChessPiece setPieceOnBoard( int row, int col, ChessPiece newPiece ) {
		ChessPiece retVal = board[row][col];
		board[row][col] = newPiece;
		return retVal;
	}
    public String toString() {
		String foo = "";
		for( int i =0; i < 8; i++ ) {
			foo += "| ";
			for( int j=0; j < 8; j++ ) {
				if (board[i][j]==null) {
					foo+="  ";
				}
				else {	
					foo += board[i][j] + " "; //get(i+1,j+1)
				}
			}
			foo += "|\n";
		}
		return foo;
	}
	
	public void setPawns() {
		for (int c=0;c<8;c++) {
			setPieceOnBoard(1,c,new Pawn('w')); //white pawns
		}
		for (int c=0;c<8;c++) {
			setPieceOnBoard(6,c,new Pawn('b')); //black pawns
		}
	}
	
	public void setOtherPieces() {
		setPieceOnBoard(0,0,new Rook('w'));
		setPieceOnBoard(0,1,new Horse('w'));
		setPieceOnBoard(0,2,new Bishop('w'));
		setPieceOnBoard(0,3,new Queen('w'));
		setPieceOnBoard(0,4,new King('w'));
		setPieceOnBoard(0,5,new Bishop('w'));
		setPieceOnBoard(0,6,new Horse('w'));
		setPieceOnBoard(0,7,new Rook('w'));
		setPieceOnBoard(7,0,new Rook('b'));
		setPieceOnBoard(7,1,new Horse('b'));
		setPieceOnBoard(7,2,new Bishop('b'));
		setPieceOnBoard(7,3,new Queen('b'));
		setPieceOnBoard(7,4,new King('b'));
		setPieceOnBoard(7,5,new Bishop('b'));
		setPieceOnBoard(7,6,new Horse('b'));
		setPieceOnBoard(7,7,new Rook('b'));
	
	}		
    public static void main( String[] Args) {
		ChessBoard m1 = new ChessBoard();
		
		m1.setPawns();
		m1.setOtherPieces();
	
		System.out.println(m1);
    }
}
