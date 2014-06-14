import java.util.*;
/*
Longest common subsequence


author: mr.prakashnatarajan@outlook.com
*/

class LongestCS {
	public static void main(String[] args) {
		//two input sequences 
		char[] X = {'A','B','C','B','D','A','B'};
		char[] Y = {'B','D','C','A','B','A'};
		LongestCS program = new LongestCS();
		PairOf2DArray result = program.LCS_Length(X, Y);
		int[][] C = result.getArray1();// These two array are of dimention M+1 x N+1 
		char[][] B = result.getArray2();
		for( int i = 1; i <= X.length; i++){
			for(int j = 1; j <= Y.length; j++) {
				System.out.print(C[i][j] + ":"+B[i][j]+"    ");
			}
			System.out.println();
		}
	}

	private PairOf2DArray LCS_Length(char[] X,char[] Y) {
		int m = X.length;
		int n = Y.length;
		int[][] c = new int[m+1][n+1];
		char[][] b = new char[m+1][n+1];
		for(int i = 0; i <= m; i++) {
			c[i][0] = 0;
			b[i][0] = ' ';
		}
		for(int j = 0; j <= n; j++) {
			c[0][j] = 0;
			b[0][j] = ' ';
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(X[i-1] == Y[j-1]) {
					c[i][j] = c[i-1][j-1] + 1;
					b[i][j] = '@';
				}
				else if (c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
					b[i][j] = '|';
				}
				else {
					c[i][j] = c[i][j-1];
					b[i][j] = '=';
				}
			}
		}
		return(new PairOf2DArray(c,b));
	}


}
//class t return 2d array
class PairOf2DArray {
	private int[][] array1; //c is a int array
	private char[][] array2;
	public PairOf2DArray(int[][] array11, char[][] array22) {
		this.array1 = array11;
		this.array2 = array22;
	}
	public int[][] getArray1() { return this.array1;}
	public char[][] getArray2() { return this.array2;}
} 
