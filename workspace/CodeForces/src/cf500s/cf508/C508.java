package cf500s.cf508;

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

public class C508 {
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
    	int m = in.nextInt();
    	int t = in.nextInt();
    	int r = in.nextInt();
    	int[] w = new int[m];
    	for (int i = 0; i < m; i++) {
			w[i] = in.nextInt() + t;
		}
    	
    	Arrays.sort(w);
    	boolean[] moves = new boolean[601];
    	for (int i = 0; i < m; i++) {
			int needed = r;
			int index = w[i] - 1;
			//find already lit
			for (int j = 0; j < t; j++) {
				if (needed <= 0) break;
				if (moves[index]) {
					needed--;
				}
				index--;
			}
			// light up
			index = w[i] - 1;
			for (int j = 0; j < t; j++) {
				if (needed <= 0) break;
				if (!moves[index]) {
					needed--;
					moves[index] = true;
				}
				index--;
			}
			if (needed > 0) {
				System.out.println(-1);
				return;
			}
		}
    	
    	int ans = 0;
    	for (int i = 0; i < moves.length; i++) {
			if (moves[i]) ans++;
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
