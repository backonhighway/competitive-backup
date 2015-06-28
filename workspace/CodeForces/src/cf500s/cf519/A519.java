package cf500s.cf519;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class A519 {
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
    	int len = 8;
    	String[] board = new String[len];
    	for (int i = 0; i < len; i++) {
			board[i] = in.next();
		}
    	
    	int whitewin = 0;
    	for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i].charAt(j) == 'Q') whitewin += 9;
				if (board[i].charAt(j) == 'R') whitewin += 5;
				if (board[i].charAt(j) == 'B') whitewin += 3;
				if (board[i].charAt(j) == 'N') whitewin += 3;
				if (board[i].charAt(j) == 'P') whitewin += 1;
				if (board[i].charAt(j) == 'q') whitewin -= 9;
				if (board[i].charAt(j) == 'r') whitewin -= 5;
				if (board[i].charAt(j) == 'b') whitewin -= 3;
				if (board[i].charAt(j) == 'n') whitewin -= 3;
				if (board[i].charAt(j) == 'p') whitewin -= 1;
			}
		}
    	String ans;
    	if (whitewin > 0) ans = "White";
    	else if (whitewin < 0) ans = "Black";
    	else ans = "Draw";
    	
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
