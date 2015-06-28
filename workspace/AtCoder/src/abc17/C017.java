package abc17;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C017 {

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
    	int N = in.nextInt();
    	int M = in.nextInt();
    	int[] l = new int[N];
    	int[] r = new int[N];
    	int[] s = new int[N];
    	for (int i = 0; i < N; i++) {
    		l[i] = in.nextInt();
    		r[i] = in.nextInt();
    		s[i] = in.nextInt();
    	}
    	
    	int sum = 0;
    	for (int i = 0; i < N; i++) {
			sum += s[i];
		}
    	
    	int[] imos = new int[M+2];
    	for (int i = 0; i < N; i++) {
			imos[l[i]] += s[i];
			imos[r[i]+1] += -s[i];
		}
    	for (int i = 1; i < imos.length; i++) {
			imos[i] += imos[i-1];
		}
    	
    	
    	int ans = 10000000;
    	for (int i = 1; i <= M; i++) {
			ans = Math.min(ans, imos[i]);
		}
    	out.println(sum - ans);
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
