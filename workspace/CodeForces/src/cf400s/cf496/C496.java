package cf400s.cf496;

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

public class C496 {
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
    	StringBuilder[] sb = new StringBuilder[n];
    	for (int i = 0; i < n; i++) {
			sb[i] = new StringBuilder(in.next());
		}
    	
    	final int INF = 1000000;
    	int ans = 0;
    	int min = INF;
    	while (true) {
    		min = INF;
        	for (int i = 0; i < n-1; i++) {
        		int len = sb[i].length();
        		for (int j = 0; j < len; j++) {
        			if (sb[i].charAt(j) < sb[i+1].charAt(j)) {
        				break;
        			}
					if (sb[i].charAt(j) > sb[i+1].charAt(j)) {
						min = Math.min(min, j);
						break;
					}
				}
        	}
        	if (min == INF) break;
        	
        	ans++;
        	for (int i = 0; i < n; i++) {
        		sb[i].deleteCharAt(min);
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
