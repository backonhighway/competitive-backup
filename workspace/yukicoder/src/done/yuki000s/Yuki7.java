package done.yuki000s;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Yuki7 {

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
    	isPrime = new boolean[n+1];
    	
    	sieve(n);
    	List<Integer> primes = new ArrayList<>();
    	for (int i = 0; i <= n; i++) {
			if (isPrime[i]) primes.add(i);
		}
    	
    	boolean[] canwin = new boolean[n+1];
    	for (int i = 2; i <= n; i++) {
			if (!canwin[i]) {
				for (int e : primes) {
					int next = i + e;
					if (next <= n) canwin[next] = true;
				}
			}
		}
    	String ans = canwin[n] ? "Win" : "Lose";
    	System.out.println(ans);
    	
    	
    }
    
	public boolean[] isPrime;
	
	public void sieve(int n){ //Eratosthenes
		for(int i=0; i<=n; i++) isPrime[i] = true;
		isPrime[0] = isPrime [1] = false;
		for(int i=2; i<=n; i++){
			if(isPrime[i]){
				for(int j=2*i; j<=n; j+=i) isPrime[j] = false;
			}
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
