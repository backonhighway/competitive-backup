package qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Omni {
    final static String PROBLEM_NAME = "omni";
    final static String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    final static String INPUT_FILE_NAME = "D-small-attempt2.in";
    final static String OUTPUT_FILE_NAME = "output.txt";

	
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Omni().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    public void solve(Scanner sc, PrintWriter pw){
        int x = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        boolean richCanWin = false;
        // of the omni
        int minlen = x / 2 + x % 2;
        int maxlen = x;
        if (r < minlen || c < minlen) richCanWin = true;
        if (r < maxlen && c < maxlen) richCanWin = true;
        
        int leftArea = r * c - x;
        if (leftArea % x != 0) richCanWin = true;
        
        String ans = richCanWin ? "RICHARD" : "GABRIEL";
    	pw.println(ans);
    }

}



















