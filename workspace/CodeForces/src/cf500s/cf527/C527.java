package cf500s.cf527;

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

public class C527 {
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
    	int w = in.nextInt();
    	int h = in.nextInt();
    	int n = in.nextInt();
    	String[] dir = new String[n];
    	int[] cutpos = new int[n];
    	for (int i = 0; i < n; i++) {
			dir[i] = in.next();
			cutpos[i] = in.nextInt();
		}
    	TreeSet<Integer> hpos = new TreeSet<>();
    	TreeSet<Integer> wpos = new TreeSet<>();
    	TreeMap<Integer, Integer> hlencount = new TreeMap<>();
    	TreeMap<Integer, Integer> wlencount = new TreeMap<>();
    	hpos.add(0); hpos.add(h);
    	wpos.add(0); wpos.add(w);
    	hlencount.put(h, 1);
    	wlencount.put(w, 1);
    	
    	for (int i = 0; i < n; i++) {
    		//which to use
    		TreeSet<Integer> posset;
    		TreeMap<Integer, Integer> lencount;
			if (dir[i].charAt(0) == 'H') {
				posset = hpos;
				lencount = hlencount;
			} else {
				posset = wpos;
				lencount = wlencount;
			}
			
			//update
			int lower = posset.lower(cutpos[i]);
			int higher = posset.higher(cutpos[i]);
			posset.add(cutpos[i]);
			
			int len = higher - lower;
			Integer count = lencount.get(len);
			if (count == 1) lencount.remove(len);
			else lencount.put(len, count-1);
			
			len = cutpos[i] - lower;
			count = lencount.get(len);
			if (count == null) lencount.put(len, 1);
			else lencount.put(len, count+1);
			
			len = higher - cutpos[i];
			count = lencount.get(len);
			if (count == null) lencount.put(len, 1);
			else lencount.put(len, count+1);
			
			//answer
			System.out.println((long)hlencount.lastKey() * (long)wlencount.lastKey());
			
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
    public long nextLong() {
        return Long.parseLong(next());
    }

}
}
