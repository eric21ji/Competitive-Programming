// Code TLE
import java.util.*;

public class Main {
	
	static int steps;
	static String[] one;
	static String[] two;
	static String[] three;
	static int oneLen;
	static int twoLen;
	static int threeLen;
	static String target;
	static int type;
	static Set<String> visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		one = sc.nextLine().split(" ");
		two = sc.nextLine().split(" ");
		three = sc.nextLine().split(" ");
		oneLen = one[0].length();
		twoLen = two[0].length();
		threeLen = three[0].length();
		steps = sc.nextInt();
		String start = sc.next();
		target = sc.next();
		sc.close();
		
        visited = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		list = dfs(list, start, 0);
		for(int k = steps-1; k >= 0; k--) {
			System.out.println(list.get(k));
		}
	}

	public static ArrayList<String> dfs(ArrayList<String> re, String st, int count) {
		if(count > steps || visited.contains(st + count)) {return re;}
		if(re.size() > 0 && re.get(0).split(" ")[2].equals(target)) { re.add(st); return re;}
        String cur = "";
        if(count == 0) cur = st;
        if(count != 0) cur = st.split(" ")[2];
        if(cur.equals(target) && count == steps) {re.add(st); return re;}
		ArrayList<String> temp = expandKids(cur);
		for(String str : temp) {
			re = dfs(re, str, count+1);
			if(re.size() > 0 && re.get(0).split(" ")[2].equals(target)) {re.add(st); return re;}
            else visited.add(str+count);
		}
        visited.add(st + count);
		return re;
	}
	
	public static ArrayList<String> expandKids(String root) {
		ArrayList<String> res = new ArrayList<>();
		int len = root.length();
		for(int i = 0; i < len; i++) {
			if(i+oneLen <= len && len >= oneLen && root.substring(i, i+oneLen).equals(one[0])) {
				res.add("1 " + (i+1) + " "+ root.substring(0, i)+one[1]+root.substring(i+oneLen, len));
			}
			if(i+twoLen <= len && len >= twoLen && root.substring(i, i+twoLen).equals(two[0])) {
				res.add("2 " + (i+1) + " "+ root.substring(0, i)+two[1]+root.substring(i+twoLen, len));
			}
			if(i+threeLen <= len && len >= threeLen && root.substring(i, i+threeLen).equals(three[0])) {
				res.add("3 " + (i+1) + " "+ root.substring(0, i)+three[1]+root.substring(i+threeLen, len));
			}
		}
		return res;
	}
}
