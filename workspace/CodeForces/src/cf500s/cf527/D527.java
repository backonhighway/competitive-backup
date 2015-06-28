package cf500s.cf527;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class D527 {
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
    	int[] x = new int[n];
    	int[] w = new int[n];
    	for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			w[i] = in.nextInt();
		}
    	ArrayList<Interval> list = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
			list.add(new Interval(x[i] - w[i], x[i] + w[i]));
		}
    	list.sort(Comparator.comparing(interval -> interval.right));
    	
    	int ans = 0;
    	int lastright = Integer.MIN_VALUE;
    	for (Interval interval : list) {
    		if (lastright <= interval.left) {
    			ans++;
    			lastright = interval.right;
    		}
    	}
    	System.out.println(ans);
    }
    
    class Interval {
    	int left; int right;
    	Interval (int left, int right) {
    		this.left = left; this.right = right;
    	}
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
