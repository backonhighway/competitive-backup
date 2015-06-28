package cf500s.cf515;

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

public class D515 {
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
	
	char[][] field;
	int n;
	int m;
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	char[] c = {'<', 'v', '>', '^'};
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {

    	n = in.nextInt();
    	m = in.nextInt();
    	field = new char[n][m];
    	for (int i = 0; i < n; i++) {
			field[i] = in.next().toCharArray();
		}
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j] == '.') {
					dfs(i, j);
				}
			}
		}
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (field[i][j] == '.') {
					out.println("Not unique");
					return;
				}
			}
		}
    	for (int i = 0; i < n; i++) {
			out.println(field[i]);
		}

    }
    
    public void toNext(int y, int x) {
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (nx < 0 || m <= nx || ny < 0 || n <= ny) continue;
			if (field[ny][nx] == '.') {
				dfs(ny, nx);
			}
		}
    }
    
    public void dfs(int y, int x) {
		int count = 0;
		int ndir = 0;
		int ny = 0;
		int nx = 0;
		for (int dir = 0; dir < 4; dir++) {
			ny = y + dy[dir];
			nx = x + dx[dir];
			if (nx < 0 || m <= nx || ny < 0 || n <= ny) continue;
			if (field[ny][nx] == '.') {
				ndir = dir;
				count++;
			}
		}
		if (count == 1) {
			ny = y + dy[ndir];
			nx = x + dx[ndir];
			field[ny][nx] = c[ndir];
			int opposite = (ndir + 2) % 4;
			field[y][x] = c[opposite];
			toNext(ny,nx);
//			for (int dir = 0; dir < 4; dir++) {
//				int nny = ny + dy[dir];
//				int nnx = nx + dx[dir];
//				if (nnx < 0 || m <= nnx || nny < 0 || n <= nny) continue;
//				if (field[nny][nnx] == '.') {
//					dfs(nny, nnx);
//				}
//			}
		}
    }
    
//    public void swapChar(int y, int x, char a) {
//    	StringBuilder sb = new StringBuilder(field[y]);
//    	sb.setCharAt(x, a);
//    	field[y] = sb.toString();
//    }
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
