import java.util.ArrayList;

public abstract class ChessPiece {
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
    public abstract ArrayList<int[]> fillValidMoves();

}
