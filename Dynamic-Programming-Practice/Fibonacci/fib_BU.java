import java.util.*;

class fib_BU {
	//private int[] lookup = new int[];
	//int n;
	int[] lookup = new int[41]; // 40 is the fib number we are abt to calculate

	public static void main(String[] args) {
		fib_BU program = new fib_BU();
		//program.intialize();
		System.out.print("fib of 40 :" + program.fib(40));
	}
	//bottom- down approach
	private int fib(int num){
		for(int i = 0; i <= num; i++) {
			if(i <= 1)
			lookup[i] = i;
			else{
				lookup[i] = lookup[i-1]+lookup[i-2];
			}
			
		}
		return lookup[num];
	}

	private void intialize() {
		for(int i = 0; i < 41; i++) {
			lookup[i] = 0; //intialising to 0 instead of null
		}
	}
}
