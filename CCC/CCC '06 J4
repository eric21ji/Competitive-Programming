import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, LinkedList<Integer>> graph;
    static int[] indeg;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 7;
        int m = 5;

        graph = new HashMap<>();
        indeg = new int[n+1];

        for(int i = 1; i <= n; i++){
            graph.put(i, new LinkedList<Integer>() );
        }
        graph.get(1).add(4);
        indeg[4]++;
        graph.get(2).add(1);
        indeg[1]++;
        graph.get(3).add(4);
        indeg[4]++;
        graph.get(3).add(5);
        indeg[5]++;
        graph.get(1).add(7);
        indeg[7]++;

        while(true){
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            if(y == 0) break;
            graph.get(x).add(y);
            indeg[y]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        String result = "";
        for(int i = 1; i <= n; i++){
            if(indeg[i] == 0) list.add(i);
        }

        int count = 0;
        while( !list.isEmpty() ){
            int cur = findSmallest(list);
            list.remove(list.indexOf(cur));
            count++;
            result += cur + " ";
            LinkedList<Integer> temp = graph.get(cur);
            if(temp == null) continue;
            for(int v : temp){
                indeg[v]--;
                if(indeg[v] == 0) list.add(v);
            }
        }

        if(count < n) System.out.println("Cannot complete these tasks. Going to bed.");
        else System.out.println(result);
    }

    public static int findSmallest(ArrayList<Integer> list){
        int smallest = list.get(0);
        for(int n : list){
            if(n < smallest) smallest = n;
        }
        return smallest;
    }
}
