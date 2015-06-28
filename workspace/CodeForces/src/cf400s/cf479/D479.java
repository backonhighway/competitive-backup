package cf400s.cf479;

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

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class D479 {
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
    	int l = in.nextInt();
    	int x = in.nextInt();
    	int y = in.nextInt();
    	int[] a = new int[n];
    	HashSet<Integer> set = new HashSet<>();
    	for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			set.add(a[i]);
		}
    	
    	List<Integer> list = new ArrayList<>();
    	boolean okx = false, oky = false;
    	for (int i = 0; i < n; i++) {
			if (set.contains(a[i]-x)) okx = true;
			if (set.contains(a[i]-y)) oky = true;
		}
    	if (!okx) list.add(x);
    	if (!oky) list.add(y);
    	
    	if (list.size() == 2) {
    		for (int i = 0; i < n; i++) {
    			// a[i]...a[i]+x...a[i]+x+y
				if (set.contains(a[i]+x+y)) {
					System.out.println(1);
					System.out.println(a[i]+x);
					return;
				}
				// a[i]...a[i]+y-x...a[i]+y
				if (set.contains(a[i]+(y-x)) && a[i]+y <= l) {
					System.out.println(1);
					System.out.println(a[i]+y);
					return;
				}
				// a[i]-y...a[i]-y+x...a[i]
				if (set.contains(a[i]-y+x) && 0 <= a[i]-y) {
					System.out.println(1);
					System.out.println(a[i]-y);
					return;
				}
			}
    	}
    	
    	System.out.println(list.size());
		for (int e : list) {
			System.out.print(e + " ");
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
