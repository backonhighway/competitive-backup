package cf500s.cf535;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class D535 {
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
	
	
	public int[] zAlgo(char[] str) {
		int n = str.length;
		int[] z = new int[n];
		if (n == 0) return z;
		z[0] = n;
		int l = 0, r = 0;
		for(int i = 1; i < n; i++){
			if (i > r) {
				l = r = i;
				while (r < n && str[r-l] == str[r]) r++;
				z[i] = r-l; r--;
			} else {
				int k = i-l;
				if (z[k] < r-i+1) {
					z[i] = z[k];
				} else {
					l = i;
					while (r < n && str[r-l] == str[r]) r++;
					z[i] = r-l; r--;
				}
			}
		}
		return z;
	}
	
	final int MOD = 1_000_000_007;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	int n = in.nextInt();
    	int m = in.nextInt();
    	String p = in.next();
    	int len = p.length();
    	
    	if (m == 0) {
        	long ans = 1;
        	for (int i = 0; i < n; i++) {
    			ans = (ans * 26) % MOD;
    		}
        	System.out.println(ans);
        	return;
    	}
    	
    	
    	int[] mal = new int[m];
    	for (int i = 0; i < m; i++) {
			mal[i] = in.nextInt();
		}

    	
    	if (mal[m-1] + len - 1 > n) {
    		System.out.println(0);
    		return;
    	}
    	
    	//set where its ok to put
    	int[] z = zAlgo(p.toCharArray());

    	//loop throught the string
    	int count = 0;
    	for (int i = 0; i < m; i++) {
			if (i == 0) {
				count += mal[i] - 1;
			} else {
				int lastIndex = mal[i-1] + len;
				if (lastIndex <= mal[i]) {
					count += mal[i] - lastIndex;
				} else {
					int index = mal[i] - mal[i-1];
					if (z[index] != len - index) {
						System.out.println(0);
						return;
					}
				}
			}
			if (i == m-1) {
				count += n - (mal[i] + len - 1);
			}
		}
    	
    	
    	//calc ans
    	long ans = 1;
    	for (int i = 0; i < count; i++) {
			ans = (ans * 26) % MOD;
		}
    	System.out.println(ans);
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
