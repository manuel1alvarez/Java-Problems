
public class Fibonacci {

	public static int FibonacciSequential(int n){
		if(n==1 || n==0)
			return 1;
		int fib0 = 1,fib1 = 1, fibNext = -23;
		for(int j = 2; j<=n; j++ ){
			fibNext = fib0 + fib1;
			fib0 = fib1; fib1 = fibNext;
		}
		return fibNext;
	}

	public static int FibRecurse(int n){// devastatingly slow
		if(n==1 || n==0)
			return 1;
		return FibRecurse(n - 1) + FibRecurse(n - 2);// runs back to the 1's then builds back up.
	}
	
	
	
	public static void main(String [] args){
		System.out.println("Fibonnaci term is " + FibonacciSequential(5));
		System.out.println("Fibonnaci term is " + FibRecurse(6));
		
		
	}
	
	
	

}
