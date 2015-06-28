package cfothers;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B501 {
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
    	String[] old = new String[n];
    	String[] nuw = new String[n];
    	for (int i = 0; i < n; i++) {
    		old[i] = in.next();
    		nuw[i] = in.next();
    	}
    	
    	HashMap<String, String> map = new HashMap<>();
    	for (int i = 0; i < n; i++) {
			boolean contains = false;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				if (entry.getValue().equals(old[i])) {
					map.put(entry.getKey(), nuw[i]);
					contains = true;
				}
			}
			if (!contains) map.put(old[i], nuw[i]);
		}
    	
    	out.println(map.size());
		for (Map.Entry<String, String> entry : map.entrySet()) {
			out.println(entry.getKey() + " " + entry.getValue());
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
