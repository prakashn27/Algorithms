import java.util.*;

class Ugly {
	int[] ugly = new int[150];
	//int i,i2 = 0, i3 = 0, i5 = 0;
	//int next_multiple_of_2, next_multiple_of_3, next_multiple_of_5;
	 

	public static void main(String[] args) {
		UglyNew program = new UglyNew();
		int nthugly = program.getNthUglyNo(150);
		System.out.println("nth Ugly number is :" + nthugly);
		
	}

	private int getNthUglyNo(int num) {
		int next_ugly_no = 1;
		ugly[0] = 1;
		int i,i2 = 0, i3 = 0, i5 = 0;
		//int next_multiple_of_2, next_multiple_of_3, next_multiple_of_5;
		int next_mulitple_of_2 = 2;
	    int next_mulitple_of_3 = 3;
	    int next_mulitple_of_5 = 5;
		for(i=1; i < num; i++) {

			next_ugly_no = min( next_mulitple_of_2, next_mulitple_of_3, next_mulitple_of_5);
			ugly[i] =  next_ugly_no;
			if(next_ugly_no  == next_mulitple_of_2) {
				i2 = i2 + 1;
				next_mulitple_of_2 = ugly[i2]*2;
			}
			if (next_ugly_no  == next_mulitple_of_3) {
				i3 = i3 + 1;
				next_mulitple_of_3 = ugly[i3]*3;
			}
			if(next_ugly_no  == next_mulitple_of_5) {
				i5 = i5 + 1;
				next_mulitple_of_5 = ugly[i5]*5;
			}
			
		}
		return next_ugly_no;
	}

	public int min( int a2, int a3, int a5) {
		if( a2 <= a3 ) {
			if( a2 <= a5 ) 
				return a2;
			else 
				return a5;
		}
		if( a3 <= a5 ) 
			return a3;
		else
			return a5;
	}
}
