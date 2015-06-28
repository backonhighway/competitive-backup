package cf400s.cf482;

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

public class B482 {
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
    	int m = in.nextInt();
    	int[] l = new int[m];
    	int[] r = new int[m];
    	int[] q = new int[m];
    	for (int i = 0; i < m; i++) {
			l[i] = in.nextInt();
			r[i] = in.nextInt();
			q[i] = in.nextInt();
		}
    	
    	//do imos 
    	//memo: n+1 will make all ifs unneeded
    	int[][] s = new int[31][n+1]; //[bit][pos] = count
    	for (int i = 0; i < m; i++) {
			for (int bit = 0; bit < 31; bit++) {
				if ((q[i] & (1<<bit)) > 0) {
					s[bit][l[i]-1]++;
					s[bit][r[i]]--;
				}
			}
		}
		for (int bit = 0; bit < 31; bit++) {
			for (int j = 0; j < n; j++) {
				s[bit][j+1] += s[bit][j];
			}
		}
    	
    	//calc ans
    	int[] a = new int[n];
    	for (int i = 0; i < n; i++) {
			for (int bit = 0; bit < 31; bit++) {
				if (s[bit][i] > 0) {
					a[i] |= (1<<bit);
					s[bit][i] = 1;
				}
			}
		}
    	
    	//make s represent cntbit
    	for (int i = 0; i < n; i++) {
			for (int bit = 0; bit < 31; bit++) {
				if (s[bit][i] > 0) {
					s[bit][i+1] += s[bit][i];
				}
			}
    	}
    	
    	//see if a is ok
    	for (int i = 0; i < m; i++) {
    		for (int bit = 0; bit < 31; bit++) {
    			if ((q[i] & (1<<bit)) == 0) {
        			int cntOne = s[bit][r[i]-1];
        			if (l[i]-2 >= 0) cntOne -= s[bit][l[i]-2];
        			if (cntOne == r[i] - l[i] + 1) {
        				System.out.println("NO");
        				return;
        			}
    			}
    		}
    		
		}
    	System.out.println("YES");
    	for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
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
