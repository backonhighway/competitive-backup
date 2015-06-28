package abc17;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B017 {

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
    	String str = in.next();
    	boolean isChoku = true;
    	int len = str.length();
    	for (int i = 0; i < len; i++) {
    		boolean isCh = i < len - 1 
    				&& str.charAt(i) == 'c'
    				&& str.charAt(i+1) == 'h';
    		if (isCh) i++;
			if (str.charAt(i) != 'o'
					&& str.charAt(i) != 'k'
					&& str.charAt(i) != 'u'
					&& !isCh) {
				isChoku = false;
			}
					
		}
    	
    	out.println(isChoku ? "YES" : "NO");
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
