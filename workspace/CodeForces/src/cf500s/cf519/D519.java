package cf500s.cf519;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class D519 {
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
	public static int ALPHA = 26;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	int[] a = new int[ALPHA];
    	for (int i = 0; i < ALPHA; i++) {
			a[i] = in.nextInt();
		}
    	String s = in.next();
    	
    	long ans = 0;
    	int len = s.length();
    	
    	long[]cumScore = new long[len];
    	long temp = 0;
    	for (int i = 0; i < len; i++) {
    		int c = s.charAt(i) - 'a';
			temp += a[c];
			cumScore[i] = temp;
		}
    	
    	HashMap<Integer, List<Integer>> map= new HashMap<>();
    	for (int i = 0; i < ALPHA; i++) {
    		map.put(i, new ArrayList<Integer>());
    	}
    	for (int i = 0; i < len; i++) {
    		int c = s.charAt(i) - 'a';
    		map.get(c).add(i);
		}
    	
    	for (int i = 0; i < ALPHA; i++) {
    		List<Integer> list = map.get(i);
    		if (list.size() <= 1) continue;
    		int[] rep = toIntArray(list);
    		HashMap<Long, Long> countMap= new HashMap<>();
    		
    		for (int j = 0; j < rep.length; j++) {
    			Long count;
    			if (rep[j] - 1 >= 0 ) {
        			long right = cumScore[rep[j] - 1];
        			count = countMap.get(right);
        			if (count != null) ans += count;
    			}

    			long left = cumScore[rep[j]];
    			count = countMap.get(left);
    			if (count == null) countMap.put(left, 1L);
    			else countMap.put(left, count + 1);
			}
    		
    	}
    	
    	out.println(ans);
    }
    
	public int[] toIntArray(List<Integer> list)  {
		int[] ret = new int[list.size()];
		int i = 0;
		for(Integer e : list) ret[i++] = e.intValue();
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

}
}
