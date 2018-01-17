public class Test{
	   private static final String _letters = "ABCDEFGH";
		
	public static int convertLetter(String letter) {
		int output = 999;
		for(int i = 0; i < 8; i++) {
			if (letter.equals(_letters.substring(i, i + 1))){
				output = i;
			}
		}
		return output;
	}
	public static void main(String args[]){
		System.out.println(convertLetter("A"));
		System.out.println(convertLetter("B"));
		System.out.println(convertLetter("H"));
	}
}
	