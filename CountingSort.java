package sorting;
import java.util.*;

public class CountingSort {
	public static void main(String[] args) {
		int[] a = {2,6,3,5,6,9,0,2,1};
		int[] b = a.clone();
		int k = 15;
		System.out.println(a.length);
		
		countingSort(a,b,k);
		System.out.println(Arrays.toString(b));
		}
	
	static void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k+1] ;
		for (int i = 0; i< C.length; i++) {
		C[i] = 0;	
		}
		for (int j = 0; j< A.length; j++) {
			C[A[j]] += 1;
			//C[i] now contains the number of elements equal to i.
		}
		for(int i = 1; i< C.length  ; i++) {
			C[i] = C[i] + C[i-1];
			//C[i] now contains the number of elements less than or equal to i.
		}
		for(int j = A.length-1; j>-1; j--) {
			B[C[A[j]]-1] = A[j];
			C[A[j]] -= 1;
		}
	}
}
