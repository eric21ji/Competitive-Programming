import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> st = new Stack<>();
        while(true) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("0")) break;
            for(int i = input.length-1; i >= 0; i--) {
                if(!input[i].equals("+") && !input[i].equals("-")) {
                    st.push(input[i]);
                }
                else {
                    String str = st.pop() + " " + st.pop() + " " + input[i];
                    st.push(str);
                }
            }
            System.out.println(st.pop());
        }
    }
}
