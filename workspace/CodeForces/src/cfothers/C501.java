package cfothers;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class C501 {
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
    	int[] degree = new int[n];
    	int[] sum = new int[n];
    	int m = 0;
    	for (int i = 0; i < n; i++) {
    		degree[i] = in.nextInt();
    		sum[i] = in.nextInt();
    		m += degree[i];
    	}
    	m /= 2;
    	
    	Queue<Integer> q = new ArrayDeque<>();
    	for (int i = 0; i < n; i++) {
    		if (degree[i] == 1) {
    			q.add(i);
    		}
    	}
    	out.println(m);
    	
    	while (!q.isEmpty()) {
    		int v = q.poll();
    		if (degree[v] != 1) continue;
    		int u = sum[v];
    		out.println(v + " " + u);
    		degree[v]--;
    		degree[u]--;
    		sum[u] ^= v;
    		if (degree[u] == 1) q.add(u);
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
