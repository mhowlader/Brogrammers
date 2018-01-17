import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Computer{
  private static ArrayList<ChessPiece> piecesAI;
  private static ArrayList<int[]> validMovesAI;


  public ArrayList<ChessPiece> findAIPieces(int player){ //creates an arraylist of pieces available
    String color = "NO COLOR";
    piecesAI = new ArrayList<ChessPiece>();

    if (player == 1){ //input 1 = white
      color = "White";
    }
    if (player == 2){ //input 2 = black
      color = "Black";
    } else {
      System.out.println("INVALID PLAYER INPUT"); //else = invalid
    }

    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        if (ChessBoard.colorOfSquare(i, j).equals(color)){ //checks if the piece belongs to the CPU
          piecesAI.add(ChessBoard.getPiece(i,j)); //if it belongs, add the piece to list
        }
      }
    }
    return piecesAI;
  }

  public int findAIPieceCount(int player){
    String color = "NO COLOR";
    int pieceCount = 0;

    if (player == 1){ //input 1 = white
      color = "White";
    }
    if (player == 2){ //input 2 = black
      color = "Black";
    } else {
      System.out.println("INVALID PLAYER INPUT"); //else = invalid
    }

    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        if (ChessBoard.colorOfSquare(i, j).equals(color)){ //checks if the piece belongs to the CPU
          pieceCount += 1; //if it belongs, add the piece to list
        }
      }
    }
    return pieceCount;
  }

  public void moveRandomPiece(){

    validMovesAI = new ArrayList<int[]>();
    //validMovesAI.addall(ChessBoard.getBlackValidMoves); //Computer will be black
    //arraySize = validMovesAI.size(); //finds size of the arraylist
    Random random = new Random();
    int randomNumPieces = random.nextInt(findAIPieceCount(2)) + 1; //generates random number that is limited by the max number of black pieces
    int oldX, oldY, newX, newY;

    ChessPiece piece = findAIPieces(2).get(randomNumPieces);

    oldX = piece.getRow();
    oldY = piece.getCol();

    int randomNumMoves = random.nextInt(validMovesAI.size()) + 1; //generates random number that is limited by the max number of validmoves

    newX = piece.getValidMoves().get(randomNumMoves)[0];
    newY = piece.getValidMoves().get(randomNumMoves)[1];

    ChessBoard.movePiece(oldX, oldY, newX, newY);

  }

  public static void main (String args[]){ //testing methods

  }
}
