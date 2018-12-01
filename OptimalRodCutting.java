import java.util.ArrayList;
import java.util.List;

public class OptimalRodCutting {
	static int[] pieces = { 1, 5, -8, 9, 10, 17, 20, 3, 3};
	static int[] pieces2 = { 10, -10, 50, -1, 3};
	//static List<Integer> cutLengths = new ArrayList<Integer>();

	/*
	 * Much like recursive fibonacci this recursive method goes down the list of
	 * possible sub-cuts and picks out the maximums and as we build back up, we
	 * get the highest possible integer.
	 */
	public static int RodCutMax(int[] TheRod, int arrayLength) {// no constraints
		if (arrayLength == 0)
			return 0;
		int maxCombos = Integer.MIN_VALUE;
		for (int i = 0; i < arrayLength; i++) {
			maxCombos = Math.max(maxCombos,
					TheRod[i] + RodCutMax(TheRod, arrayLength - i - 1));
		}
		return maxCombos;
	}

	public static int RodCutMin(int[] TheRod, int arrayLength, int costPerCut){// with constraints, BROKEN!!
		if (arrayLength == 0)
			return 0;
		int minCombos = Integer.MAX_VALUE;
		for (int i = 0; i < arrayLength; i++) {// start at zero
			minCombos = Math.min(minCombos,
					TheRod[i]  + costPerCut + RodCutMin(TheRod, arrayLength - i - 1, 4));
		}
		return minCombos ;
	}

	
	public static int BottomUpRodCut(int p[], int n) {// n^2 complexity
        int r[] = new int[n + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, (p[i] + r[j - i]));
            }
            r[j] = q;
        }
        return r[n];
    }
	
	
	public static void Extended_Bottom_Up_Cut_Rod(int p[], int n) {// with size of cuts,
       int r[] = new int[n + 1];
       int sizesCuts[] = new int[n + 1];
       r[0] = 0;
       for (int j = 1; j <= n; j++) {
           int q = Integer.MIN_VALUE;
           for (int i = 1; i <= j; i++) {
               if (q < (p[i] + r[j - i])) {
                   q = p[i] + r[j - i];
                   sizesCuts[j] = i;
               } 
           }
           r[j] = q;
       }
       while (n > 0) {
           System.out.print(sizesCuts[n] + "  ");
           n = n - sizesCuts[n];
       }
   }

	public static void main(String[] args) {
		System.out.println("The solution with constraint is: "
				+ RodCutMin(pieces2, pieces2.length,4));
		
		 Extended_Bottom_Up_Cut_Rod(pieces, pieces.length-1 );
		System.out.println("\n The max solution is: " + RodCutMax(pieces2, pieces2.length-1 ));
	}
}
