package qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MineSweeper {
    final static String PROBLEM_NAME = "qual";
    final static String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    final static String INPUT_FILE_NAME = "C-small-attempt0.in";
    final static String OUTPUT_FILE_NAME = "Coutput.txt";

	
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new MineSweeper().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    int[] dx = {-1,0,1,-1,1,-1,0,1};
    int[] dy = {-1,-1,-1,0,0,1,1,1};
    
    public void solve(Scanner sc, PrintWriter pw){
        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();
        int[][] field = new int[R][C];
        // 0=clear 1=investing 2=undecided
        for(int i=0; i<R; i++)
        	for(int j=0; j<C; j++)
        		field[i][j] = 2;
        this.field = field;
        int space = R*C - M;

        field[0][0] = 0;
        int x = 0;
        int y = 0;
        if(hasNoAdjacentMine){ //has no adjacent mine
        	field[y][x] = 0;
        	for(int i=0; i<8; i++){
        		int ny = y + dy[i];
        		int nx = x + dx[i];
        		if(field[ny][nx] == 0){
        			
        		}
        	}
        }

    	pw.println("answer");
    }
    
    public void dfs(int x, int y, int[][] field, int mine){
    	boolean check = true;
    	for(int i=0; i<8; i++){
    		int ny = y + dy[i];
    		int nx = x + dx[i];
    		if(ny<0 | nx<0) continue;
    		if(field[ny][nx] == 2){
    			
    		}
    	}
    }

}
