import java.util.ArrayList;

public class Bishop extends ChessPiece {
    //private static int row,col;
    public static ArrayList<int[]> validMoves;
    public Bishop(int x,int y, int player ) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }

    public ArrayList<int[]> fillValidMoves() {
        validMoves = new ArrayList<int[]>();

        //

        //generates coordinates of top right diagonal of Bishop
        for (int r=row-1;r<=0;r--) {
            for (int c=col+1;c<8;c++) {
                if (!ChessBoard.isPieceOnSquare(r,c)) { //if empty square
                    validMoves.add(new int[]{r,c});
                }
                else if (!sameColor(ChessBoard.getPiece(r,c))) {
                    validMoves.add(new int[]{r,c});
                    break;
                }
                else {
                    break;
                }

            }
        }

        for (int r=row-1;r<=0;r--) {
            for (int c=col-1;c<=0;c--) {

                if (!ChessBoard.isPieceOnSquare(r,c)) {
                    validMoves.add(new int[]{r,c});
                }
                else if (!sameColor(ChessBoard.getPiece(r,c))) {
                    validMoves.add(new int[]{r,c});
                    break;
                }
                else {
                    break;
                }
            }
        }

        for (int r=row+1;r<8;r++) {
            for (int c=col+1;c<8;c++) {

                if (!ChessBoard.isPieceOnSquare(r,c)) {
                    validMoves.add(new int[]{r,c});
                }
                else if (!sameColor(ChessBoard.getPiece(r,c))) {
                    validMoves.add(new int[]{r,c});
                    break;
                }
                else {
                    break;
                }
            }
        }

        for (int r=row+1;r<8;r++) {
            for (int c=col-1;c>=0;c--) {

                if (!ChessBoard.isPieceOnSquare(r,c)) {
                    validMoves.add(new int[]{r,c});
                }
                else if (!sameColor(ChessBoard.getPiece(r,c))) {
                    validMoves.add(new int[]{r,c});
                    break;
                }
                else {
                    break;
                }
            }
        }

        return validMoves;
    }

    public String toString() {
        return "B";
    }
}
