package qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dijkstra {
    final static String PROBLEM_NAME = "dijkstra";
    final static String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    final static String INPUT_FILE_NAME = "C-small-attempt1.in";
    final static String OUTPUT_FILE_NAME = "output.txt";

	
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Dijkstra().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    public void solve(Scanner sc, PrintWriter pw){
        int l = sc.nextInt();
        int x = sc.nextInt();
        String base = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
			sb.append(base);
		}
        String s = sb.toString();
        int len = s.length();
        if (len < 3) {
        	pw.println("NO");
        	return;
        }
        
        boolean isOK = false;
        int left = getIjkInt(s.charAt(0));
        if (left == 2) {
        	if(tryit(s.substring(1))) {
        		pw.println("YES");
        		return;
        	}
        }
        for (int i = 1; i < len-1; i++) {
			left = quant(left, getIjkInt(s.charAt(i)));
	        if (left == 2) {
	        	if(tryit(s.substring(i+1))) {
	        		pw.println("YES");
	        		return;
	        	}
	        }
		}
        
        String ans = isOK ? "YES" : "NO";
    	pw.println(ans);
    }
    
    public static boolean tryit(String s) {
    	boolean ret = false;
    	int len = s.length();
    	if (len < 2) return false;
    	
        int mid = getIjkInt(s.charAt(0));
        if (mid == 3) {
        	if(tryright(s.substring(1))) {
        		return true;
        	}
        }
    	for (int i = 1; i < len-1; i++) {
			mid = quant(mid, getIjkInt(s.charAt(i)));
			if (mid == 3) {
				if(tryright(s.substring(i+1))) {
					return true;
				}
			}
		}
    	
    	return ret;
    }
    
    public static boolean tryright(String s) {
    	int len = s.length();
    	int right = getIjkInt(s.charAt(0));
    	for (int i = 1; i < len; i++) {
			right = quant(right, getIjkInt(s.charAt(i)));
		}
    	return right == 4;
    }
    
    public static int quant(int i1, int i2) {
    	int signed = 1;
    	if (i1*i2 < 0) signed = -1;
    	if (i1 < 0) i1 *= -1;
    	if (i2 < 0) i2 *= -1;
    	
    	int ret = 0;
    	if (i1 == 1) {
    		if (i2 == 1) ret = 1;
    		if (i2 == 2) ret = 2;
    		if (i2 == 3) ret = 3;
    		if (i2 == 4) ret = 4;
    	}
    	if (i1 == 2) {
    		if (i2 == 1) ret = 2;
    		if (i2 == 2) ret = -1;
    		if (i2 == 3) ret = 4;
    		if (i2 == 4) ret = -3;
    	}
    	if (i1 == 3) {
    		if (i2 == 1) ret = 3;
    		if (i2 == 2) ret = -4;
    		if (i2 == 3) ret = -1;
    		if (i2 == 4) ret = 2;
    	}
    	if (i1 == 4) {
    		if (i2 == 1) ret = 4;
    		if (i2 == 2) ret = 3;
    		if (i2 == 3) ret = -2;
    		if (i2 == 4) ret = -1;
    	}
    	return ret * signed;
    }
    
    public static int getIjkInt(char c) {
    	if (c == '1') return 1;
    	if (c == 'i') return 2;
    	if (c == 'j') return 3;
    	else return 4;
    }

}



















