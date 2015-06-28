package tc400s.tc487;
// Paste me into the FileEdit configuration dialog

public class BunnyExamAfter {
    public int getMaximum(String black, String gray, String white) {
    	int len = black.length();
    	int total = 0;
		for(int i=0; i<len; i++){
			char blackchar = black.charAt(i);
			char graychar = gray.charAt(i);
			char whitechar = white.charAt(i);
			int cnt = 0;
			if(whitechar != blackchar) cnt++;
			if(graychar != blackchar) cnt++;
			if(whitechar != graychar && cnt==2) cnt--;
			total += cnt;
		}
		return total;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BunnyExamAfterHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BunnyExamAfterHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BunnyExamAfterHarness {
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
			String black              = "ABC";
			String gray               = "ABC";
			String white              = "ABC";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}
		case 1: {
			String black              = "A";
			String gray               = "B";
			String white              = "B";
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}
		case 2: {
			String black              = "ABC";
			String gray               = "PQR";
			String white              = "XYZ";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}
		case 3: {
			String black              = "AAAAA";
			String gray               = "AABBB";
			String white              = "BBBAA";
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}
		case 4: {
			String black              = "TOPCODER";
			String gray               = "TOPBUNNY";
			String white              = "THEHONEY";
			int expected__            = 9;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}

		// custom cases

/*      case 5: {
			String black              = ;
			String gray               = ;
			String white              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}*/
/*      case 6: {
			String black              = ;
			String gray               = ;
			String white              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}*/
/*      case 7: {
			String black              = ;
			String gray               = ;
			String white              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BunnyExamAfter().getMaximum(black, gray, white));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
