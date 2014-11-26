import java.util.*;

class RodCutting {
	public static int[] p  =   {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};//0 is added in front as array initialisations start with 0
	//private int[] length = {0, 1, 2, 3, 4,  5,  6,  7,  8,  9, 10}; 
																	
	public static void main(String[] args) {
	
	  /////////// input needs to be changes for getting different values ////////
		int n = 10;  
		RodCutting program = new RodCutting();
		Pair arrayPair = program.Extended_Bottom_Up_Cut_Rod(p,n);
		int[] revenue = arrayPair.getarray1();
		int[] s = arrayPair.getarray2();
		while(n > 0) {
			System.out.println(s[n]);
			n = n - s[n];
		}
	}	

	private Pair Extended_Bottom_Up_Cut_Rod(int[] p, int n) {
		//intialise two arrays for storing revenue and optimal size
		int[] r = new int[n+1];
		int[] s = new int[n+1];

		r[0] = 0;
		for (int j = 1; j <= n; j++ ) {
			int q = -1;
			for( int i = 1; i <= j; i++) {
				if (q < p[i] + r[j-i]){
					q = p[i] + r[j-i];
					s[j] = i;
				}
			}	
			r[j] = q;	
		}
		return new Pair(r,s);
	}

	

}
// class for returning two arrays
class Pair {
	private int[] array1;
	private int[] array2;
	public Pair(int[] array11, int[] array22) {
		this.array1 = array11;
		this.array2 = array22;
	}
	public int[] getarray1() { return this.array1;}
	public int[] getarray2() { return this.array2;}
}
