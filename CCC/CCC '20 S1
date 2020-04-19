import java.io.*;
import java.util.*;
public class Main {
	
	public static class Pair implements Comparable<Pair> {
		int t;
		int d;
		public Pair(int t, int d) {
			this.t = t;
			this.d = d;
		}
		
		public int compareTo(Pair other) {
			if(t >= other.t) return 1;
			return -1;
		}
	}
	
	static Pair[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new Pair[n];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			arr[i] = new Pair(a, b);
		}
		Arrays.sort(arr);
		
		double max = 0;
		for(int i = 1; i < n; i++) {
			double cur = (double)Math.abs(arr[i].d-arr[i-1].d)/(arr[i].t-arr[i-1].t);
			if(cur > max) max = cur;
		}
		System.out.println(max);
	}
}
