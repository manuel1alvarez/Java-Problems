public class OpCount {
	/*
	 * A Basic Operation is the one can makes everything converge compared to any other 
	 * operation if it's put in the denominator. i.e. CounterTwo++; is Basic
	 */
	public static void main(String args[]){
	
	int counter = 0; int n = 100;
	for(int i = 1; i<= n; i++){
		for(int j = 1; j<=i; j++){
		counter++;// this operation is ran (N(N-1))/2
	}  } // 2 nested loops
	
	
	int counterTwo = 0; int N = 10;
	for(int i = 1; i<= N; i++){
		for(int j = 1; j <= i; j++){
			for(int k = 1; k<2*N; k++){// k=1 is ran (N(N-1))/2  times.
				counterTwo++;// this one runs  (N(N+1)(2n-1))/2 
	}  }  } // 3 nested loops
		
	
		System.out.println("counter 1 is: " + counter + "compared to the expected answer" +getSum(n));
		System.out.println("counter 1 is: " + counterTwo+ " equivalent to: " + 11*19*10/2);
}
	
	public static int getSum(int n){
	int Summation = (n*(n+1))/2;
	return Summation;
	}
	
	
}
