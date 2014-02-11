import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

class TestClass {
	static Map<String, Boolean> cache;
	
	static boolean isPossible(int []n, int index, int num) {
		String key = index + " " + num;
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		
		if (num == 0) {
			return true;
		}
		
		if (index >= n.length) {
			return false;
		}
		
		boolean res = false;
		
		if (num >= n[index]) {
		   res = isPossible(n, index + 1, num - n[index]);	
		}
		
		res =  res || isPossible(n, index + 1, num);
		cache.put(key, res);
		return res;
	}
	
	static int solve(int p, int m, BufferedReader br) throws Exception {
		String []s = br.readLine().split("\\s+");
		int []n = new int[m];
		for (int i=0;i<m;++i) {
			n[i] = Integer.parseInt(s[i]);
		}
		
		int []people = new int[p];
		s = br.readLine().split("\\s+");
		for (int i=0;i<p;++i) {
			people[i] = Integer.parseInt(s[i]);
		}
		
		int res = 0;
		int count = 1;
		cache = new HashMap<String, Boolean>();
		for (int i = 0; i < people.length -1; ++i) {
			if (people[i+1] == people[i]) count++;
			else {
				if (isPossible(n, 0, count)) ++ res;
				count = 1;
			}
		}
		if (isPossible(n, 0, count)) ++ res;
		return res;
	}
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int cases = Integer.parseInt(line);
        for (int i = 0; i < cases; i++) {
            String []s = br.readLine().split("\\s+");
            int p = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            System.out.println(solve(p, m, br));
        }
    }
}