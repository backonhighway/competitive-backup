package tc400s.tc401;
// Paste me into the FileEdit configuration dialog
import java.util.*;
public class FIELDDiagrams {
	long[][] dp;
    public long countDiagrams(int fieldOrder) {
    	
		long[][] dp = new long[fieldOrder+1][fieldOrder+1]; //tate,yoko
		for(int i=0; i<fieldOrder; i++) Arrays.fill(dp[i], -1);
		this.dp = dp;
		
		long ret = 0;
		for(int i=0; i<fieldOrder; i++){
			ret += rec(fieldOrder-1, fieldOrder-i);
		}
		return ret;
    }
    
    public long rec(int leftrow, int currentpaint){
    	if(currentpaint > leftrow + 1) return 0;
    	if(leftrow == 0) return 1;
    	if(dp[leftrow][currentpaint] != -1) return dp[leftrow][currentpaint];
    	
    	long cnt = 0;
    	for(int i=0; i<=currentpaint; i++){
    		cnt += rec(leftrow-1, currentpaint-i);
    	}
    	dp[leftrow][currentpaint] = cnt;
    	return cnt;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FIELDDiagramsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FIELDDiagramsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FIELDDiagramsHarness {
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
			int fieldOrder            = 2;
			long expected__           = 4;

			return verifyCase(casenum__, expected__, new FIELDDiagrams().countDiagrams(fieldOrder));
		}
		case 1: {
			int fieldOrder            = 3;
			long expected__           = 13;

			return verifyCase(casenum__, expected__, new FIELDDiagrams().countDiagrams(fieldOrder));
		}
		case 2: {
			int fieldOrder            = 5;
			long expected__           = 131;

			return verifyCase(casenum__, expected__, new FIELDDiagrams().countDiagrams(fieldOrder));
		}

		// custom cases

      case 3: {
			int fieldOrder            = 1;
			long expected__           = 1;

			return verifyCase(casenum__, expected__, new FIELDDiagrams().countDiagrams(fieldOrder));
		}
      case 4: {
			int fieldOrder            = 30;
			long expected__           = 0;

			return verifyCase(casenum__, expected__, new FIELDDiagrams().countDiagrams(fieldOrder));
		}
/*      case 5: {
			int fieldOrder            = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new FIELDDiagrams().countDiagrams(fieldOrder));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
