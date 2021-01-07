import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String state = br.readLine();
        String target = br.readLine();

        System.out.println(findSteps(state, target));
    }

    public static int findSteps(String state, String target){
        Queue<String> qu = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int steps = 0;
        visited.add(state);
        qu.add(state);
        if(state.equals(target)) return steps;

        while( !qu.isEmpty() ){
            int size = qu.size();
            steps++;
            for(int i = 0; i < size; i++){
                String cur = qu.poll();
                ArrayList<String> kids = findKids(cur);
                for(String kid : kids){
                    if(kid.equals(target)) return steps;
                    if( !visited.contains(kid) ){
                        visited.add(kid);
                        qu.add(kid);
                    }
                }
            }
        }

        return steps;
    }

    public static ArrayList<String> findKids(String state){
        ArrayList<String> kids = new ArrayList<>();
        String[] pos = state.split(" ");
        int x1 = Integer.parseInt(pos[0]);
        int y1 = Integer.parseInt(pos[1]);
        int re[] = fromAtoB(x1, y1, x1+2, y1+1);
        kids.add(re[0]+" "+re[1]);
        re = fromAtoB(x1, y1, x1+2, y1-1);
        kids.add(re[0]+" "+re[1]);
        re = fromAtoB(x1, y1, x1-2, y1+1);
        kids.add(re[0]+" "+re[1]);
        re = fromAtoB(x1, y1, x1-2, y1-1);
        kids.add(re[0]+" "+re[1]);
        re = fromAtoB(x1, y1, x1+1, y1+2);
        kids.add(re[0]+" "+re[1]);
        re = fromAtoB(x1, y1, x1+1, y1-2);
        kids.add(re[0]+" "+re[1]);
        re = fromAtoB(x1, y1, x1-1, y1+2);
        kids.add(re[0]+" "+re[1]);
        re = fromAtoB(x1, y1, x1-1, y1-2);
        kids.add(re[0]+" "+re[1]);
        return kids;
    }

    public static int[] fromAtoB(int x1, int y1, int x2, int y2){
        int[] re = {0, 0};
        if( x2 < 1 || y2 < 1 || x2 > 8 || y2 > 8){ re[0] = x1; re[1] = y1; return re; }
        else{ re[0] = x2; re[1] = y2; return re; }
    }
}
