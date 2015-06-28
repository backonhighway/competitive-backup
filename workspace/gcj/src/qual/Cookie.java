package qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cookie {
    final static String PROBLEM_NAME = "qual";
    final static String WORK_DIR = "C:\\Users\\Okubo\\Desktop\\gcjfile\\" + PROBLEM_NAME + "\\";
    final static String INPUT_FILE_NAME = "B-large.in";
    final static String OUTPUT_FILE_NAME = "Boutput.txt";

	
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            new Cookie().solve(sc, pw);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    public void solve(Scanner sc, PrintWriter pw){
        double C = sc.nextDouble();
        double F = sc.nextDouble();
        double X = sc.nextDouble();
        double currentOutput = 2.0;
        double totalTime = 0.0;
        while(true){
        	double timeWithoutFarm = X / currentOutput;
        	double timeForFarm = C / currentOutput;
        	double timeWithFarm = X / (currentOutput + F) + timeForFarm;
        	if(timeWithoutFarm > timeWithFarm){ //buy farm
        		totalTime += timeForFarm;
        		currentOutput += F;
        	} else {
        		totalTime += timeWithoutFarm;
        		break;
        	}
        }
        pw.println(totalTime);
    }

}
