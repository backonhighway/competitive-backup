package abc23;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D023 {

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
    	int c = in.nextInt();
    	int k = in.nextInt();
    	int n = in.nextInt();
    	int[] ri = new int[n];
    	int[] ci = new int[n];
    	for (int i = 0; i < n; i++) {
			ri[i] = in.nextInt();
			ci[i] = in.nextInt();
		}
    	
    	int[] rsum = new int[n];
    	int[] csum = new int[n];
    	for (int i = 0; i < n; i++) {
			rsum[ri[i]]++;
			csum[ci[i]]++;
		}
    	HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //sum, which column
    	for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<Integer>());
		}
    	for (int i = 0; i < n; i++) {
    		HashSet<Integer> set = map.get(csum[i]);
			set.add(i);
		}
    	for (int i = 0; i < n; i++) {
    		int row = i;
			int x = k - rsum[i];
			HashSet<Integer> set = map.get(x);
			
		}
    	
    			
    	out.println();
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
