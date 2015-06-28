package abc24;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class D {
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
	
	final int MOD = 1_000_000_007;
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	long a = in.nextInt();
    	long b = in.nextInt();
    	long c = in.nextInt();
    	
    	long cbunshi = b*c - a*b;
    	long rbunshi = b*c - a*c;
    	long cbunbo = a*c - b*c + a*b;
    	long rbunbo = a*b - b*c + a*c;
    	
    	cbunshi %= MOD;
    	rbunshi %= MOD;
    	cbunbo %= MOD;
    	rbunbo %= MOD;
    	
    	BigInteger bmod = BigInteger.valueOf(MOD);
    	BigInteger bcbunshi = BigInteger.valueOf(cbunshi);
    	BigInteger bcbunbo = BigInteger.valueOf(cbunbo);
    	BigInteger brbunshi = BigInteger.valueOf(rbunshi);
    	BigInteger brbunbo = BigInteger.valueOf(rbunbo);
    	
    	BigInteger bc = bcbunshi.multiply(bcbunbo.modInverse(bmod)).mod(bmod);
    	BigInteger br = brbunshi.multiply(brbunbo.modInverse(bmod)).mod(bmod);

    	System.out.println(br + " " + bc);
    	
    }
	void debug(Object...os) {
		System.err.println(Arrays.deepToString(os));
	}
	public int gcd(int a, int b){
		return b != 0 ? gcd(b, a % b) : a;
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
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
}
