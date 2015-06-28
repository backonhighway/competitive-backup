package cf500s.cf525;

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

public class C525 {
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
    	int[] l = new int[n];
    	for (int i = 0; i < n; i++) {
			l[i] = in.nextInt();
		}
    	Arrays.sort(l);
    	long ans = 0;
    	int pos = n-1;
    	while (pos >= 3) {
    		int a1 = 0;
    		if (l[pos] == l[pos-1]) {
    			a1 = l[pos];
    		} else if (l[pos] == l[pos-1]+1) {
    			a1 = l[pos] - 1;
    		} else {
    			pos--; continue;
    		}
    		pos -= 2;
    		int a2 = 0;
    		while (pos >= 1 && a2 == 0) {
        		if (l[pos] == l[pos-1]) {
        			a2 = l[pos];
        		} else if (l[pos] == l[pos-1]+1) {
        			a2 = l[pos] - 1;
        		} else {
        			pos--;
        		}
    		}
    		pos -= 2;
    		ans += (long)a1 * (long)a2;
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
