package tc400s.tc409;
// Paste me into the FileEdit configuration dialog

public class OrderedSuperString {
    public int getLength(String[] words) {
		int len = words.length;
		String concat = words[0];
		int previndex = 0;
		for(int i=0; i<len; i++){
			if(i==0) continue;
			int nextlen = words[i].length();
			int conlen = concat.length();
			for(int j=previndex; j<=conlen; j++){
				int common = Math.min(nextlen, conlen-j);
				String a = concat.substring(j, j+common);
				String b = words[i].substring(0, common);
				if(a.equals(b)){
					concat += words[i].substring(common);
					previndex = j;
					break;
				}
			}
		}
		return concat.length();
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			OrderedSuperStringHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				OrderedSuperStringHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class OrderedSuperStringHarness {
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
			String[] words            = {"abc","ca"};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new OrderedSuperString().getLength(words));
		}
		case 1: {
			String[] words            = {"a","a","b","a"};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new OrderedSuperString().getLength(words));
		}
		case 2: {
			String[] words            = {"abcdef", "ab","bc", "de","ef"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new OrderedSuperString().getLength(words));
		}
		case 3: {
			String[] words            = {"ab","bc", "de","ef","abcdef"};
			int expected__            = 12;

			return verifyCase(casenum__, expected__, new OrderedSuperString().getLength(words));
		}

		// custom cases

/*      case 4: {
			String[] words            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new OrderedSuperString().getLength(words));
		}*/
/*      case 5: {
			String[] words            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new OrderedSuperString().getLength(words));
		}*/
/*      case 6: {
			String[] words            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new OrderedSuperString().getLength(words));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
