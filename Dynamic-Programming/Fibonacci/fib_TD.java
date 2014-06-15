import java.util.*;

class fib_DP {
	//private int[] lookup = new int[];
	//int n;
	int[] lookup = new int[41]; // 40 is the fib number we are abt to calculate

	public static void main(String[] args) {
		fib_DP program = new fib_DP();
		program.intialize();
		System.out.print("fib of 40 :" + program.fib(40));
	}
	private int fib(int num){
		if(lookup[num] == 0){
			if(num <= 1)
				lookup[num] = num;
			else
				lookup[num] = fib(num - 1) + fib(num - 2);
		}
		return lookup[num];
	}

	private void intialize() {
		for(int i = 0; i < 41; i++) {
			lookup[i] = 0; //intialising to 0 instead of null
		}
	}
}
