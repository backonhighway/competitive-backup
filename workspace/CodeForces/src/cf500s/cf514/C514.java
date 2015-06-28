package cf500s.cf514;

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

public class C514 {
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
	final long MOD = 1_099_511_627_689L;
	final long base = 32749;
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	int n = in.nextInt();
    	int m = in.nextInt();
    	String[] memory = new String[n];
    	String[] compare = new String[m];
    	for (int i = 0; i < n; i++) {
			memory[i] = in.next();
		}
    	for (int i = 0; i < m; i++) {
			compare[i] = in.next();
		}

    	HashSet<Long> set = new HashSet<>();
    	for (int i = 0; i < n; i++) {
    		long hash = 0;
			char[] cs = memory[i].toCharArray();
			int len = cs.length;
			for (int j = 0; j < len; j++) {
				hash = (hash * base + cs[j]) % MOD;
			}
			long basepow = 1;
			for (int j = len-1; j>=0; j--) {
				if (j != len-1) {
					basepow = basepow * base % MOD;
				}
				if (cs[j] == 'a') {
					long b = (hash + basepow) % MOD;
					set.add(b);
					long c = (b + basepow) % MOD;
					set.add(c);
				} else if (cs[j] == 'b') {
					long a = mod(hash - basepow);
					set.add(a);
					long c = (hash + basepow) % MOD;
					set.add(c);
				} else {
					long b = mod(hash - basepow);
					set.add(b);
					long a = mod(hash - basepow*2);
					set.add(a);
				}
			}
		}
    	for (int i = 0; i < m; i++) {
    		long hash = 0;
			char[] cs = compare[i].toCharArray();
			for (int j = 0; j < cs.length; j++) {
				hash = (hash * base + cs[j]) % MOD;
			}
			if (set.contains(hash)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
    }
    
    public long mod(long a) {
    	if (a >= 0) return a % MOD;
    	else return a % MOD + MOD;
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
