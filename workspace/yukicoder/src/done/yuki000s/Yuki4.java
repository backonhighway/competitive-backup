package done.yuki000s;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Yuki4 {

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
    	int[] w = new int[n];
    	int sum = 0;
    	for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
			sum += w[i];
		}
    	if (sum % 2 != 0) {
    		System.out.println("impossible");
    		return;
    	}
    	
    	final int MAX = 10001;
    	boolean[] possible = new boolean[MAX];
    	possible[0] = true;
    	for (int i = 0; i < n; i++) {
    		boolean[] np = new boolean[MAX];
    		for (int j = 0; j < MAX; j++) {
				np[j] = possible[j];
			}
			for (int j = 0; j < MAX; j++) {
				if (!possible[j]) continue;
				int next = j + w[i];
				np[next] = true;
			}
			possible = np;
		}
    	
    	String ans = possible[sum/2] ? "possible" : "impossible";
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

}
}
