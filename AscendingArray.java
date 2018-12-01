import java.util.Arrays;

/*
 * Problem Determine whether or not an int array with no duplicates is sorted in
ascending order. */

public class AscendingArray {

	public static void main(String[] args) {
		int[] arrayOne = new int[20];// int array size 20
		for (int i = 0; i < arrayOne.length; i++) {
			arrayOne[i] = i;
		}
		int[] arrayTwo = new int[20]; int count=0;
		for (int i = arrayTwo.length -1; i >=0; i--) {
			arrayTwo[count] = i;
			System.out.println(i);
		}

		int[] list = new int[10];
		for (int i=0; i<10; i++){
			int n = (int)(Math.random()*9 + 1);
			list[i] = n;


		System.out.println(Arrays.toString(arrayTwo));
		System.out.println(Arrays.toString(arrayOne));
		System.out.println("is it sorted " + isSortedAscending(arrayOne,0,19));
	}

	private static double average(int[] A, int lo, int hi) {
		return A[lo];
	}
	
/*
 * Using a "divide-and-conquer" approach to determine whether or not the array A[1:N]  which does not contain duplicate values  is sorted in
ascending order. The algorithm first divides the array into left and right halves and then compares
the last element of the left half-array to the first element of the right half-array to confirm that
those two elements are properly ordered in ascending order; Recursive;
 */
	private static boolean isSortedAscending(int[] A, int lo, int hi) {// Complexity???
		if (lo == hi)
			return true;
		else {
			int loHalfTop = (hi + lo) / 2;
			int hiHalfBottom = loHalfTop + 1;
			if (A[loHalfTop] > A[hiHalfBottom])//checks middle and one after for unsorted
				return false;
			else// branches out recursively to try out all pairs
				return (isSortedAscending(A, lo, loHalfTop) && 
						isSortedAscending(A, hiHalfBottom, hi));
			//should return trues all the way back up the chain.
		}
	}

}