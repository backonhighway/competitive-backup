package cf400s.cf493;

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

public class C493 {
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
    	int[] a = new int[n];
    	for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
    	int m = in.nextInt();
    	int[] b = new int[m]; //10^9
    	for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}
    	
    	Toss[] tosses = new Toss[n+m];
    	for (int i = 0; i < n; i++) {
			tosses[i] = new Toss(a[i], 1);
		}
    	for (int i = 0; i < m; i++) {
			tosses[i+n] = new Toss(b[i], 2);
		}
    	Arrays.sort(tosses, Comparator.comparing(toss -> toss.d));
    	
    	int aAdvantage = (n-m) * 3;
    	int maxAdvantage = aAdvantage;
    	int acount = 0, bestA = 0;
    	int bcount = 0, bestB = 0;
    	for (int i = 0; i < n+m; i++) {
			if (tosses[i].team == 1) {
				acount++;
				aAdvantage--;
			}
			else {
				bcount++;
				aAdvantage++;
			}
			if (aAdvantage > maxAdvantage) {
				maxAdvantage = aAdvantage;
				bestA = acount;
				bestB = bcount;
			}
		}
    	System.out.println((n*3 -bestA) + ":" + (m*3-bestB));
    	

    }
    
	void debug(Object...os) {
		System.err.println(Arrays.deepToString(os));
	}
	
	public class Toss {
		int d;
		int team;
		Toss(int d, int team) {
			this.d = d; this.team = team;
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
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
}
