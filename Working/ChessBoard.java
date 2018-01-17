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

    // public ChessBoard (ChessBoard aBoard) {
    //     this.board=
    // }
    public static ChessPiece[][] getBoard() {
        return board; //returns the board
    }
    public static void setPieceOnBoard(int row, int col, ChessPiece newPiece) { //allows you to place new pieces on the board
        board[row][col] = newPiece;
        newPiece.row=row;
        newPiece.col=col;
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
        getPiece(newRow,newCol).row=newRow;
        getPiece(newRow,newCol).col=newCol;

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

        refreshValidMoves();
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

    public static boolean check(int row, int col) {
        ChessPiece piece = board[row][col];
        String color = piece.getColor();
        int[] coord = new int[]{row,col};
        if (color.equals("black")) {
            for(int[] a: getWhiteValidMoves()) {
                if (Arrays.equals(coord,a)) {
                    return true;
                }
            }
        }
        else if (color.equals("white")) {
            for(int[] a: getBlackValidMoves()) {
                if (Arrays.equals(coord,a)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean checkMate(int row, int col) {
        ChessPiece piece = board[row][col];
        String color = piece.getColor();
        int[] coord = new int[]{row,col};
        if (color.equals("black") & check(row,col)) {
            for(int[] a: getWhiteValidMoves()) {
                for(int[] b: piece.getValidMoves()) {
                    if (!Arrays.equals(b,a)) {
                        return false;
                    }
                }
            }
        }
        else if (color.equals("white")) {
            for(int[] a: getBlackValidMoves()) {
                for(int[] b: piece.getValidMoves()) {
                    if (!Arrays.equals(b,a)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void blackValidMoves() {
        ChessPiece piece;
        blackValidMoves = new ArrayList<int[]>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (isPieceOnSquare(x,y)) {
                    piece = board[x][y];
                    if (piece.getColor().equals("Black")) {
                        for(int[] coord: piece.getValidMoves()) {
                            blackValidMoves.add(coord);
                        }
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
                if (isPieceOnSquare(x,y)) {
                    piece = board[x][y];
                    if (piece.getColor().equals("White")) {
                        for(int[] coord: piece.getValidMoves()) {
                            whiteValidMoves.add(coord);
                        }
                    }
                }
            }
        }
    }

    //refreshes valid moves
    public static void refreshValidMoves() {
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (isPieceOnSquare(i,j)) { //checks if there is a piece on the square
                    getPiece(i,j).fillValidMoves();
                }
            }
        }

    }

    public static ArrayList<int[]> getWhiteValidMoves() {
        return whiteValidMoves;
    }

    // public static boolean moveCausesMyKingCheck(int oldR,int oldC,int newR,int newC, int player, ChessBoard tBoard) {
    //     int[] kingCoord;
    //     ChessBoard TestBoard = tBoard;
    //     TestBoard.movePiece(oldR,oldC,newR,newC);
    //     TestBoard.refreshValidMoves();
    //
    //
    //     for (int i=0;i<8;i++) {
    //         for (int j=0;j<8;j++) {
    //             if (TestBoard.isPieceOnSquare(i,j) ) { //checks if there is a piece on the square
    //                 ChessPiece p = TestBoard.getPiece(i,j);
    //                 if ( (p instanceof King) && (p.getPlayerNum() == player) ) {
    //                     kingCoord= new int[]{p.row,p.col}; //saves kings coordinates
    //
    //                     if (player==1) {
    //                         TestBoard.blackValidMoves();
    //                         for (int[] a:TestBoard.getBlackValidMoves()) {
    //                             if (Arrays.equals(a,kingCoord)) {
    //                                 return true;
    //                             }
    //                         }
    //                         return false;
    //                     }
    //                     else { //for black king
    //                         TestBoard.whiteValidMoves();
    //                         for (int[] a:TestBoard.getWhiteValidMoAves()) {
    //                             if (Arrays.equals(a,kingCoord)) {
    //                                 return true;
    //                             }
    //                         }
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    //
    // }

    //checks if the specified player's king is in check
    public static boolean isMyKingInCheck(int player) {
        int[] kingCoord;

        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (isPieceOnSquare(i,j) ) { //checks if there is a piece on the square
                    ChessPiece p = getPiece(i,j);
                    if ( (p instanceof King) && (p.getPlayerNum() == player) ) {
                        kingCoord= new int[]{p.row,p.col}; //saves kings coordinates

                        if (player==1) {
                            blackValidMoves();
                            for (int[] a:getBlackValidMoves()) {
                                if (Arrays.equals(a,kingCoord)) {
                                    return true;
                                }
                            }
                            return false;
                        }
                        else { //for black king
                            whiteValidMoves();
                            for (int[] a:getWhiteValidMoves()) {
                                if (Arrays.equals(a,kingCoord)) {
                                    return true;
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    //for all pieces of that player, it does every possible legal move and checks if it is still in check afterwards
    //if something makes it not check anymore, that means that it is not checkmate yet
    public static boolean isCheckMate(int player) {

        boolean isPieceAtNew = false;
        ChessPiece pieceAtNew=null;

        for (int r=0;r<8;r++) {
            for (int c=0;c<8;c++) {
                if (isPieceOnSquare(r,c) ) {
                    if (getPiece(r,c).getPlayerNum()==player) {
                        for (int[] a:getPiece(r,c).getValidMoves()) {
                            if (isPieceOnSquare(a[0],a[1])) { //if piece on the square
                                pieceAtNew=getPiece(a[0],a[1]);
                                isPieceAtNew=true;
                            }
                            movePiece(r,c,a[0],a[1]);
                            refreshValidMoves();
                            if (!isMyKingInCheck(player) ) { //if a move makes the king not in check
                                movePiece(a[0],a[1],r,c);
                                if (isPieceAtNew) {
                                    setPieceOnBoard(a[0],a[1],pieceAtNew);
                                }
                                refreshValidMoves();
                                return false;
                            }
                            else {
                                movePiece(a[0],a[1],r,c);
                                if (isPieceAtNew) {
                                    setPieceOnBoard(a[0],a[1],pieceAtNew);
                                }
                                refreshValidMoves();
                            }
                        }
                    }
                }
            }
        }

        return true;
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

    // testing ChessBoard sets up properly
    // public static void main (String[] args) {
    //     ChessBoard c=new ChessBoard();
    //     c.setUp();
    //
    //     // for (int i=0;i<8;i++) {
    //     //     for (int j=0;j<8;j++) {
    //     //         if (isPieceOnSquare(i,j)) { //checks if there is a piece on the square
    //     //             System.out.println(getPiece(i,j) + " " + getPiece(i,j).getColor() );
    //     //             for (int[] a : getPiece(i,j).getValidMoves()) {
    //     //                 System.out.println(Arrays.toString(a));
    //     //             }
    //     //         }
    //     //     }
    //     // }
    //
    //     System.out.println("End");
    //
    //     movePiece(1,1,2,1);
    //
    //     refreshValidMoves();
    //     for (int[] a : getPiece(0,2).getValidMoves()) {
    //         System.out.println(Arrays.toString(a));
    //     }
    //
    //     System.out.println("End");
    //
    //     // for (int i=0;i<8;i++) {
    //     //     for (int j=0;j<8;j++) {
    //     //         if (isPieceOnSquare(i,j)) { //checks if there is a piece on the square
    //     //             System.out.println(getPiece(i,j) + " " + getPiece(i,j).getColor() );
    //     //             for (int[] a : getPiece(i,j).getValidMoves()) {
    //     //                 System.out.println(Arrays.toString(a));
    //     //             }
    //     //         }
    //     //     }
    //     // }
    //
    //     System.out.println("End");
    //
    //
    //     movePiece(0,2,2,0);
    //     refreshValidMoves();
    //     for (int[] a : getPiece(2,0).getValidMoves()) {
    //         System.out.println(Arrays.toString(a));
    //     }
    //
    //     System.out.println(getPiece(2,0).row);
    //
    //     // for (int i=0;i<8;i++) {
    //     //     for (int j=0;j<8;j++) {
    //     //         if (isPieceOnSquare(i,j)) { //checks if there is a piece on the square
    //     //             System.out.println(getPiece(i,j) + " " + getPiece(i,j).getColor() );
    //     //             for (int[] a : getPiece(i,j).getValidMoves()) {
    //     //                 System.out.println(Arrays.toString(a));
    //     //             }
    //     //         }
    //     //     }
    //     // }
    // }




}
