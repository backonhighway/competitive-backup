package bugged;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
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

public class C509 {
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
    	int[] b = new int[n];
    	for (int i = 0; i < n; i++) {
			b[i] = in.nextInt();
		}
    	
    	int prev = 0;
    	int[] ans = new int[n];
    	for (int k = 0; k < n; k++) {
        	String pre = String.valueOf(prev);
        	int len = pre.length();
        	int sum = 0;
        	for (int i = 0; i < len; i++) {
        		sum += pre.charAt(i) - '0';
    		}
        	StringBuilder sb = new StringBuilder(pre);
        	// too small
        	if (b[k] > sum) {
        		for (int i = len-1; i >= 0; i--) {
        			int num = sb.charAt(i) - '0';
        			if (b[k] <= sum + 9 - num) {
        				char inc = (char) (num + b[k] - sum + '0');
        				sum = b[k];
        				sb.setCharAt(i, inc);
        				break;
        			} else {
        				sum += 9 - num;
        				sb.setCharAt(i, '9');
        			}
        		}
        	}
        	// too big
        	else if (b[k] <= sum) {
        		for (int i = len-1; i >= 0; i--) {
        			int num = sb.charAt(i) - '0';
                	if (b[k] > sum) {
                		sb = increase(sum, b[k], sb);
        				break;
        			} else {
        				sum = sum - num + 1;
        				sb.setCharAt(i, '0');
        				if (i == 0) {
        					sb.insert(0, 1);
        					i++;
        				} else {
        					char x = '0';
        					x += num + 1;
        					sb.setCharAt(i-1, x);
        				}
        			}
                	if (b[k] == sum) break;
        		}
        	}
        	prev = Integer.valueOf(sb.toString());
        	ans[k] = prev;
		}

    	
    	for (int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}
    }
    
    public StringBuilder increase(int sum, int goal, StringBuilder sb) {
		int len = sb.length();
    	for (int i = len-1; i >= 0; i--) {
			int num = sb.charAt(i) - '0';
			if (goal <= sum + 9 - num) {
				char inc = (char) (num + goal - sum + '0');
				sum = goal;
				sb.setCharAt(i, inc);
				break;
			} else {
				sum += 9 - num;
				sb.setCharAt(i, '9');
			}
		}
		return sb;
    }
    
	void debug(Object...os) {
		System.err.println(Arrays.deepToString(os));
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
