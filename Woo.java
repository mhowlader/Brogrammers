import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Woo {
    private boolean gameChosen;
	private static int gameSelection;
	// private InputStreamReader isr;
	// private BufferedReader in;
	private static String player1Name;
	private static String player2Name;


    private static boolean gameOver;
    private static int moveCount;
    private static final String _numbers = "12345678";
    private static final String _letters = "ABCDEFGH";
	private static InputStreamReader isr;
	private static BufferedReader in;
    private static ChessBoard cBoard;
    private static int currentPlayerNum=1;

    public Woo() {
		gameChosen = false;
		isr = new InputStreamReader(System.in);
		in = new BufferedReader(isr);
		player1Name = "default1";
		player2Name = "default2";
		newGame();
	}

    public void newGame() {
        String s;
        s = "Welcome! \n";

        s += "\nChoose your gamemode: \n";
        s += "\t1: Two Players\n";
        s += "\t2: Single Player\n";
        System.out.print(s);

        //This section was changed to handle people putting in weird values

        String badValue = "\n Enter a number between 1 and 2 \n \n";

        while (!gameChosen) {
            try {
                System.out.print("Selection: ");
                gameSelection = Integer.parseInt(in.readLine());
                if (gameSelection >= 1 && gameSelection <= 2) {
                    gameChosen = true;
                } else {
                    System.out.print(badValue);
                }
            } catch (IOException e) {
                System.out.print(badValue);
            } catch (NumberFormatException e) {
                System.out.print(badValue);
            }
        }
        //get names
        s = "player 1 name: ";
        System.out.print(s);

        try {
            player1Name = in.readLine();
        } catch (IOException e) {
        }

        s = "player 2 name: ";
        System.out.print(s);

        try {
            player2Name = in.readLine();
        } catch (IOException e) {
        }
    }

    public static String getPlayer1Name(){
        return player1Name;
    }

    public static String getPlayer2Name(){
        return player2Name;
    }


    public static void main(String[] args) {
        Woo ingame = new Woo();

		while (gameSelection == 1) { //run chess 2 players here
			System.out.println("now playing 2 player chess");
            PlayerTurn z=new PlayerTurn();

			while (!z.gameOver) {
			    System.out.println(z.cBoard);
			    z.play();
			}
			System.out.println("Game Over!");
			gameSelection = 0;
		  }

          while (gameSelection == 2) { //run chess single player here
			System.out.println("now playing against an AI");
            ComputerTurn j=new ComputerTurn();


			String endGameMessage = "Checkmate! Game over.";
			 while (!j.gameOver) {
					System.out.println(j.cBoard);
					 j.play();
					}
			 System.out.println(endGameMessage);
			 gameSelection = 0;
			}



}
}
