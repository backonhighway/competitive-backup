package qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MagicTrick {
    final static String PROBLEM_NAME = "qual";
    final static String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    final static String INPUT_FILE_NAME = "A-small-attempt1.in";
    final static String OUTPUT_FILE_NAME = "Boutput.txt";

	
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new MagicTrick().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    public void solve(Scanner sc, PrintWriter pw){
    	int prevrow = sc.nextInt() - 1;
    	int[][] prevpos = new int[4][4];
        for(int i=0; i<4; i++){
        	for(int j=0; j<4; j++){
        		prevpos[i][j] = sc.nextInt();
        	}
        }
        int afterrow = sc.nextInt() - 1;
        int[][] afterpos = new int[4][4];
        for(int i=0; i<4; i++){
        	for(int j=0; j<4; j++){
        		afterpos[i][j] = sc.nextInt();
        	}
        }
        
        int count = 0;
        int ans = 0;
        
        for(int i=0; i<4; i++){
        	for(int j=0; j<4; j++){
        		if(prevpos[prevrow][i] == afterpos[afterrow][j]){
        			count++;
        			ans = prevpos[prevrow][i];
        		}
        	}
        }
        if(count==0) pw.println("Volunteer cheated!");
        else if(count == 1) pw.println(ans);
        else pw.println("Bad magician!");
    }

}
