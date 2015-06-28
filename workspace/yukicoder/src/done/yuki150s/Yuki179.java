package done.yuki150s;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class Yuki179 {

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
    	int h = in.nextInt();
    	int w = in.nextInt();
    	String[] s = new String[h];
    	for (int i = 0; i < h; i++) {
			s[i] = in.next();
		}
    	
    	boolean none = true;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (s[i].charAt(j) == '#') none = false;
			}
		}
		if (none) {
			System.out.println("NO");
			return;
		}
    	
    	for (int dh = -h; dh <= h; dh++) {
			for (int dw = -w; dw <= w; dw++) {
				if (dh == 0 && dw == 0) continue;
				boolean good = true;
				boolean[][] used = new boolean[h][w];
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (s[i].charAt(j) != '#' || used[i][j]) continue;
						//color (i,j) red
						int bh = i + dh;
						int bw = j + dw;
						if (bh < 0 || h <= bh) continue;
						if (bw < 0 || w <= bw) continue;
						if (s[bh].charAt(bw) != '#' || used[bh][bw]) {
							good = false;
							break;
						}
						used[i][j] = true;
						used[bh][bw] = true;
					}
				}
				if (!good) continue;
				
				//check
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (s[i].charAt(j) == '#' && !used[i][j]) {
							good = false;
						}
					}
				}
				if (good) {
					System.out.println("YES");
					return;
				}
			}
		}
    	
    	System.out.println("NO");
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
