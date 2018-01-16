import java.util.ArrayList;

public abstract class ChessPiece {
    public static ArrayList<int[]> validMoves;
    public static int row, col, playerNum;
    public static String color;
    public ChessPiece(int x,int y, int player) {
        row=x;
        col=y;
        playerNum=player;
        if (playerNum==1) {
            color="White";
        }
        else {
            color="Black";

        }
    }
    public static String getColor() {
        return color;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public static ArrayList<int[]> getValidMoves() {
        return validMoves;
      }

<<<<<<< HEAD
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    
=======
>>>>>>> 647678e28c11bf3e39aacf83dce91f002b4bc646
    public boolean sameColor(ChessPiece a) {
        return this.getColor().equals(a.getColor()); //check if same color
    }
    public abstract void fillValidMoves();

}
