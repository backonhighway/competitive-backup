package tc500s.tc500;

import java.util.Arrays;
// Paste me into the FileEdit configuration dialog

public class SRMCards {
    public int maxTurns(int[] cards) {
		Arrays.sort(cards);
		int len = cards.length;
		int ans = 0;
		for(int i=0; i<len; i++){
			ans++;
			if(i+1 < len && cards[i] + 1 == cards[i+1]){
				i++;
			}
		}
		return ans;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SRMCardsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SRMCardsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SRMCardsHarness {
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
			int[] cards               = {498, 499};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}
		case 1: {
			int[] cards               = {491, 492, 495, 497, 498, 499};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}
		case 2: {
			int[] cards               = {100, 200, 300, 400};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}
		case 3: {
			int[] cards               = {11, 12, 102, 13, 100, 101, 99, 9, 8, 1};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}
		case 4: {
			int[] cards               = {118, 321, 322, 119, 120, 320};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}
		case 5: {
			int[] cards               = {10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}

		// custom cases

/*      case 6: {
			int[] cards               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}*/
/*      case 7: {
			int[] cards               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}*/
/*      case 8: {
			int[] cards               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SRMCards().maxTurns(cards));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
