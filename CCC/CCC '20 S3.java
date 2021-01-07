// TBC: Returns TLE
import java.io.*;
import java.util.*;

public class Main {
	
	static Set<String> strs;
	static Map<String, Set<String>> mem;
	static String n;
	static String h;
	static int lenN;
	static int lenH;
	static int m = 100019;
    static int base = 27;
    static int prod;
    static LinkedList<Integer> targets;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
		h = br.readLine();
		lenN = n.length();
		lenH = h.length();
		mem = new HashMap<>();
		strs = permutations(n, n.length());
		
		int total = 0;
        targets = new LinkedList<>();
        computePower();
        preCompute();
		for(String str : strs) {
			total += compare(str);
		}
		System.out.println(total);
	}
	
	public static Set<String> permutations(String str, int len) {
        // Can't test yet, but what's gonna happen is the strings are gonna be too long; gotta hash these like immediately
        // Keep index of substring instead; Map int:int --> x(hash val):index i. That's how you memoize and keep memory and save time
		if(mem.get(str) != null) return mem.get(str);   
		Set<String> set = new HashSet<>();
		if(len == 1) {set.add(str); return set;}
		if(len == 2) {
			set.add(str.charAt(0)+""+str.charAt(1));
			set.add(str.charAt(1)+""+str.charAt(0));
			mem.put(str, set);
			return set;
		}
		for(int i = 0; i < str.length(); i++) {
			char start = str.charAt(i);
			String s = str.substring(0, i)+str.substring(i+1, len);
			Set<String> temp = permutations(s, len-1);
			mem.put(s, temp);
			for(String st : temp) set.add(start+""+st); 
		}
		mem.put(str, set);
		return set;
	}
	
	public static int compare(String str) {
		long y = rollingHash(str);
		for(int t : targets) {
            if(y == t) return 1;
        }
        return 0;
	}
	
	public static int rollingHash(String str) {
		int sum = 0;
		for(int i = 0; i < lenN; i++) {
			sum = ((sum*base)%m + (str.charAt(i)-'a'+1))%m;	
		}
		return sum;
	}
	
	public static void computePower() {
		prod = 1;
        for(int k = 0; k < lenN-1; k++){
            prod = (prod * base)%m;
        }
	}
	
	public static void preCompute() {
		// Precompute all the rolling hash values of h-string, store in a linkedlist/array
        int y = rollingHash(h.substring(0, lenN));
        targets.add(y);
        for(int i = 1; i < lenH-lenN+1; i++) {
            int chV = h.charAt(i-1)-'a'+1;
            y = (y - chV*prod)%m;
            y = (y + m)%m;
            int chV2 = h.charAt(i+lenN-1)-'a'+1;
            y = (y*27 + chV2)%m;
            targets.add(y);
        }
	}
}
