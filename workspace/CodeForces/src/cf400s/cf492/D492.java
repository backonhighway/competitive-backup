package cf400s.cf492;

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

public class D492 {
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
    	int x = in.nextInt();
    	int y = in.nextInt();
    	int[] a = new int[n];
    	for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
    	
    	int[] res = new int[x+y];
    	double curx = 1;
    	double cury = 1;
    	for (int i = 0; i < x+y; i++) {
			double dx = curx / (double) x;
			double dy = cury / (double) y;
			
			if (dx < dy) {
				res[i] = 1;
				curx++;
			}
			else if (dy < dx) {
				res[i] = 2;
				cury++;
			}
			else {
				res[i] = 3;
				i++;
				res[i] = 3;
				curx++;
				cury++;
			}
		}
    	debug(res);
    	
    	for (int i = 0; i < n; i++) {
			int key = (a[i]-1) % (x+y);
			if (res[key] == 1) {
				System.out.println("Vanya");
			}
			else if (res[key] == 2) {
				System.out.println("Vova");
			}
			else {
				System.out.println("Both");
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
