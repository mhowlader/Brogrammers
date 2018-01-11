public class Board {
    private static String[][] board;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_BLUE = "\u001B[34m";
	
    public Board() {
	board = new String[9][9];
    }
    
	private String set( int r, int c, String newVal )
    {
	String retVal = board[r][c];
	board[r][c] = newVal;
	return retVal;
    }
   
    public String toString()
    {
	String foo = "";
	for( int i = 0; i < 9; i++ ) {
	    foo += "| ";
	    for( int j= 0; j < 9; j++ ) {
		foo += board[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}
	return foo;
    }
	
	
    public static void main( String[] Args) {
	Board m1 = new Board();
	for(int x = 0; x != 8; x++) {
	    for(int y = 0; y != 8; y++) {
		m1.set(x,y," ");
	    }
	}
	m1.set(0,0,"R");
	m1.set(0,1,"H");
	m1.set(0,2,"B");
	m1.set(0,3,"Q");
	m1.set(0,4,"K");
	m1.set(0,5,"B");
	m1.set(0,6,"H");
	m1.set(0,7,"R");
	m1.set(1,0,"P");
	m1.set(1,1,"P");
	m1.set(1,2,"P");
	m1.set(1,3,"P");
	m1.set(1,4,"P");
	m1.set(1,5,"P");
	m1.set(1,6,"P");
	m1.set(1,7,"P");
	m1.set(7,0,"R");
	m1.set(7,1,"H");
	m1.set(7,2,"B");
	m1.set(7,3,"Q");
	m1.set(7,4,"K");
	m1.set(7,5,"B");
	m1.set(7,6,"H");
	m1.set(7,7,"R");
	m1.set(6,0,"P");
	m1.set(6,1,"P");
	m1.set(6,2,"P");
	m1.set(6,3,"P");
	m1.set(6,4,"P");
	m1.set(6,5,"P");
	m1.set(6,6,"P");
	m1.set(6,7,"P");
	//set labels
	m1.set(8,0,ANSI_BLUE + "A" + ANSI_RESET);
	m1.set(8,1,ANSI_BLUE + "B" + ANSI_RESET);
	m1.set(8,2,ANSI_BLUE + "C" + ANSI_RESET);
	m1.set(8,3,ANSI_BLUE + "D" + ANSI_RESET);
	m1.set(8,4,ANSI_BLUE + "E" + ANSI_RESET);
	m1.set(8,5,ANSI_BLUE + "F" + ANSI_RESET);
	m1.set(8,6,ANSI_BLUE + "G" + ANSI_RESET);
	m1.set(8,7,ANSI_BLUE + "H" + ANSI_RESET);
	m1.set(8,8,ANSI_BLUE + " " + ANSI_RESET);
	
	
	m1.set(0,8,ANSI_BLUE + "1" + ANSI_RESET);
	m1.set(1,8,ANSI_BLUE + "2" + ANSI_RESET);
	m1.set(2,8,ANSI_BLUE + "3" + ANSI_RESET);
	m1.set(3,8,ANSI_BLUE + "4" + ANSI_RESET);
	m1.set(4,8,ANSI_BLUE + "5" + ANSI_RESET);
	m1.set(5,8,ANSI_BLUE + "6" + ANSI_RESET);
	m1.set(6,8,ANSI_BLUE + "7" + ANSI_RESET);
	m1.set(7,8,ANSI_BLUE + "8" + ANSI_RESET);
	
	
	System.out.println(m1);
    }
}
