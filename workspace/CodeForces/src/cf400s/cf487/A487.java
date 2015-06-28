package cf400s.cf487;

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

public class A487 {
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
	
	int hm, am, dm, hy;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	hy = in.nextInt();
    	int ay = in.nextInt();
    	int dy = in.nextInt();
    	hm = in.nextInt();
    	am = in.nextInt();
    	dm = in.nextInt();
    	int hc = in.nextInt();
    	int ac = in.nextInt();
    	int dc = in.nextInt();
    	long ans = Long.MAX_VALUE;
		for (int a = 0; a < 200; a++) {
			for (int d = 0; d < 200; d++) {
				int h = hpToWin(a+ay, d+dy);
				if (h == -1) continue;
				long cost = h*hc + a*ac + d*dc;
				ans = Math.min(ans, cost);
			}
		}
    	System.out.println(ans);
    }
    
    public int hpToWin(int ay, int dy) {
    	if (ay-dm <= 0) return -1; //impossible
    	if (am-dy <= 0) return 0;
    	
    	double turns = (double)hm / (double)(ay-dm);
    	int turnY = (int) Math.ceil(turns);
    	
    	// so you need turnY+1 and take am-dy per turn
    	return Math.max(0, turnY * (am-dy) + 1 - hy);
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
