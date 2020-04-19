import java.io.*;
import java.util.*;

public class Main {

    static Map<String, LinkedList<String>> graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = new String[n];
            for(int k = 0; k < n; k++) input[k] = br.readLine();
            graph = new HashMap<>();
            System.out.println(10*n-20*newTime(n, input));
        }
    }

    public static int newTime(int n, String[] input) {
        String cur = input[n-1];
        for(int i = n-2; i >= 0; i--) {
            if(graph.containsKey(input[i])) {
                cur = input[i];
                continue;
            }
            if(!graph.containsKey(cur)) graph.put(cur, new LinkedList<String>());
            graph.get(cur).add(input[i]);
            cur = input[i];
        }
        return bfs(input[n-1]);
    }

    public static int bfs(String node) {
        Queue<String> qu = new LinkedList<String>();
        Set<String> visited = new HashSet<>();
        qu.add(node);
        visited.add(node);
        int level = -1;
        while(!qu.isEmpty()) {
            int size = qu.size();
            level++;
            for(int k = 0; k < size; k++) {
                String cur = qu.poll();
                LinkedList<String> temp = graph.get(cur);
                if(temp == null) continue;
                for(String str : temp) {
                    if(!visited.contains(str)) {
                        visited.add(str);
                        qu.add(str);
                    }
                }
            }
        }
        return level;
    }
}
