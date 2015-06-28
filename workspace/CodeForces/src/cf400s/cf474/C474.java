package cf400s.cf474;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class C474 {
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
	int[] x;
	int[] y;
	int[] a;
	int[] b;
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	int n = in.nextInt() * 4;
    	x = new int[n];
    	y = new int[n];
    	a = new int[n];
    	b = new int[n];
    	for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
    	
    	final int INF = 1000;
    	for (int i = 0; i < n; i+=4) {
			int minMove = INF;
			for (int j1 = 0; j1 < 4; j1++) {
				for (int j2 = 0; j2 < 4; j2++) {
					for (int j3 = 0; j3 < 4; j3++) {
						for (int j4 = 0; j4 < 4; j4++) {
//							System.out.println(j1+","+j2+","+j3+","+j4);
//							System.out.println(Arrays.toString(x));
//							System.out.println(Arrays.toString(y));
//							System.out.println("--------------");
							
							if (isSquare(i)) {
								minMove = Math.min(minMove, j1+j2+j3+j4);
							}
							turn(i+3);
						}
						turn(i+2);
					}
					turn(i+1);
				}
				turn(i);
			}
    		
			if (minMove == INF) System.out.println(-1);
			else System.out.println(minMove);
		}
    }
    
    public void turn(int index) {
    	int tempx = x[index] - a[index];
    	int tempy = y[index] - b[index];
    	x[index] = -tempy + a[index];
    	y[index] = tempx + b[index];
    }
    
    public boolean isSquare(int index) {
    	List<Long> list = new ArrayList<>();
    	
    	for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				long xdist = x[index+i] - x[index+j];
				long ydist = y[index+i] - y[index+j];
				long dist = xdist*xdist + ydist*ydist;
				list.add(dist);
			}
		}
    	Collections.sort(list);
    	long base = list.get(0);
    	if (base == 0) return false;
    	return list.get(1) == base && list.get(2) == base && list.get(3) == base
    			&& list.get(4) == base*2L && list.get(5) == base*2L;
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
