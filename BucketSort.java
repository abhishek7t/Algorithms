package sorting;
import java.util.*;

public class BucketSort {
	
	public static void main(String[] args) {
		double [] a = {.78,.17,.39,.26,.72,.94,.21,.12,.23,.68};
		double[] sorted = bucketSort(a);
		System.out.println(Arrays.toString(sorted));
	}
	static double[] bucketSort(double[] A) {
		int n = A.length;
		double[] ans = new double[n];
		ArrayList<ArrayList<Double>> B = new ArrayList<ArrayList<Double>>();
		
		for(int i=0; i<n; i++) {
			B.add( new ArrayList<Double>());
		}
		
		for(int i=0; i<n; i++) {
			ArrayList<Double> item = B.get((int)(n * A[i]));
			item.add(new Double(A[i]));
		}
		
		for(int i=0 ; i<n; i++) {
			ArrayList<Double> item = B.get(i);
			item.sort(null);
			//System.out.println(item);
		}
		
		int j = 0;
		for(int i =0;i<n;i++) {
			Iterator<Double> iter = B.get(i).iterator();
			while (iter.hasNext()){
			Double item = iter.next();
			ans[j] = item;
			j++;
			}
		}
		return ans;
	}
}
