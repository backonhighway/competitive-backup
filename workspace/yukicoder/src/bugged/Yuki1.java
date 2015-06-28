package bugged;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class Yuki1 {

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
    	int c = in.nextInt();
    	int v = in.nextInt();
    	int[] s = new int[v];
    	int[] t = new int[v];
    	int[] y = new int[v]; //cost
    	int[] m = new int[v]; //time
    	for (int i = 0; i < v; i++) {
			s[i] = in.nextInt()-1;
		}
    	for (int i = 0; i < v; i++) {
			t[i] = in.nextInt()-1;
		}
    	for (int i = 0; i < v; i++) {
			y[i] = in.nextInt();
		}
    	for (int i = 0; i < v; i++) {
			m[i] = in.nextInt();
		}
    	HashMap<Integer, List<Road>> map = new HashMap<>();
    	for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
    	for (int i = 0; i < v; i++) {
			List<Road> list = map.get(s[i]);
			list.add(new Road(t[i], y[i], m[i]));
			map.put(s[i], list);
		}
    	
    	final int INF = Integer.MAX_VALUE/2;
    	int[][] dp = new int[n][c+1];
    	for (int i = 0; i < n; i++) {
    		Arrays.fill(dp[i], INF);
		}
    	dp[0][c] = 0;
    	
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j <= c; j++) {
				if (dp[i][j] == INF) continue;
				List<Road> list = map.get(s[i]);
				for (Road r : list) {
					int ncost = j - r.cost;
					if (ncost < 0) continue;
					int ntime = dp[i][j] + r.time;
					dp[r.to][ncost] = Math.min(dp[r.to][ncost], ntime);
				}
			}
		}
    	
    	int ans = INF;
    	for (int i = 0; i <= c; i++) {
			ans = Math.min(ans, dp[n-1][i]);
		}
    	if (ans == INF) ans = -1;
    	System.out.println(ans);
    	
    }
    
    static class Road {
    	int to;
    	int cost;
    	int time;
    	Road(int to, int cost, int time) {
    		this.to = to; this.cost = cost; this.time = time;
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
