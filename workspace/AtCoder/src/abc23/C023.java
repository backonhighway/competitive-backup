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

public class C023 {

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
    	HashMap<Integer, HashSet<Integer>> rmap = new HashMap<>(); //row, which column
    	for (int i = 0; i < n; i++) {
			ri[i] = in.nextInt()-1;
			ci[i] = in.nextInt()-1;
			HashSet<Integer> set = rmap.get(ri[i]);
			if (set == null) set = new HashSet<>();
			set.add(ci[i]);
			rmap.put(ri[i], set);
		}
    	
    	int[] rsum = new int[r];
    	int[] csum = new int[c];
    	for (int i = 0; i < n; i++) {
			rsum[ri[i]]++;
			csum[ci[i]]++;
		}
    	HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //sum, which column
    	for (int i = 0; i < c; i++) {
    		HashSet<Integer> set = map.get(csum[i]);
    		if (set == null) set = new HashSet<>();
			set.add(i);
			map.put(csum[i], set);
		}
    	long ans = 0;
    	for (int i = 0; i < r; i++) {
    		int row = i;
			int x = k - rsum[i];
			HashSet<Integer> set = map.get(x);
			HashSet<Integer> ameset = rmap.get(row);
			if (ameset != null) {
				for (Integer e : ameset) {
					if (set != null && !set.contains(e)) ans++;
				}
			}

			x = k - rsum[i] - 1;
			set = map.get(x);
			ameset = rmap.get(row);
			if (ameset != null) {
				for (Integer e : ameset) {
					if (set != null && set.contains(e)) ans++;
				}
			}
		}
    	
    			
    	out.println(ans);
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
