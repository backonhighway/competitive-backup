package done.yuki000s;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yuki3 {

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
	
	final int INF = Integer.MAX_VALUE;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	n = in.nextInt();
    	moves = new int[n+1];
    	Arrays.fill(moves, INF);
    	moves[1] = 1;
    	
    	dfs(1, 1);
    	
    	int ans = moves[n] == INF ? -1 : moves[n];
    	
    	System.out.println(ans);
    	
    	
    	
    }
    
    int n;
    int[] moves;
    
    public void dfs(int cur, int move) {
    	int dist = Integer.bitCount(cur);
    	
    	int next = cur-dist;
    	if (0 < next) {
    		if (move+1 < moves[next]) {
    			moves[next] = move+1;
    			dfs(next, move+1);
    		}
    	}
    	next = cur+dist;
    	if (next <= n) {
    		if (move+1 < moves[next]) {
    			moves[next] = move+1;
    			dfs(next, move+1);
    		}
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
