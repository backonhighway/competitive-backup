package abc24;

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

public class C {
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
    	int d = in.nextInt();
    	int k = in.nextInt();
    	int[] l = new int[d];
    	int[] r = new int[d];
    	for (int i = 0; i < d; i++) {
			l[i] = in.nextInt();
			r[i] = in.nextInt();
		}
    	int[] s = new int[k];
    	int[] t = new int[k];
    	for (int i = 0; i < k; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt();
		}
    	
    	for (int i = 0; i < k; i++) {
			int higher = s[i];
			int lower = s[i];
			
			for (int j = 0; j < d; j++) {
				if (lower <= r[j] && l[j] <= higher) {
					higher = Math.max(higher, r[j]);
					lower = Math.min(lower, l[j]);
				}
				if (lower <= t[i] && t[i] <= higher) {
					System.out.println(j+1);
					break;
				}
			}
			
		}
    	
    	
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
