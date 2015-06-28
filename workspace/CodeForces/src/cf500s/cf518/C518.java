package cf500s.cf518;

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

public class C518 {
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
    	int k = in.nextInt();
    	
    	int[] app = new int[n];
    	for (int i = 0; i < n; i++) { //key:posiion val:app
			app[i] = in.nextInt()-1;
		}
    	int[] move = new int[m];
    	for (int i = 0; i < m; i++) {
			move[i] = in.nextInt()-1;
		}
    	int[] pos = new int[n]; //key:app val:position
    	for (int i = 0; i < n; i++) {
			pos[app[i]] = i;
		}
    	
    	// clicks
    	long ans = 0;
    	for (int i = 0; i < m; i++) {
    		int targetapp = move[i];
    		int targetpos = pos[targetapp];
			ans += (long)(targetpos / k) + 1L;
			
			//swap
			if (targetpos != 0) {
				int prevpos = targetpos - 1;
				int prevapp = app[prevpos];
				app[prevpos] = targetapp;
				app[targetpos] = prevapp;
				pos[prevapp]++;
				pos[targetapp]--;
			}
		}
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
    public long nextLong() {
        return Long.parseLong(next());
    }

}
}
