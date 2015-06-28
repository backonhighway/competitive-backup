package done.yuki000s;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Yuki45 {

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
    	int[] v = new int[n];
    	for (int i = 0; i < n; i++) {
			v[i] = in.nextInt();
		}
    	
    	int[][] dp = new int[n][2];
    	dp[0][1] = v[0];
    	
    	for (int i = 1; i < n; i++) {
			//take
    		dp[i][1] = Math.max(dp[i][1], dp[i-1][0] + v[i]);
    		
    		//dont take
    		dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
    		dp[i][0] = Math.max(dp[i][0], dp[i-1][1]);
		}
    	
    	System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    	
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
