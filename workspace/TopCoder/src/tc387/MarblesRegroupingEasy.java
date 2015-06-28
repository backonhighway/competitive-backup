package tc387;
// Paste me into the FileEdit configuration dialog

public class MarblesRegroupingEasy {
	final int INF = 100000000;
    public int minMoves(String[] boxes) {
		int len = boxes.length;
		int colorlen = boxes[0].length();
		
		int minmove = INF;
		for(int i=0; i<len; i++){//i=jokerbox
			int movecount = 0;
			int[] colorNumber = new int[len];
			for(int j=0; j<len; j++){
				if(j==i) continue;
				int cntColor = 0;
				for(int k=0; k<colorlen; k++){
					if(boxes[j].charAt(k) != '0') cntColor++;
				}
				colorNumber[j] = cntColor;
				if(cntColor>1) movecount++;
			}
			
			for(int k=0; k<colorlen; k++){
				int colorCnt = 0;
				for(int j=0; j<len; j++){
					if(j==i || colorNumber[j] != 1) continue;
					if(boxes[j].charAt(k) != '0') colorCnt++;
				}
				movecount += Math.max(0, colorCnt -1);
			}
			minmove = Math.min(movecount, minmove);
		}
		return minmove;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			MarblesRegroupingEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				MarblesRegroupingEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class MarblesRegroupingEasyHarness {
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
			String[] boxes            = {"20",
 "11"};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}
		case 1: {
			String[] boxes            = {"11",
 "11",
 "10"};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}
		case 2: {
			String[] boxes            = {"10",
 "10",
 "01",
 "01"};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}
		case 3: {
			String[] boxes            = {"11",
 "11",
 "11",
 "10",
 "10",
 "01"};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}
		case 4: {
			String[] boxes            = {"020008000070",
 "000004000000",
 "060000600000",
 "006000000362",
 "000720000000",
 "000040000000", 
 "004009003000",
 "000800000000", 
 "020030003000",
 "000500200000",
 "000000300000"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}

		// custom cases

/*      case 5: {
			String[] boxes            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}*/
/*      case 6: {
			String[] boxes            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}*/
/*      case 7: {
			String[] boxes            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new MarblesRegroupingEasy().minMoves(boxes));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
