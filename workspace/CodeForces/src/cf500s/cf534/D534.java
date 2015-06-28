package cf500s.cf534;

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

public class D534 {
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
    	int[] a = new int[n];
    	for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
    	
    	HashMap<Integer, Queue<Integer>> map = new HashMap<>();
    	int[] count = new int[n+1];
    	for (int i = 0; i < n; i++) {
			count[a[i]]++;
			Queue<Integer> que = map.get(a[i]);
			if (que == null) que = new ArrayDeque<>();
			que.add(i);
			map.put(a[i], que);
		}
    	
    	Queue<Integer> ans = new ArrayDeque<>();
    	int pos = 0;
    	while (0 <= pos && pos < n) {
    		//use
    		if (count[pos] != 0) {
        		count[pos]--;
        		Integer now = map.get(pos).poll();
        		ans.add(now+1);
        		pos++;
    		}
    		
    		//go back
			while (0 <= pos && count[pos] == 0) {
				pos -= 3;
			}
		}
    	
    	
		if (ans.size() != n) {
			System.out.println("Impossible");
			return;
		}
    	
    	System.out.println("Possible");
    	while (!ans.isEmpty()) {
    		System.out.print(ans.poll() + " ");
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
    public long nextLong() {
        return Long.parseLong(next());
    }

}
}
