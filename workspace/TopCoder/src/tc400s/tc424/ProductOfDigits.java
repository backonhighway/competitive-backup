package tc400s.tc424;
// Paste me into the FileEdit configuration dialog

public class ProductOfDigits {
    public int smallestNumber(int N) {
    	if(N==1) return 1;
    	int div = 9;
    	int cnt = 0;
    	while(true){
    		if(N%div == 0){
        		N /= div;
        		cnt++;
    		}else{
    			div--;
    		}
    		if(div==1){
    			if(N != 1) return -1;
    			break;
    		}
    	}
		return cnt;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ProductOfDigitsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ProductOfDigitsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ProductOfDigitsHarness {
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
			int N                     = 1;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}
		case 1: {
			int N                     = 10;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}
		case 2: {
			int N                     = 26;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}
		case 3: {
			int N                     = 100;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}
		case 4: {
			int N                     = 2520;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}
		case 5: {
			int N                     = 864;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}

		// custom cases

      case 6: {
			int N                     = 100000000;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}
/*      case 7: {
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}*/
/*      case 8: {
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ProductOfDigits().smallestNumber(N));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
