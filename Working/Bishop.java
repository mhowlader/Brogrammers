import java.util.ArrayList;

public class Bishop extends ChessPiece {
    //private static int row,col;
    public Bishop(int x,int y, int player ) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }

    public void fillValidMoves() {
        validMoves = new ArrayList<int[]>();

        //negative row direction, positive column direction
        for (int r=row-1, c=col+1; r>=0 && c<8;r--, c++) {
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


        //negative row direction, neative column direction
        for (int r=row-1, c=col-1;r>=0 && c>=0;r--, c--) {

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

        //positive row direction, positive column direction
        for (int r=row+1, c=col+1;r<8 && c<8;r++, c++) {
            if (!ChessBoard.isPieceOnSquare(r,c)) { // if empty square
                validMoves.add(new int[]{r,c});
            }
            else if (sameColor(ChessBoard.getPiece(r,c)) == false) {
                validMoves.add(new int[]{r,c});
                break;
            }
            else {
                break;
            }
        }


        //positive row direction, negativve column direction
        for (int r=row+1, c=col-1;r<8 && c>=0;r++, c--) {

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


    public String toString() {
        return "B";
    }
}
