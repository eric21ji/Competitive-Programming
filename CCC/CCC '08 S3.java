import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int r = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            char[][] grid = new char[r][c];
            for(int k = 0; k < r; k++) {
                String str = br.readLine();
                for(int j = 0; j < c; j++) grid[k][j] = str.charAt(j);
            }
            System.out.println(minPath(r, c, grid));
        }
    }

    public static int minPath(int r, int c, char[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] temp = {0, 0};
        qu.add(temp);
        visited.add("0#0");

        int level = 0;
        while( !qu.isEmpty() ) {
            level++;
            int size = qu.size();
            for(int k = 0; k < size; k++) {
                temp = qu.poll();
                int x = temp[0];
                int y = temp[1];
                if(x == r-1 && y == c-1) return level;
                if(grid[x][y] == '+' || grid[x][y] == '|') {
                    if(x-1>=0 && grid[x-1][y] != '*' && !visited.contains((x-1)+"#"+y)) {
                        int[] left = {x-1, y};
                        qu.add(left);
                        visited.add((x-1)+"#"+y);
                    }
                    if(x+1<r && grid[x+1][y] != '*' && !visited.contains((x+1)+"#"+y)) {
                        int[] right = {x+1, y};
                        qu.add(right);
                        visited.add((x+1)+"#"+y);
                    }
                }
                if(grid[x][y] == '+' || grid[x][y] == '-') {
                    if(y-1>=0 && grid[x][y-1] != '*' && !visited.contains(x+"#"+(y-1))) {
                        int[] up = {x, y-1};
                        qu.add(up);
                        visited.add(x+"#"+(y-1));
                    } 
                    if(y+1<c && grid[x][y+1] != '*' && !visited.contains(x+"#"+(y+1))) {
                        int[] down = {x, y+1};
                        qu.add(down);
                        visited.add(x+"#"+(y+1));
                    }
                }
            }
        }
        return -1;
    }
}
