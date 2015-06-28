package cf500s.cf510;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class C510 {
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
	
	HashMap<Integer, HashSet<Integer>> map;
	Deque<Integer> stack = new ArrayDeque<>();
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	int n = in.nextInt();
    	String[] str = new String[n];
    	for (int i = 0; i < n; i++) {
			str[i] = in.next();
		}
    	
    	//make graph
    	map = new HashMap<>();
    	for (int i = 0; i <= 'z'-'a'; i++) {
    		map.put(i, new HashSet<Integer>());
    	}
    	boolean[] isFirst = new boolean[26];
    	Arrays.fill(isFirst, true);
    	boolean[] isUsed = new boolean[26];
    	for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int len = Math.min(str[i].length(), str[j].length());
				boolean allsame = true;
				for (int k = 0; k < len; k++) {
					int a = str[i].charAt(k) - 'a';
					int b = str[j].charAt(k) - 'a';
					if (a != b) {
						HashSet<Integer> set = map.get(a);
						set.add(b);
						isUsed[a] = true; isUsed[b] = true; isFirst[b] = false;
						allsame = false;
						break;
					}
				}
				if (allsame && str[i].length() > str[j].length()) {
		    		System.out.println("Impossible");
		    		return;
				}
			}
		}
    	
    	//Topological Sort
    	Arrays.fill(visited, -1);
    	for (int i = 25; i >= 0; i--) {
			if (dfs(i) == false) {
        		System.out.println("Impossible");
        		return;
			}
		}
    	
    	//get ans
    	StringBuilder sb = new StringBuilder();
    	while (!stack.isEmpty()) {
    		int a = stack.pop();
    		char c = (char) ('a' + a);
    		sb.append(c);
    	}
    	System.out.print(sb.toString());
    }
    
    int[] visited = new int[26]; //-1:no 0:once 1:done
    
    public boolean dfs(int index) {
    	if (visited[index] == 1) return true;
    	boolean ret = true;
    	HashSet<Integer> set = map.get(index);
    	for (int next : set) {
    		if (visited[next] == 1) continue;
    		if (visited[next] == 0) return false; //infinite loop
    		visited[next] = 0;
    		ret &= dfs(next);
    	}
    	stack.push(index);
    	visited[index] = 1;
    	return ret;
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
