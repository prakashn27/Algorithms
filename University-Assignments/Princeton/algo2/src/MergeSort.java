import java.util.*;
/*
	 * Inputs:
	 * 		array - An array containing a sequence of integers.
	 * 		start / end - The range that you want to sort.
	 * 
	 * Output:
	 * 		number of invertions in the array by using MERGESort
	 * Author:
	 *	Prakash N
	 *mail: mr.prakashnatarajan@gmail.com
	 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class MergeSort {

	
	static int inversionCount = 0;
	public static void main(String[] args) {
		MergeSort program = new MergeSort();
		program.start();

	}
	void start() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("IntegerArray.txt"));
			
			int[] A = new int[100000];
			int i = 0;
			/*while(scanner.hasNextInt()){
				A[i] = scanner.nextInt();
				i++;
			}
			*/
			String line = null;
			while ((line = br.readLine()) != null) {
				int temp = Integer.parseInt(line);
				A[i] = temp;
				i++;
			}
			//int[] A={1,3,5,2,4,6};
			mergeSort(A, 0, A.length-1);
		/*if(True){
			for(int j : A) {
				System.out.println(j + " , ");
			}
		//} */
		} catch(FileNotFoundException e) {
			
		} catch(IOException e){

		}
		System.out.println("inversionCount is"+inversionCount);
	}
	public static void mergeSort(int[] array, int start, int end){
		if (start < end){
			int middle = (end + start) / 2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, end);

			merge(array,start,middle,end);
		}
	}

	private static void merge(int[]array, int start, int middle, int end){
		int size_1 = middle - start + 1;
		int size_2 = end - middle;

		int[] leftArray = new int[size_1];
		int[] rightArray = new int[size_2];

		for(int i = 0; i < size_1; i++){
			leftArray[i] = array[start + i];
		}

		for(int j = 0; j < size_2; j++){
			rightArray[j] = array[j + middle + 1];
		}

		int i = 0;
		int j = 0;

		for(int k = start; k <= end; k++){
			if(i == size_1){
				array[k] = rightArray[j];
				j++;
				continue;
			}

			if(j == size_2){
				array[k] = leftArray[i];
				i++;
				continue;
			}

			if(leftArray[i] <= rightArray[j]){
				array[k] = leftArray[i];
				i++;
			}else{
				array[k] = rightArray[j];
				j++;
				//System.out.println("j loop with i , j "+i+j);
				if(i <= j) {
					inversionCount =  inversionCount+(size_1 - i);
					//System.out.println("check");
				}
			}
		}
	}
}
