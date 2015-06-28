package cf500s.cf535;
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

public class C535 {
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
	long a;
	long b;
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	a = in.nextInt();
    	b = in.nextInt();
    	int n = in.nextInt();
    	int[] l = new int[n];
    	int[] t = new int[n];
    	int[] m = new int[n];
    	for (int i = 0; i < n; i++) {
			l[i] = in.nextInt();
			t[i] = in.nextInt();
			m[i] = in.nextInt();
		}
    	
    	for (int i = 0; i < n; i++) {
        	long lo = l[i]; //include
    		long hi = t[i]+1; //exlude
    		long mid = lo;
    		while (lo + 1 < hi) {
    			mid = lo + (hi - lo) / 2;
    			if (check(mid, l[i], t[i], m[i])) { //check() should return true if mid includes (mid is valid)
    				lo = mid;
    			} else {
    				hi = mid;
    			}
    		} //answer is in lo	
    		if (!check(lo, l[i], t[i], m[i])) lo = -1;
    		System.out.println(lo);
    		
		}
    	

    	
    }
    
    public boolean check(long mid, long l, long t, long m) {
    	long max = a + b * (mid - 1);
    	long min = a + b * (l - 1);
    	if (t < max) return false;
    	long sum = (max + min) * (mid - l + 1) / 2;
    	long eat = t * m;
    	return sum <= eat;
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
