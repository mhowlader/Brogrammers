import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Computer{
  private static ArrayList<ChessPiece> piecesAI;
  private static ArrayList<int[]> validMovesAI;
private static ChessBoard cBoard;

  public static ArrayList<ChessPiece> findAIPieces(int player){ //creates an arraylist of pieces available
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
        try {
          if (ChessBoard.colorOfSquare(i, j).equals(color)){ //checks if the piece belongs to the CPU
          piecesAI.add(ChessBoard.getPiece(i,j)); //if it belongs, add the piece to list
        }
      } catch (NullPointerException e){

      }
      }
    }
    return piecesAI;
  }

  public static int findAIPieceCount(int player){
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
        try {
          if (ChessBoard.colorOfSquare(i, j).equals(color)){ //checks if the piece belongs to the CPU
          pieceCount += 1; //if it belongs, add the piece to list
        }
      } catch (NullPointerException e){

      }
      }
    }
    return pieceCount;
  }

  public static void moveRandomPiece(){

    //validMovesAI = new ArrayList<int[]>();
    //validMovesAI.addall(ChessBoard.getBlackValidMoves); //Computer will be black
    //arraySize = validMovesAI.size(); //finds size of the arraylist
    Random random = new Random();
    int randomNumPieces = random.nextInt(findAIPieceCount(2)); //generates random number that is limited by the max number of black pieces
    int oldX, oldY, newX, newY;

    ChessPiece piece = findAIPieces(2).get(randomNumPieces);

    oldX = piece.getRow();
    oldY = piece.getCol();

    newX = 999;
    newY = 999;
    int randomNumMoves = random.nextInt(findAIPieces(2).size()); //generates random number that is limited by the max number of validmoves
    boolean hasMoves = false;

    while (!hasMoves){

      for (int[] a: piece.validMoves){
        if (Arrays.toString(a).length() == 0){
          piece = findAIPieces(2).get(randomNumPieces);
        } else {
          newX = a[0];
          newY = a[1];
          hasMoves = true;
        }
      }
    }

    //System.out.println(piece);
    //newX = piece.getValidMoves().get(randomNumMoves);
    //newY = piece.getValidMoves().get(randomNumMoves);

    //System.out.println(newX);
    //System.out.println(newY);
    ChessBoard.movePiece(oldX, oldY, newX, newY);

  }

  public static void main (String args[]){ //testing methods
    cBoard = new ChessBoard();
    cBoard.setUp();
      System.out.println(findAIPieces(2).size());
        System.out.println(findAIPieceCount(2));
        moveRandomPiece();
  }
}
