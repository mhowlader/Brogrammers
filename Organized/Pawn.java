public class Pawn extends ChessPiece {
    int row,col;
    public Pawn(){
	row = 99;
	col = 99;	
	}
	
	public boolean canPawnTake(){ // bottom player
		if (enemy piece is in : (row + 1) * 10 + colPawn + 1) || (row + 1) * 10 + colPawn - 1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean canPawnTake(){ // top player
		if (enemy piece is in : (row - 1) * 10 + colPawn + 1) || (row - 1) * 10 + colPawn - 1){
			return true;
		}else{
			return false;
		}
	}
    public int[] validMoves(rowPawn, colPawn) {
		int[] possibleMoves = new int[50];
		if (rowPawn == 2 || rowPawn == 7){
			possibleMoves[1] = 4 * 10 + colPawn; // bottom side pawns can advance 2 up
			possibleMoves[2] = 5 * 10 + colPawn;  //top side pawns can advance 2 down
		}
		if (){ //pawn is bottom players, then
			possibleMoves[3] = (rowPawn + 1) * 10 + colPawn;
		}
		if (){ //pawn is top players, then
			possibleMoves[4] = (rowPawn - 1) * 10 + colPawn;
		}
		if (){ //other player's pawn is in a diagonal
			
		}
	}
}

    
