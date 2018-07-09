package sorting;

import java.util.Arrays;
import java.util.*;

public class SortByKey {
	
	static void countingSort(RadixSort.KeyValue[] A, RadixSort.KeyValue[] B, int k) {
		int[] C = new int[k+1] ;
		for (int i = 0; i< C.length; i++) {
		C[i] = 0;	
		}
		for (int j = 0; j< A.length; j++) {
			C[A[j].key] += 1;
			//C[i] now contains the number of elements equal to i.
		}
		for(int i = 1; i< C.length  ; i++) {
			C[i] = C[i] + C[i-1];
			//C[i] now contains the number of elements less than or equal to i.
		}
		for(int j = A.length-1; j>-1; j--) {
			B[C[A[j].key]-1] = A[j];
			C[A[j].key] -= 1;
		}
	}
}
