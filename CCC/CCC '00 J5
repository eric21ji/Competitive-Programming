import java.util.*;
import java.io.*;

public class Main {

    static Map< String, ArrayList<String> > pages;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pages = new HashMap<>();
        for(int i = 0; i < n; i++){
            String x = br.readLine();
            if( !pages.containsKey(x) ) pages.put(x, new ArrayList<String>());
            while(true){
                String line = br.readLine();
                if(line.equals("</HTML>")){break;}
                String[] input = line.split(" ");
                int len = input.length;
                for(int k = 0; k < len; k++){
                    if(input[k].length() > 5 && input[k].substring(0, 5).equals("HREF=")){
                        int end = 0;
                        for(int j = 0; j < input[k].length(); j++){
                            if(input[k].charAt(j) == '"'){
                                end = j;
                            }
                        }
                        String str = input[k].substring(6, end);
                        pages.get(x).add(str);
                        System.out.println("Link from " + x + " to " + str);
                    }
                }
            }
        }

        
        while(true){
            Queue<String> qu = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            String start = br.readLine();
            boolean reachable = false;
            boolean shouldBreak = false;
            if(start.equals("The End")) break;
            String target = br.readLine();
            qu.add(start);
            visited.add(start);
            while( !qu.isEmpty() ){
                int size = qu.size();
                for(int k = 0; k < size; k++){
                    String cur = qu.poll();
                    if(cur.equals(target)){
                        reachable = true;
                        shouldBreak = true;
                        break;
                    }
                    ArrayList<String> temp = pages.get(cur);
                    if(temp == null) continue;
                    for(String str : temp){
                        if(!visited.contains(str)){
                            qu.add(str);
                            visited.add(str);
                        }
                    }
                }
                if(shouldBreak) break;
            }
            if(reachable) System.out.println("Can surf from " + start + " to " + target + ".");
            else System.out.println("Can't surf from " + start + " to " + target + ".");
        }
    }
}
