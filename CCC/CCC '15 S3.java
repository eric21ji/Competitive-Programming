import java.util.*;
import java.io.*;

public class Gates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> set = new TreeSet<>();
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        for(int k = 1; k <= G; k++) {
            set.add(k);
        }

        for(int i = 0; i < P; i++) {
            int pi = Integer.parseInt(br.readLine());
            if(set.floor(pi) != null) set.remove(set.floor(pi));
            else {
                System.out.println(i); 
                return;
            }
        }
        System.out.println(P);
    }
}
