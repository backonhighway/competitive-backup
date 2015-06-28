package cf500s.cf505;

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

public class C505 {
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
    	int d = in.nextInt();
    	int[] gems = new int[n];
    	for (int i = 0; i < n; i++) {
			gems[i] = in.nextInt();
		}
    	int[] gemcount = new int[30001];
    	for (int i = 0; i < n; i++) {
			gemcount[gems[i]]++;
		}

    	int[][] dp = new int[30001][500];
    	for (int i = 0; i < 30001; i++) {
			Arrays.fill(dp[i], -1);
		}
    	dp[d][250] = gemcount[d];
    	//j=0 means d-250 
    	//so realj = j+offset
    	final int OFFSET = d - 250; 
    	
    	for (int i = 0; i < 30001; i++) {
			for (int j = 0; j < 500; j++) {
				if (dp[i][j] == -1) continue;
				int realj = j + OFFSET;
				if (realj <= 0) continue;
				
				//-1
				int nexti = i + realj - 1;
				if (1 <= realj - 1 && 1 <= j
						&& 0 <= nexti && nexti <= 30000) {
					int next = dp[i][j] + gemcount[nexti];
					dp[nexti][j-1] = Math.max(dp[nexti][j-1], next);
				}
				//0
				nexti = i + realj;
				if (0 <= nexti && nexti <= 30000) {
					int next = dp[i][j] + gemcount[nexti];
					dp[nexti][j] = Math.max(dp[nexti][j], next);
				}
				//1
				nexti = i + realj + 1;
				if (j+1 < 500 && 0 <= nexti && nexti <= 30000) {
					int next = dp[i][j] + gemcount[nexti];
					dp[nexti][j+1] = Math.max(dp[nexti][j+1], next);
				}
			}
		}
    	
    	int ans = 0;
    	for (int i = 0; i < 30001; i++) {
			for (int j = 0; j < 500; j++) {
				ans = Math.max(ans, dp[i][j]);
			}
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
