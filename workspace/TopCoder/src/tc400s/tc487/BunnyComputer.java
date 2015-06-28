package tc400s.tc487;
// Paste me into the FileEdit configuration dialog
import java.util.*;
public class BunnyComputer {
   public int getMaximum(int[] preference, int k) {
	   
	    int res = 0;
	    for(int i=0; i<k+1; i++){
	    	List<Integer> dividedlist = new ArrayList<Integer>();
	    	for(int j=i; j<preference.length; j+=k+1){
	    		dividedlist.add(preference[j]);
	    	}
			int len = dividedlist.size();
			if(len<2) continue;
			int [][] dp = new int[len][2];
			dp[0][0] = 0;
			dp[0][1] = 0;
			for(int j=1; j<len; j++){
				dp[j][0] = Math.max(dp[j-1][0], dp[j-1][1]);
				dp[j][1] = dp[j-1][0] + dividedlist.get(j) + dividedlist.get(j-1);
			}
			res += Math.max(dp[len-1][0], dp[len-1][1]);
	    }
	    return res;
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BunnyComputerHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BunnyComputerHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BunnyComputerHarness {
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
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, int expected, int received) { 
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
			int[] preference          = { 3, 1, 4, 1, 5, 9, 2, 6 };
			int k                     = 2;
			int expected__            = 28;

			return verifyCase(casenum__, expected__, new BunnyComputer().getMaximum(preference, k));
		}
		case 1: {
			int[] preference          = { 3, 1, 4, 1, 5, 9, 2, 6 };
			int k                     = 1;
			int expected__            = 31;

			return verifyCase(casenum__, expected__, new BunnyComputer().getMaximum(preference, k));
		}
		case 2: {
			int[] preference          = { 1, 2, 3, 4, 5, 6 };
			int k                     = 3;
			int expected__            = 14;

			return verifyCase(casenum__, expected__, new BunnyComputer().getMaximum(preference, k));
		}
		case 3: {
			int[] preference          = { 487, 2010 };
			int k                     = 2;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new BunnyComputer().getMaximum(preference, k));
		}

		// custom cases

/*      case 4: {
			int[] preference          = ;
			int k                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BunnyComputer().getMaximum(preference, k));
		}*/
/*      case 5: {
			int[] preference          = ;
			int k                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BunnyComputer().getMaximum(preference, k));
		}*/
/*      case 6: {
			int[] preference          = ;
			int k                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BunnyComputer().getMaximum(preference, k));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
