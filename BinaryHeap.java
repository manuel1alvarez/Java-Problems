public class BinaryHeap {

private static int heapSize;
	
private static void HeapSort(int[] A){
	BuildMaxHeap(A);
	for(int i = A.length-1; i >= 1; i--){
		swap(A,0,i);// swap last element with root, root is now sorted.
		heapSize = heapSize -1;// remove the now sorted element from contention.
		MaxHeapify(A,0);// restructure the array to heap property. starting at first index.
	}
}

/*This runs n/2 times or O(n) & calls maxheapify which requires log(n)
 * We could actually do away with this one and just use heapify but the loop
 *  saves us having to heapify from top to bottom, hence the changing index.
 */
private static void BuildMaxHeap(int[] A){// 
	heapSize = A.length -1;// since we're going to include zero subtract 1.
	for(int i  = A.length/2 ; i >=0; i--){
		MaxHeapify(A, i);
	}
}

private static void MaxHeapify(int[] A, int i){// given the current state of things
	int leftChild =  2*i;
	int rightChild = leftChild +1;
	int largest;
	if(leftChild <= heapSize && A[leftChild] > A[i]){
			 largest = leftChild;}
		else{
			largest = i;}
		
	if(rightChild <= heapSize && A[rightChild] > A[largest] )
		largest = rightChild;
	if(largest != i){
		swap(A,i,largest);
		MaxHeapify(A,largest);
	}
	
}
	
	
	
private static void swap(int[] someArray, int index1, int index2) {
	int temp = someArray[index1];
	someArray[index1] = someArray[index2];
	someArray[index2] = temp;
}
	
	
	public static void main(String[] args){
	 int[] HeapArray = new int[10];
	 for (int i = 0; i < HeapArray.length; i++) {
			HeapArray[i] = (int) (20*Math.random());}
	 int[] testArray2 = {1,2,7,3,4,13};
	 int[] testArray = {23,29,19,15,22,18,17,14,31,12,16,21};
	 
	 for (int row : testArray) {
			System.out.print("|"+ row);
		}
	 System.out.print(" original Array ");
	 
	BuildMaxHeap(testArray);
	System.out.println("\n");	
	
	 for (int row : testArray) {
			System.out.print("|"+ row); }
	 System.out.print(" Heaped Array ");
	 
	 
	 HeapSort(testArray);
		System.out.println("\n");	
		
		 for (int row : testArray) {
				System.out.print("|"+ row); }
		 System.out.print(" Sorted Array ");
	}

}
