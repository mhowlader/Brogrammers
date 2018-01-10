import java.io.*; 
import java.util.*; 

public class playGame {
	private boolean gameChosen;
	private static int gameSelection;
	private InputStreamReader isr;
	private BufferedReader in;
	private String player1Name;
	private String player2Name;
	
	public playGame() { 
		gameChosen = false;
		isr = new InputStreamReader(System.in);
		in = new BufferedReader(isr);
		player1Name = "default";
		player2Name = "default";
		newGame(); 
	}

	public void newGame() { 
		String s;
		s = "Welcome! \n";
 
		s += "\nChoose your game: \n";
		s += "\t1: Chess\n";
		s += "\t2: Checkers\n";
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

 
		
	}//end newGame() 
	
	//
	public String getPlayer1Name(){
		return player1Name;
	}

	public String getPlayer2Name(){
		return player2Name;
	}	
	
	public static void main(String[] args) {
		//to end game, make game = 0
		playGame ingame = new playGame();
		
		while (gameSelection == 1) { //run chess
			System.out.println("running test chess");
			System.out.println(Board.getBoard());
 			break;
		} 
		
		while (gameSelection == 2) { //run checkers
			System.out.println("running test checkers");
			break;
		}
 
		System.out.println("Thy game doth be over.");
	}//end main 
}
