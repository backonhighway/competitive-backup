package cf500s.cf510;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class D510 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solver solver = new Solver();
		solver.solve(1, in, out);
		out.close();
	}
	
	
static class Solver {
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	int n = in.nextInt();
    	int[] l = new int[n];
    	int[] c = new int[n];
    	for (int i = 0; i < n; i++) {
			l[i] = in.nextInt();
		}
    	for (int i = 0; i < n; i++) {
    		c[i] = in.nextInt();
		}
    	
    	HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    	for (int i = 0; i < n; i++) {
			HashSet<Integer> set = primeDivisorSet(l[i]);
			map.put(i, set);
		}
    	
    	//SetCoveringProblem
    	final int INF = 1_000_000_000;
    	int min = INF;
    	for (int i = 0; i < n; i++) {
    		HashSet<Integer> set = map.get(i);
    		int[] s = toIntArray(set);
    		int len = s.length;
    		int maxbitmask = 1 << len;
    		int[] dp = new int[maxbitmask];
			Arrays.fill(dp, INF);
			dp[maxbitmask-1] = c[i];
    		
    		for (int j = 0; j < n; j++) {
    			int jmask = 0;
    			HashSet<Integer> jset = map.get(j);
    			for (int k = 0; k < len; k++) {
					if (jset.contains(s[k])) {
						jmask += (1 << k);
					}
				}
				for (int mask = 0; mask < maxbitmask; mask++) {
					if (dp[mask] == INF) continue;
					int nmask = mask & jmask;
					int ncost = dp[mask] + c[j];
					dp[nmask] = Math.min(ncost, dp[nmask]);
				}
			}
    		min = Math.min(dp[0], min);
		}
    	
    	if (min == INF) min = -1;
    	System.out.println(min);
    	
    	
    }
    
	public int[] toIntArray(HashSet<Integer> set)  {
		int[] ret = new int[set.size()];
		int i = 0;
		for(Integer e : set) ret[i++] = e.intValue();
		return ret;
	}
    
	public HashSet<Integer> primeDivisorSet(int n){ //O(sqrt n)
		HashSet<Integer> set = new HashSet<>();
		for (int i = 2; i*i <= n; i++){
			while (n % i == 0) {
				set.add(i);
				n /= i;
			}
		}
		if (n != 1) set.add(n); //n is prime
		
		return set;
	}
    
	void debug(Object...os) {
		System.err.println(Arrays.deepToString(os));
	}
    
}

static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
}
