import java.io.*;
import java.util.*;

public class Main {

    public static class Pair implements Comparable<Pair> {
        int a;
        boolean inOrOut;
        public Pair(int a, boolean inOrOut) {
            this.a = a;
            this.inOrOut = inOrOut;
        }

        public int compareTo(Pair other) {
            if(a >= other.a) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        Pair[] arr = new Pair[2*n];

        int count = 0;
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int in = Integer.parseInt(input[0]);
            int out = Integer.parseInt(input[1]);
            arr[count] = new Pair(in, true);
            arr[count+1] = new Pair(out, false);
            count += 2;
        }
        Arrays.sort(arr);

        count = 0;
        int maxGap = 0;
        int curY = 0;

        for(int k = 0; k < 2*n; k++) {
            if(count == 0) {
                maxGap = Math.max(maxGap, arr[k].a-curY);
            }
            curY = arr[k].a;
            if(arr[k].inOrOut) count++;
            else if(!arr[k].inOrOut) count--;
        }
        maxGap = Math.max(maxGap, L-curY);
        System.out.println(maxGap);
    }
}
