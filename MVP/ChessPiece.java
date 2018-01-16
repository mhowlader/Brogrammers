import java.util.ArrayList;

public abstract class ChessPiece {
    public ArrayList<int[]> validMoves;
    public int row, col, playerNum;
    public String color;
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
    public String getColor() {
        return color;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public ArrayList<int[]> getValidMoves() {
        return validMoves;
      }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    
    public boolean sameColor(ChessPiece a) {
        return this.getColor().equals(a.getColor()); //check if same color
    }
    public abstract void fillValidMoves();

}
