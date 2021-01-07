import java.util.*;
import java.io.*;

public class Main {
	
	static Map<Integer, LinkedList<Integer>> graph;
	static boolean[] visited;
	static int n;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new HashMap<>();
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if(m != 0) graph.put(i, new LinkedList<Integer>() );
            for(int k = 0; k < m; k++) {
                int y = Integer.parseInt(st.nextToken());
                graph.get(i).add(y);
            }
        }

        System.out.println(bfs(1));
    }

    public static int bfs(int s) {
        visited = new boolean[n+1];
        visited[s] = true;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(s);
        int count = 0;
        boolean stopCounting = false;

        while( !qu.isEmpty() ) {
            int size = qu.size();
            if(!stopCounting) count++;
            for(int i = 0; i < size; i++) {
                int cur = qu.poll();
                LinkedList<Integer> temp = graph.get(cur);
                if(temp == null) {stopCounting = true; continue;}
                for(int v : temp) {
                    if(!visited[v]) {
                        visited[v] = true;
                        qu.add(v);
                    }
                }
            }
        }
        boolean allVisited = true;
        for(int j = 1; j <= n; j++) {
            if(!visited[j]) {System.out.println("N"); allVisited = false; break;} 
        }
        if(allVisited) System.out.println("Y");
        return count;
    }
}
