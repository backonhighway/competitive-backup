package cf500s.cf540;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class D540 {
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
    	int r = in.nextInt();
    	int s = in.nextInt();
    	int p = in.nextInt();
    	int or = r;
    	int os = s;
    	int op = p;
    	
    	double[][][] dp = new double[r+1][s+1][p+1];
    	dp[r][s][p] = 1.0;
    	boolean[][][] visited = new boolean[r+1][s+1][p+1];
    	
    	Queue<RSP> que = new ArrayDeque<RSP>();
    	que.add(new RSP(r,s,p));
    	
    	while(!que.isEmpty()) {
    		RSP now = que.poll();
    		r = now.r; s = now.s; p = now.p;
    		if(visited[r][s][p]) continue;
    		visited[r][s][p] = true;
    		double sum = r*s + s*p + p*r;
    		if (s > 0 && r > 0) {
        		double rs = r*s / sum;
    			dp[r][s-1][p] += dp[r][s][p] * rs;
    			que.add(new RSP(r,s-1,p));
    		}
    		if (r > 0 && p > 0) {
        		double rp = r*p / sum;
    			dp[r-1][s][p] += dp[r][s][p] * rp;
    			que.add(new RSP(r-1,s,p));
    		}
    		if (p > 0 && s > 0) {
        		double sp = s*p / sum;
    			dp[r][s][p-1] += dp[r][s][p] * sp;
    			que.add(new RSP(r,s,p-1));
    		}
    	}
    	
    	double rwin = 0.0;
    	for (int i = 1; i <= or; i++) {
			rwin += dp[i][0][0];
		}
    	double swin = 0.0;
    	for (int i = 1; i <= os; i++) {
			swin += dp[0][i][0];
		}
    	double pwin = 0.0;
    	for (int i = 1; i <= op; i++) {
			pwin += dp[0][0][i];
		}
    	System.out.println(rwin + " " + swin + " " + pwin);
    }
    
    class RSP {
    	int r, s, p;
    	RSP(int r, int s, int p) {
    		this.r = r; this.s = s; this.p = p;
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

}
}
