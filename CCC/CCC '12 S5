import java.io.*;
import java.util.*;

public class Main {

    static int[][] teams = { {1,2}, {1,3}, {1,4}, {2,3}, {2,4}, {3,4}};
    static int team;
    static int n;
    static boolean[][] played = new boolean[5][5];
    static int[] scores = new int[5];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        team = sc.nextInt();
        n = sc.nextInt();
        Arrays.fill(scores, 0);

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            played[x][y] = true;
            played[y][x] = true;
            int v = sc.nextInt();
            int w = sc.nextInt();
            if( v > w ) scores[x] += 3;
            else if( v < w ) scores[y] += 3;
            else{ scores[x]++; scores[y]++; }
        }
        sc.close();

        dfs(0);
        System.out.println(count);
    }

    public static boolean checkWin(){
        int max = scores[team];
        for(int k = 1; k < 5; k++){
            if( max <= scores[k] && k != team ){
                return false;
            }
        }
        return true;
    }
    
    public static void dfs(int row){
        if(row > 5){
            //find if team win or not
            if( checkWin() ) count++;
            return;
        }

        int x = teams[row][0];
        int y = teams[row][1];
        if( played[x][y] ){ //check if the team has played or not
            dfs(row+1);
            return;
        }

        //normally would use a for-loop for this, but there's only three cases so just hard coding is fine
        scores[x] += 3; 
        dfs(row + 1);
        scores[x] -= 3; //important to reset the scores

        scores[y] += 3;
        dfs(row + 1);
        scores[y] -= 3; //important to reset the scores

        scores[x]++;
        scores[y]++;
        dfs(row+1);
        scores[x]--; //important to reset the scores
        scores[y]--;
        return;
    }
}
