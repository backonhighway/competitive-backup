package cfothers;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B498 {
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
    	String[] a = new String[m];
    	String[] b = new String[m];
    	for (int i=0; i<m; i++) {
    		a[i] = in.next();
    		b[i] = in.next();
    	}
    	String[] lecture = new String[n];
    	for (int i = 0; i < n; i++) {
			lecture[i] = in.next();
		}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!lecture[i].equals(a[j])) continue;
				if (a[j].length() > b[j].length()) {
					sb.append(b[j]);
				} else {
					sb.append(a[j]);
				}
				sb.append(" ");
			}
		}
    	
    	out.println(sb.toString());
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
