import java.io.*;
import java.util.*;

public class Main {

    static String[] winners;
    static int[][][][][] mem = new int[31][31][31][31][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        winners = new String[n];
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if( move(a, b, c, d, 1) ) winners[i] = "Patrick";
            else winners[i] = "Roland";
        }
        sc.close();
        for(String str : winners) System.out.println(str);
    }

    public static boolean move(int a, int b, int c, int d, int person){
        if( mem[a][b][c][d][person] != 0) return mem[a][b][c][d][person] == 1;

        if( a >= 2 && b >= 1 && d >= 2 ){
            if( !move(a-2, b-1, c, d-2, person%2+1) ){ mem[a][b][c][d][person] = 1; return true;}
        }
        if( a >= 1 && b >= 1 && c >= 1 && d >= 1){
            if( !move(a-1, b-1, c-1, d-1, person%2+1) ){ mem[a][b][c][d][person] = 1; return true;}
        }
        if( c >= 2 && d >= 1){
            if( !move(a, b, c-2, d-1, person%2+1) ){ mem[a][b][c][d][person] = 1; return true;}
        }
        if( b >= 3 ){
            if( !move(a, b-3, c, d, person%2+1) ){ mem[a][b][c][d][person] = 1; return true;}
        }
        if( a >= 1 && d >= 1 ){
            if( !move(a-1, b, c, d-1, person%2+1) ){ mem[a][b][c][d][person] = 1; return true;}
        }
        mem[a][b][c][d][person] = -1;
        return false;
    }
}
