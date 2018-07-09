package sorting;
import java.util.*;

public class RadixSort {

	public static void main(String[] args) {
		int[] a = {329, 57, 657, 839, 436, 720, 355};
		int d = 3;
		radixSort(a,d);
		System.out.println(Arrays.toString(a));
	}
	/*
	 * Takes as input an array of whole numbers with maximum digits d.
	 * Sorts the array in place
	 */
	static void radixSort(int[] A, int d) {
		for (int i = 1 ; i < d+1; i++) {
			sort(A,i);
		}
	}
	static void sort(int[] A, int digit) {
		int[] b = A.clone();
		int[] B = b.clone();
		for(int i = 0; i<A.length; i++) {
			b[i] = ((int)(A[i] % Math.pow(10, digit) - A[i] % Math.pow(10, digit-1)))/(int)Math.pow(10, digit-1);

			//System.out.println(A[i]);
			//System.out.println(b[i]);
		}

		KeyValue[] bk = new KeyValue[A.length];
		for(int i=0; i<bk.length; i++) {
			bk[i] = new KeyValue(b[i],B[i]);
		}
		KeyValue[] Bk = bk.clone();
		
		SortByKey.countingSort(bk, Bk, 10);
		for(int i=0; i<bk.length; i++) {
			A[i] = Bk[i].val;
		}
	}
	
	static public class KeyValue{
		int key;
		int val;
		public KeyValue(int k, int v) {
			key = k;
			val = v;
		}
	}
}
