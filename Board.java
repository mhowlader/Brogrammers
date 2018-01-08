public class Board {
    private static String[][] board;
    public Board() {
	board = new String[8][8];
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
	for( int i =0; i < 8; i++ ) {
	    foo += "| ";
	    for( int j=0; j < 8; j++ ) {
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
	System.out.println(m1);
    }
}
