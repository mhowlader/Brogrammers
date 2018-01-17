import java.util.ArrayList;
import java.util.Arrays;

public class King extends ChessPiece {
    //private static int row,col;
    public static ArrayList<int[]> temp;
    public King(int x,int y, int player) { //use coor index at 0
        super(x,y,player);
        fillValidMoves();
    }
    public void fillValidMoves() {
	validMoves = new ArrayList<int[]>();
        int[][] tempCol= new int[][]{
            {row+1,col},
            {row+1,col+1},
            {row+1,col-1},
            {row,col-1},
            {row,col+1},
            {row-1,col-1},
            {row-1,col},
            {row-1,col+1}
        };

        for (int[] b:tempCol) {
            int r=b[0]; //row of tempCol
            int c=b[1]; //column of tempCol
            if (ChessBoard.squareExists(r,c)) { //checks if the square is on the chessboard
		if (!ChessBoard.isPieceOnSquare(r,c) || !sameColor(ChessBoard.getPiece(r,c)) ) { //it's either an empty square or a square with an enemy piece
		    validMoves.add(b); //add itto validmoves if so
		}
            }
        }
    }

    public static ArrayList<int[]> getValidMoves() {
        return validMoves;
      }

    public static boolean isCheck() {
	 String color = getColor();
	 int[] coord = new int[]{row,col};
	 if (color.equals("Black")) {
	     for(int[] a: ChessBoard.getWhiteValidMoves()) {
		 if (Arrays.equals(coord,a)) {
       System.out.println("YOU ARE IN CHECK!");
		     return true;
		 }
	     }
	 }
	 if (color.equals("White")) {
	    for(int[] a: ChessBoard.getBlackValidMoves()) {
		if (Arrays.equals(coord,a)) {
      System.out.println("YOU ARE IN CHECK!");
		    return true;
		}
	    }
	 }
	 return false;
     }

    public static boolean isCheckMate() {
	     String color = getColor();
	      int[] coord = new int[]{row,col};
	       if (color.equals("Black") & isCheck()) {
	          for(int[] a: ChessBoard.getWhiteValidMoves()) {
		            for(int[] b: getValidMoves()) {
		                if (!Arrays.equals(b,a)) {
			                   return false;
		                }
		            }
           }
	      }
	else if (color.equals("White") & isCheck()) {
	    for(int[] a: ChessBoard.getBlackValidMoves()) {
		for(int[] b: getValidMoves()) {
		    if (!Arrays.equals(b,a)) {
			return false;
		    }
		}
	    }
	}

	return true;
    }
     public void restrictionsValidMoves() {
	String color = getColor();
	int[] coord = new int[]{row,col};
	int ctr = 0;
        temp = new ArrayList<int[]>(validMoves);
        validMoves.clear();
	if (color.equals("Black") & isCheck()) {
	    for(int[] a: ChessBoard.getWhiteValidMoves()) {
		for(int[] b: temp) {
		    if (!Arrays.equals(b,a)) {
		        validMoves.add(ctr,b);
		    }
		}
	    }
	}
	else if (color.equals("White") & isCheck()) {
	    for(int[] a: ChessBoard.getBlackValidMoves()) {
		for(int[] b: temp) {
		    if (!Arrays.equals(b,a)) {
			validMoves.add(ctr,b);
		    }
		}
	    }
	}
     }
    public String toString() {
	return "K";
    }
}
