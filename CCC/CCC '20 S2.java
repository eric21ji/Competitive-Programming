import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] grid;
	static int m;
	static int n;
	
	public static class Pair {
		int r;
		int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		grid = new int[m+1][n+1];
		for(int i = 1; i <= m; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 1; j <= n; j++) {
				grid[i][j] = Integer.parseInt(input[j-1]);
			}
		}
		
		if(bfs()) System.out.println("yes");
		else System.out.println("no");
	}
	
	public static LinkedList<Pair> factors(int a) {
		LinkedList<Pair> list = new LinkedList<>();
		
		for(int i = 1; i <= m; i++) {
			if(a%i == 0 && a/i <= n) {
				Pair temp = new Pair(i, a/i);
				if(a/i <= m && a <= n) list.add(new Pair(a/i, i));
				list.add(temp);
			}
		}
		if(a <= m) list.add(new Pair(a, 1));
		if(a <= n) list.add(new Pair(1, a));
		return list;
	}
	
	public static boolean bfs() {
		Queue<Pair> qu = new LinkedList<>();
		Set<Pair> visited = new HashSet<>();
		qu.add(new Pair(1, 1));
		visited.add(new Pair(1, 1));
		Set<Integer> vis = new HashSet<>();
		vis.add(grid[1][1]);
		
		while(!qu.isEmpty()) {
			int size = qu.size();
			for(int i = 0; i < size; i++) {
				Pair cur = qu.poll();
				LinkedList<Pair> temp = factors(grid[cur.r][cur.c]);
				if(temp == null) continue;
				for(Pair v : temp) {
					if(v.r == m && v.c == n) return true;
					if(!visited.contains(v) && !vis.contains(grid[v.r][v.c])) {
						qu.add(v);
						visited.add(v);
						vis.add(grid[v.r][v.c]);
					}
				}
			}
		}
		return false;
	}
}
