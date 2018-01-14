public abstract class ChessPiece {
	public ChessPiece(char c) {
		if (c=='w') {
		color="white";
		}
		else {
			color="black";
		}
	}
	public String color;
	public abstract String toString();
  }
