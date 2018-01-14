import java.util.ArrayList;

public class Knight extends ChessPiece {
    private static int row,col;
    public static ArrayList<int[]> validMoves;
    public Knight(int x,int y) { //use coor index at 0
        col = x;
        row = y;

    }
    public ArrayList fillValidMoves() {
        validMoves=new ArrayList<int[]>();

        //2d array of all moves
        int[][] tempCol= new int[][]{
            {row-2,row-1},
            {row-2,row+1},
            {row-1,row+2},
            {row-1,row-2},
            {row+1,row+2},
            {row+1,row-2},
            {row+2,row+1},
            {row+2,row-1}
        };

        //adds those 2d arrays to validMoves
        for (int[] b:tempCol) {
            validMoves.add(b);
        }


        //deletes invalid ones
        for (int[] a: validMoves) {
            if (!ChessBoard.squareExists(a[0],a[1])) {
                validMoves.remove(a);
            }
        }
        return validMoves;
    }

    public String toString() {
        return "K";
    }
}
