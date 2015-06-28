package cf500s.cf540;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class C540 {
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
	
	boolean[][] visited;
	String[] field;
	int n;
	int m;
	final int DIR_NUM = 4;
	final int[] dx = {-1,0,1,0};
	final int[] dy = {0,1,0,-1};
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	n = in.nextInt();
    	m = in.nextInt();
    	field = new String[n];
    	for (int i = 0; i < n; i++) {
			field[i] = in.next();
		}
    	int y1 = in.nextInt()-1;
    	int x1 = in.nextInt()-1;
    	int y2 = in.nextInt()-1;
    	int x2 = in.nextInt()-1;
    	
    	int goalcount = 0;
    	for (int i = 0; i < DIR_NUM; i++) {
			int nx = x2 + dx[i];
			int ny = y2 + dy[i];
			if (nx < 0 || m <= nx || ny < 0 || n <= ny) continue;
			if (field[ny].charAt(nx) == '.' ||
					(ny == y1 && nx == x1)) goalcount++;
		}
    	if (goalcount < 1 ||
    			(goalcount == 1 && field[y2].charAt(x2) == '.')) {
    		System.out.println("NO");
    		return;
    	}
    	
    	visited = new boolean[n][m];
    	dfs(x1,y1);
    	if (visited[y2][x2]) {
    		System.out.println("YES");
    	} else {
    		System.out.println("NO");
    	}
    }
    
    public void dfs(int x, int y) {
    	visited[y][x] = true;
    	for (int i = 0; i < DIR_NUM; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || m <= nx || ny < 0 || n <= ny) continue;
			if (visited[ny][nx]) continue;
			if (field[ny].charAt(nx) == '.') {
				dfs(nx, ny);
			} else {
				visited[ny][nx] = true;
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
