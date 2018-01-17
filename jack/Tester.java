import java.util.ArrayList;
import java.util.Arrays;


public class Tester {
    public static void main (String[] args) {
        ArrayList<int[]> validMoves = new ArrayList<int[]>();
        validMoves.add(new int[]{3,2});
        for (int[] a: validMoves) {
            System.out.println(a[0]);
        }

        int[] b = new int[]{3,2};

        System.out.println(Arrays.equals(b,validMoves.get(0)));

        for (int[] c:validMoves) {
            if (c.equals(b)) {
                System.out.println("yaaas");
            }
        }
    }
}
