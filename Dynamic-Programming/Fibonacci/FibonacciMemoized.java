import java.math.BigInteger;
import java.util.ArrayList;



class FibonacciMemoized {
	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
static {
      fibCache.add(BigInteger.ZERO);
      fibCache.add(BigInteger.ONE);
}
	public static void main (String[] args) throws java.lang.Exception
	{
		FibonacciMemoized program = new FibonacciMemoized();
		System.out.print(program.fib(4));
	}
	public static BigInteger fib(int n) {
		if ( n >= fibCache.size()){
			fibCache.add(n, fib(n-1).add(fib(n-2)));
			
		}	
		return fibCache.get(n);
	}
}
