import java.util.ArrayList;

public class Queen extends ChessPiece {
    //private static int row,col;
    public Queen(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public void fillValidMoves() {
        validMoves = new ArrayList<int[]>();

        ChessPiece QRook=new Rook(row,col,playerNum);
        QRook.fillValidMoves();
        for (int[] a: QRook.getValidMoves()) {
            validMoves.add(a);
        }
        ChessPiece QBishop=new Bishop(row,col,playerNum);
        QBishop.fillValidMoves();
        for (int[] a: QBishop.getValidMoves()) {
            validMoves.add(a);
        }


    }
    public String toString() {
        return "Q";
    }
}
