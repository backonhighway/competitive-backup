package done.yuki050s;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class Yuki90 {

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
    	int[] item1 = new int[m];
    	int[] item2 = new int[m];
    	int[] score = new int[m];
    	for (int i = 0; i < m; i++) {
			item1[i] = in.nextInt();
			item2[i] = in.nextInt();
			score[i] = in.nextInt();
		}
    	int[][] s = new int[n][n];
    	for (int i = 0; i < m; i++) {
			s[item1[i]][item2[i]] = score[i];
		}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++) {
			sb.append(String.valueOf(i));
		}
    	makePermutation(sb.toString());
    	
    	int max = 0;
    	for (String str : perm) {
    		int[] p = new int[n];
    		for (int i = 0; i < n; i++) {
				p[i] = Integer.valueOf(str.substring(i, i+1));
			}
    		
    		int curscore = 0;
    		for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					curscore += s[p[i]][p[j]];
				}
			}
    		max = Math.max(max, curscore);
    	}
    	System.out.println(max);
    	
    	
    	
    	
    }
    
    List<String> perm = new ArrayList<>();
    
	public void makePermutation(String str) { 
	    permutation("", str); 
	}

	private void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) perm.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
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
