package qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mytemplate {
    final static String PROBLEM_NAME = "qual";
    final static String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";

	
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Mytemplate().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    public void solve(Scanner sc, PrintWriter pw){
        int N = sc.nextInt();
        String str = sc.next();
        int[] s = new int[N+1];
        for (int i = 0; i <= N; i++) {
			s[i] = str.charAt(i) - '0';
		}
        
        int stand = 0;
        int ans = 0;
        for (int i = 0; i <= N; i++) {
        	if (stand < i) {
        		ans += i - stand;
        		stand = i;
        	}
    		stand += s[i];
		}
        
        

    	pw.println(ans);
    }

}



















