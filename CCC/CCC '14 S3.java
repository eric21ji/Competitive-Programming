import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	Stack<Integer> top = new Stack<>();
    	Stack<Integer> branch = new Stack<>();
    	ArrayList<String> result = new ArrayList<>();
    	top.push(0);
    	branch.push(0);
    	int wantedCar = 1;

    	for(int i = 0; i < n; i++){
    		int t = Integer.parseInt(br.readLine());
    		for(int k = 0; k < t; k++){
        		top.push(Integer.parseInt(br.readLine()));
      		}
      		int cars = top.size();
      		while(wantedCar < cars){
				if(top.peek() == wantedCar){
					top.pop();
					wantedCar++;
				}
				else if(branch.peek() == wantedCar){
					branch.pop();
					wantedCar++;
				}
				else if(top.peek() != 0){
					branch.push(top.pop());
				}
				else if(top.peek() != wantedCar && branch.peek() != wantedCar){
					result.add("N");
					top.clear();
					branch.clear();
					top.push(0);
					branch.push(0);
					break;
				}
				if(top.peek() == 0 && branch.peek() == 0) result.add("Y");
			}
      		wantedCar = 1;
    	}
    	for(int l = 0; l < result.size(); l++){
      		System.out.println(result.get(l));
		}
  	}
}
