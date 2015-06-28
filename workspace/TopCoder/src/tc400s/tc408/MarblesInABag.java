package tc400s.tc408;
// Paste me into the FileEdit configuration dialog
import java.util.*;

public class MarblesInABag {

    public double getProbability(int red, int blue) {
    	double dpnow[] = new double[blue+1];
    	double dpnext[] = new double[blue+1];
		for(int b=0; b<=blue; b++){ //when red==0
			dpnow[b] = b%2;
		}
		
		for(int r=1; r<=red; r++){
			for(int b=1; b<=blue; b++){
				double total = (double)(r + b);
				dpnext[b] += dpnow[b-1] * r/total;
				if(b>=2){
					dpnext[b] += dpnext[b-2] * b/total;
				}
			}
			for(int b=0; b<=blue; b++){
				dpnow[b] = dpnext[b];
				dpnext[b] = 0;
			}
		}
		return dpnow[blue];
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			MarblesInABagHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				MarblesInABagHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class MarblesInABagHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static final double MAX_DOUBLE_ERROR = 1E-9;
	static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
	static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }
	
	static String formatResult(double res) {
		return String.format("%.10g", res);
	}
	
	static int verifyCase(int casenum, double expected, double received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
			System.err.println();
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			int redCount              = 1;
			int blueCount             = 2;
			double expected__         = 0.3333333333333333;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}
		case 1: {
			int redCount              = 2;
			int blueCount             = 3;
			double expected__         = 0.13333333333333333;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}
		case 2: {
			int redCount              = 2;
			int blueCount             = 5;
			double expected__         = 0.22857142857142856;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}
		case 3: {
			int redCount              = 11;
			int blueCount             = 6;
			double expected__         = 0.0;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}
		case 4: {
			int redCount              = 4;
			int blueCount             = 11;
			double expected__         = 0.12183372183372182;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}

		// custom cases

      case 5: {
			int redCount              = 1;
			int blueCount             = 0;
			double expected__         = 0;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}
      case 6: {
			int redCount              = 3169;
			int blueCount             = 3998;
			double expected__         = 0.0;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}
/*      case 7: {
			int redCount              = ;
			int blueCount             = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new MarblesInABag().getProbability(redCount, blueCount));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
