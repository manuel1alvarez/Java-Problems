
public class MaxSubArray {
	public static void main(String [] args){
		int[] ArrayOne = new int[10];// array of integers
		
		for (int i = 0; i < ArrayOne.length; i++) {
			ArrayOne[i] = (int) (Math.random()*13);
			if(ArrayOne[i]%2 ==0)
				ArrayOne[i] = (-1)*ArrayOne[i];
		}
		System.out.println("the original Array:" );
		for (int row : ArrayOne) {
			System.out.print("|"+ row);
		}
		System.out.println(Integer.MIN_VALUE);
		//FindMaxSubArray(ArrayOne, 0, ArrayOne.length -1);
	}
	
	
	private static int MaxCrossingArray(int[] someArray, int lo, int mid, int hi){
		int leftSum = Integer.MIN_VALUE; int sum = 0;
		for(int i = mid; i>= lo; i--){
			sum = sum + someArray[i];
			if(sum> leftSum)
				leftSum = sum;
				 int maxLeft = i;
		}
		int rightSum = Integer.MIN_VALUE; sum = 0;
		for(int j = mid+1; j <= hi; j++){
			sum = sum + someArray[j];
			if(sum> rightSum)
				rightSum = sum;
				 int maxRight = j;
		}
		return rightSum;// just to remove error
		//return (maxLeft, maxRight, leftSum +rightSum);
	}
	
	
	
 private static int FindMaxSubArray(int[] someArray, int lo, int hi){// gives the continuous subarray with the highest sum
	 if(lo==hi)
		 return someArray[lo];// we want to return the entire subArray and also the sum
	 
	 else{
		 int mid = (int) (lo+hi)/2;
		 int leftMax = FindMaxSubArray(someArray,lo, mid);//recurse to base case
		 int rightMax = FindMaxSubArray(someArray, mid+1, hi);
		 //int[] subArray = new
		 
	 }
	 return 0;
		
	}
	
	
	
	
}

