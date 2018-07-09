package sorting;

import java.util.*;

public class Quicksort {
	public static void main(String[] args) {
	double[] a = {2,6,3,5,6,9,0,2,1};
	System.out.println(a.length);
	randomizedQuicksort(a,0,a.length -1);
	System.out.println(Arrays.toString(a));
	
	}
	
	static void quicksort(double[] A, int p, int r) {
		if (p<r){
			int q = partition(A,p,r);
			quicksort(A,p,q-1);
			quicksort(A,q+1,r);
		}
	}
	
	static int partition(double[] A, int p, int r) {
		//System.out.println(Arrays.toString(A));
		double x = A[r];
		int i = p-1;
		double temp;
		for (int j = p; j<r; j++) {
			if (A[j] <= x){
				i = i + 1;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		//System.out.println(Arrays.toString(A));
		return i+1 ;
	}
	static int randomizedPartition(double[] A, int p, int r) {
		Random rand = new Random();
		int i = rand.nextInt(r-p) + p;
		double temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		return partition(A,p,r);
	}
	static void randomizedQuicksort(double[] A, int p, int r) {
		if (p<r){
			int q = randomizedPartition(A,p,r);
			randomizedQuicksort(A,p,q-1);
			randomizedQuicksort(A,q+1,r);
		}
	}
}
