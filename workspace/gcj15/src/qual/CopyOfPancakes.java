package qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyOfPancakes {
    final static String PROBLEM_NAME = "pancake";
    final static String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    final static String INPUT_FILE_NAME = "B-small-attempt2.in";
    final static String OUTPUT_FILE_NAME = "output1.txt";

	
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new CopyOfPancakes().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    public void solve(Scanner sc, PrintWriter pw){
        int d = sc.nextInt();
        int[] p = new int[d];
        for (int i = 0; i < d; i++) {
			p[i] = sc.nextInt();
		}
        
        int ans = 1000;
        for (int mask = 0; mask < 1<<d; mask++) {
			int[] copyp = new int[d];
			for (int i = 0; i < d; i++) {
				copyp[i] = p[i];
			}
			for (int i = 0; i < d; i++) {
				
			}
		}
        
        // divide till more than i doesnt exist
        for (int i = 1; i <= 1000; i++) {
        	int[] pc = new int[1001];
            for (int j = 0; j < d; j++) {
            	pc[p[j]]++;
    		}
        	int tempcount = i;

			for (int j = 1000; j > i; j--) {
				tempcount += pc[j];
				if (j % 2 == 0) {
					pc[j/2] += pc[j] * 2;
				} else {
					pc[j/2] += pc[j];
					pc[j/2+1] += pc[j];
				}
			}
			ans = Math.min(ans, tempcount);
		}
        
    	pw.println(ans);
    }
}
