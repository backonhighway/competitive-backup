package cf500s.cf519;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B519 {
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
    	int[] before = new int[n];
    	int[] first = new int[n-1];
    	int[] second = new int[n-2];
    	
    	for (int i = 0; i < n; i++) {
			before[i] = in.nextInt();
		}
    	for (int i = 0; i < n-1; i++) {
			first[i] = in.nextInt();
		}
    	for (int i = 0; i < n-2; i++) {
			second[i] = in.nextInt();
		}
    	
    	Arrays.sort(before);
    	Arrays.sort(first);
    	Arrays.sort(second);
    	
    	int fcorrection = -1;
    	int scorrection = -1;
    	
    	for (int i = 0; i < n-1; i++) {
			if (before[i] != first[i]) {
				fcorrection =  before[i];
				break;
			}
		}
    	if (fcorrection == -1) fcorrection = before[n-1];
    	
    	for (int i = 0; i < n-2; i++) {
			if (first[i] != second[i]) {
				scorrection =  first[i];
				break;
			}
		}
    	if (scorrection == -1) scorrection = first[n-2];
    	
    	out.println(fcorrection);
    	out.println(scorrection);
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
