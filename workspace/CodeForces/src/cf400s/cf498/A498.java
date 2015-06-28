package cf400s.cf498;

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

public class A498 {
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
    	long x1 = in.nextInt();
    	long y1 = in.nextInt();
    	long x2 = in.nextInt();
    	long y2 = in.nextInt();
    	int n = in.nextInt();
    	long[] a = new long[n];
    	long[] b = new long[n];
    	long[] c = new long[n];
    	for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			b[i] = in.nextInt();
			c[i] = in.nextInt();
		}

    	int ans = 0;
    	for (int i = 0; i < n; i++) {
			long c1 = x1 * a[i] + y1 * b[i] + c[i];
			long c2 = x2 * a[i] + y2 * b[i] + c[i];
			if ((c1 < 0 && c2 > 0) || (c1 > 0 && c2 < 0)) ans++; 
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
