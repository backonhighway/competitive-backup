package tc400s.tc413;
// Paste me into the FileEdit configuration dialog

public class ArithmeticProgression {
	
	final double INF = 100000000;
	
    public double minCommonDifference(int a0, int[] seq) {
    	if(seq.length==0) return 0;
		double lb = -INF;
		double ub = INF;
		
    	for(int i=0; i<seq.length; i++){
			lb = Math.max(lb, (double)(seq[i] - a0) / (i+1));
			ub = Math.min(ub, (double)(seq[i] + 1 - a0) / (i+1));
		}
    	if(lb>=ub) return -1;
    	else if(lb < 0) return -1;
    	else return lb;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ArithmeticProgressionHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ArithmeticProgressionHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ArithmeticProgressionHarness {
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
			int a0                    = 0;
			int[] seq                 = {6, 13, 20, 27};
			double expected__         = 6.75;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}
		case 1: {
			int a0                    = 1;
			int[] seq                 = {2, 3, 4, 5, 6};
			double expected__         = 1.0;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}
		case 2: {
			int a0                    = 3;
			int[] seq                 = {};
			double expected__         = 0.0;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}
		case 3: {
			int a0                    = 3;
			int[] seq                 = {3, 3, 3, 3, 4};
			double expected__         = 0.2;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}
		case 4: {
			int a0                    = 1;
			int[] seq                 = {-3};
			double expected__         = -1.0;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}
		case 5: {
			int a0                    = 0;
			int[] seq                 = {6, 14};
			double expected__         = -1.0;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}

		// custom cases

/*      case 6: {
			int a0                    = ;
			int[] seq                 = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}*/
/*      case 7: {
			int a0                    = ;
			int[] seq                 = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}*/
/*      case 8: {
			int a0                    = ;
			int[] seq                 = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new ArithmeticProgression().minCommonDifference(a0, seq));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
