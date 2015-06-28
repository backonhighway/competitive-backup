package cf400s.cf494;

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

public class A494 {
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
    	String str = in.next();
    	int len = str.length();
    	
    	StringBuilder sb = new StringBuilder(str);
    	int open = 0;
    	int close = 0;
    	int sharp = 0;
    	int lastSharp = -1;
    	for (int i = 0; i < len; i++) {
			if (str.charAt(i) == '(') open++;
			if (str.charAt(i) == ')') close++;
			if (str.charAt(i) == '#') {
				sharp++;
				lastSharp = i;
				sb.setCharAt(i, ')');
				close++;
			}
		}
    	
    	int insertnum = open - close;
    	for (int i = 0; i < insertnum; i++) {
    		sb.insert(lastSharp, ')');
		}
    	
    	String ns = sb.toString();
    	len = ns.length();
    	open = 0;
    	close = 0;
    	for (int i = 0; i < len; i++) {
			if (ns.charAt(i) == '(') open++;
			if (ns.charAt(i) == ')') close++;
			if (open < close) {
				System.out.println(-1);
				return;
			}
		}
    	
    	for (int i = 0; i < sharp; i++) {
    		if (i == sharp-1) {
    			System.out.println(insertnum+1);
    		} else {
    			System.out.println(1);
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
