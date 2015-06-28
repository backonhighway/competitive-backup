package cf400s.cf489;

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
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class D489 {
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
    	int m = in.nextInt();
    	HashMap<Integer, List<Integer>> map = new HashMap<>();
    	int[] a = new int[m];
    	int[] b = new int[m];
    	for (int i = 0; i < m; i++) {
			a[i] = in.nextInt(); b[i] = in.nextInt();
			List<Integer> list = map.get(a[i]);
			if (list == null) list = new ArrayList<>();
			list.add(b[i]);
			map.put(a[i], list);
		}
    	
    	long ans = 0;
    	for (int i = 1; i <= n; i++) {
    		List<Integer> list = map.get(i);
    		if (list == null) continue;
    		HashMap<Integer, Long> countMap = new HashMap<>();
    		for (int e : list) {
    			List<Integer> elist = map.get(e);
    			if (elist == null) continue;
    			for (int g : elist) {
    				if (g == i) continue;
    				Long count = countMap.get(g);
    				if (count == null) countMap.put(g, 1L);
    				else countMap.put(g, count+1L);
    			}
    		}
    		
    		//count ans
    		for (long l : countMap.values()) {
    			ans += l * (l-1) / 2L;
    		}
    		
		}
    	System.out.println(ans);
    	
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
