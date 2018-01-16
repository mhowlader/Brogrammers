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
        validMoves.addAll(QRook.getValidMoves());
        ChessPiece QBishop=new Bishop(row,col,playerNum);
        validMoves.addAll(QBishop.getValidMoves());


    }
    public String toString() {
        return "Q";
    }
}
