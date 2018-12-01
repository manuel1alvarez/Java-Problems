import java.util.Arrays;

public class QuickSort {
	
	public static void quicksort(int[] someArray, int indexFirst, int indexLast, boolean ascending) {
		if (indexFirst < indexLast && ascending == true) {
			int partition = partitionAscend(someArray, indexFirst, indexLast);
			quicksort(someArray, indexFirst, partition - 1, true);
			quicksort(someArray, partition + 1, indexLast, true);
			}	
		if (indexFirst < indexLast && ascending == false) {//descending sorting
			int partition = partitionDescend(someArray, indexFirst, indexLast);
			quicksort(someArray, indexFirst, partition -1 , false);
			quicksort(someArray, partition +1, indexLast, false);
		}
		return;
	}
	// bottom to top swapping, using last element as pivot.
	private static int partitionAscend(int[] someArray, int indexFirst, int indexLast) {
		int pivot = someArray[indexLast];
		int i = indexFirst-1; ;// swapping from first to last
		for (int j = indexFirst; j <= indexLast - 1; j++){
			if (someArray[j] <= pivot){
				i = i + 1;
				Swap(someArray, i, j);
			}	
		}
		Swap(someArray, i+1, indexLast);
		return i+1;// partitions the array
	}
	// bottom to top swapping, using first element as pivot.
	private static int partitionDescend(int[] someArray, int indexFirst, int indexLast) {
		int pivot = someArray[indexFirst];// using first element as the pivot
		int i = indexFirst;
		for (int j = indexFirst +1; j <= indexLast; j++){
			if (someArray[j] >= pivot){// swapping from first to last
				i = i + 1;
				Swap(someArray, i, j);
			}	
		}
		Swap(someArray, i, indexFirst);
		return i;// partitions the array 
	}
	
	public static void Swap(int[] someArray, int index1, int index2) {
		int temp = someArray[index1];
		someArray[index1] = someArray[index2];
		someArray[index2] = temp;
	}
	
	
	public static void main(String[] args) {

		int[] ArrayOne = new int[10];
		for (int i = 0; i < ArrayOne.length; i++) {
			ArrayOne[i] = (int) (Math.random() * 14);
			if(ArrayOne[i]%2 ==0)
				ArrayOne[i] = (-1)*ArrayOne[i];
		}
		
		System.out.println("the original Array:");
		for (int row : ArrayOne) {   
			System.out.print("|" + row);
		}

		quicksort(ArrayOne, 0, ArrayOne.length - 1, false);
		System.out.println("\nArray now sorted");
		for (int row : ArrayOne) {
			System.out.print("|" + row);
		}
	}
	
}
