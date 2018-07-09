package sorting;

import java.util.Arrays;


public class MinArray {
	public static void main(String[] args) {
		double[] a = {1,5,4,10,23,45,.55,23,22,19};
		double min = min(a);
//		System.out.println(min);
//		System.out.println(Arrays.toString(minAndMax(a)));
		System.out.println(select(a,0,a.length-1,2));
		
	}
	/*
	 * Takes as input an array of doubles 
	 * Returns the smallest element
	 */
	
	static double min(double[] a) {
		double min = a[0];
		for(int i = 1; i<a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}
	/*
	 * Takes as input an array of doubles 
	 * Returns the smallest and the largest element
	 */
	static double[] minAndMax(double[] a) {
		int n = a.length;
		int start = n % 2;
		double min = 0, max = 0;
		if(start == 1) {
			min = a[0];
			max = a[0];
		}
		else {
			start = 2;
			if(a[0]>a[1]) {
				min = a[1];
				max = a[0];
			}
			else {
				min = a[0];
				max = a[1];
			}
		}
		for(int i = start; i<n; i=i+2) {
			double low = 0, high = 0;
			if(a[i]>a[i+1]) {
				low = a[i+1];
				high = a[i];
			}
			else {
				low = a[i];
				high = a[i+1];
			}
			if(min>low) {
				min = low;
			}
			if(max<high) {
				max = high;
			}
		}
		double[] ans = {min,max};
		return ans;
	}
	/*
	 * Takes as input an array of doubles , sub-array low (p) and high (r) , and int i indicating 
	 * which smallest number is desired
	 * Returns the ith smallest number
	 */
	static double randomizedSelect(double[] a, int p, int r, int i) {
		if(p==r) {
			return a[p];
		}
		int q = Quicksort.randomizedPartition(a, p, r);
		int k = q - p + 1;
		if(i==k) {
			return a[q];
		}
		else if(i<k) {
			return randomizedSelect(a,p,q-1,i);
		}
		else {
			return randomizedSelect(a,q+1,r,i-k);
		}
	}
	/*
	 * Selection in worst case linear time
	 * Returns the ith smallest entry
	 * @args an array and an integer indicating the order statistic
	 */
	static double select(double[] a, int p, int r, int i) {
		if(p==r) {
			return a[p];
		}
		int n = (r-p+1+4)/5;
		
		double[] medians = new double[n];
		int[] starts = new int[n] ;
		// set the starts
		starts[0] = p;
		for(int j=1; j<medians.length; j++) {
			starts[j] =  p+j*5;
		}
		
		// find the medians
		for(int j=0; j<medians.length; j++) {
			int upper = p+5*(j+1);
			if(upper>r+1) {
				upper = r+1;
			}
			
			double[] g = Arrays.copyOfRange(a, starts[j], upper);
			
			insertionSort(g);
			int m = g.length/2;
			
			medians[j] = g[m];		
		}
		
		double medianOfMedians = select(medians,0, medians.length-1, medians.length/2);
		int q = partition(a,p,r,medianOfMedians);
		int k = q - p + 1;
		if(i==k) {
			return a[q];
		}
		else if(i<k) {
			return select(a,p,q-1,i);
		}
		else {
			return select(a,q+1,r,i-k);
		}
	}
	
	static int partition(double[] A, int p, int r , double x) {
		
		int i = Arrays.binarySearch(A, x);
		double temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		return Quicksort.partition(A,p,r);
	}
	
	static void insertionSort(double[] a) {
		for(int j=1; j<a.length; j++) {
			double key = a[j];
			int i = j-1;
			while(i>-1 && a[i]>key) {
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;	
		}
	}

}
