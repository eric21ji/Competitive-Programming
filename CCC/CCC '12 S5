import java.util.*;

public class Main {

    static int[][] paths;
    static int[][] grid;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        paths = new int[r+1][c+1];
        grid = new int[r+1][c+1];
        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            grid[sc.nextInt()][sc.nextInt()] = 1;
        }
        sc.close();

        System.out.println(numPaths(r, c));
    }

    public static int numPaths(int r, int c) {
        paths[1][1] = 1;

        for(int row = 1; row <= r; row++) {
            for(int col = 1; col <= c; col++) {
                if((row == 1 && col == 1) || grid[row][col] == 1) continue;
                else paths[row][col] += paths[row-1][col] + paths[row][col-1];
            }
        }

        return paths[r][c];
    }
}
