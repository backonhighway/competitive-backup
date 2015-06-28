package cf500s.cf534;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class C534 {
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
    	long a = in.nextLong();
    	long[] d = new long[n];
    	long sum = 0;
    	for (int i = 0; i < n; i++) {
			d[i] = in.nextInt();
			sum += d[i];
		}
    	
    	long[] ans = new long[n];
    	long othermin = n-1;
    	for (int i = 0; i < n; i++) {
			long othermax = sum - d[i];
			long thismin = a - othermax;
			long thismax = a - othermin;
			if (thismin > 0) ans[i] += thismin - 1;
			if (thismax < d[i]) ans[i] += d[i] - thismax;
			System.out.print(ans[i] + " ");
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
