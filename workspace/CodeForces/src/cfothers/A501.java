package cfothers;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class A501 {
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
    	int a = in.nextInt();
    	int b = in.nextInt();
    	int c = in.nextInt();
    	int d = in.nextInt();
    	
    	int misha = getPoint(a,c);
    	int vasya = getPoint(b,d);
    	
    	String ans;
    	if (misha > vasya) {
    		ans = "Misha";
    	} else if (misha < vasya) {
    		ans = "Vasya";
    	} else {
    		ans = "Tie";
    	}
    	
    	out.println(ans);
    }
    public int getPoint(int a, int b) {
    	return Math.max(a / 10 * 3, a - a / 250 * b);
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
