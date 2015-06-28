package tc400s.tc430;
// Paste me into the FileEdit configuration dialog

public class BitwiseEquations {
    public long kthPlusOrSolution(int x, int k) {
		String strx = Integer.toBinaryString(x);
		String strk = Integer.toBinaryString(k);
		int xlen = strx.length();
		int klen = strk.length();
		int kindex = klen - 1;
		String ret = "";
		for(int i=xlen-1; i>=0; i--){
			if(strx.charAt(i) == '1'){
				ret = '0' + ret;
			}else{
				if(kindex>=0){
					ret = strk.charAt(kindex) + ret;
					kindex--;
				}else{
					ret = '0' + ret;
				}
			}
		}
		for(int i=kindex; i>=0; i--){
			ret = strk.charAt(i) + ret;
		}
		return Long.parseLong(ret, 2);
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BitwiseEquationsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BitwiseEquationsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BitwiseEquationsHarness {
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
	
	static boolean compareOutput(long expected, long result) { return expected == result; }
	static String formatResult(long res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, long expected, long received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
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
			int x                     = 5;
			int k                     = 1;
			long expected__           = 2;

			return verifyCase(casenum__, expected__, new BitwiseEquations().kthPlusOrSolution(x, k));
		}
		case 1: {
			int x                     = 5;
			int k                     = 5;
			long expected__           = 18;

			return verifyCase(casenum__, expected__, new BitwiseEquations().kthPlusOrSolution(x, k));
		}
		case 2: {
			int x                     = 10;
			int k                     = 3;
			long expected__           = 5;

			return verifyCase(casenum__, expected__, new BitwiseEquations().kthPlusOrSolution(x, k));
		}
		case 3: {
			int x                     = 1;
			int k                     = 1000000000;
			long expected__           = 2000000000;

			return verifyCase(casenum__, expected__, new BitwiseEquations().kthPlusOrSolution(x, k));
		}

		// custom cases

/*      case 4: {
			int x                     = ;
			int k                     = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BitwiseEquations().kthPlusOrSolution(x, k));
		}*/
/*      case 5: {
			int x                     = ;
			int k                     = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BitwiseEquations().kthPlusOrSolution(x, k));
		}*/
/*      case 6: {
			int x                     = ;
			int k                     = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BitwiseEquations().kthPlusOrSolution(x, k));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
