package cf500s.cf520;

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

public class C520 {
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
    	String s = in.next();
    	int[] count = new int[4];
    	for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'A') count[0]++;
			if (s.charAt(i) == 'G') count[1]++;
			if (s.charAt(i) == 'T') count[2]++;
			if (s.charAt(i) == 'C') count[3]++;
		}
    	
    	int max = 0;
    	for (int i = 0; i < 4; i++) {
			max = Math.max(max, count[i]);
		}
    	int maxtype = 0;
    	for (int i = 0; i < 4; i++) {
			if (count[i] == max) maxtype++;
		}
    	int MOD = 1_000_000_007;
    	long ans = 1;
    	for (int i = 0; i < n; i++) {
			ans = ans * maxtype % MOD;
		}
    	System.out.println(ans);
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

}
}
