package abc23;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B023 {

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
	    int len = in.nextInt();
	    String str = in.next();
	    int ans = (len - 1) / 2;
	    boolean bad = false;
	    if (len % 2 == 0) bad = true;
	    
	    char c;
	    if (ans % 3 == 0) c = 'b';
	    else if (ans % 3 == 1) c = 'a';
	    else c = 'c';
	    for (int i = 0; i < len; i++) {
			if (c != str.charAt(i)) bad = true;
			c++;
			if (c == 'd') c = 'a';
		}
    	if (bad) ans = -1;
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
