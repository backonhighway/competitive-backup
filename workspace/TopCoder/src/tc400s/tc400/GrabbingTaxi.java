package tc400s.tc400;


public class GrabbingTaxi {
	public static final int INF = Integer.MAX_VALUE;
	
    public int minTime(int[] tXs, int[] tYs, int gX, int gY, int walkTime, int taxiTime) {
    	int minTaxi = INF;
    	for(int i=0; i<tXs.length; i++){
    		int time = (Math.abs(tXs[i]) + Math.abs(tYs[i])) * walkTime
    				+ (Math.abs(tXs[i]-gX) + Math.abs(tYs[i]-gY)) * taxiTime;
    		minTaxi = Math.min(time, minTaxi);
    	}
		
		int minwalk = (Math.abs(gX) + Math.abs(gY)) * walkTime;
		
		return Math.min(minwalk, minTaxi);
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			GrabbingTaxiHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				GrabbingTaxiHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class GrabbingTaxiHarness {
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
			int[] tXs                 = {};
			int[] tYs                 = {};
			int gX                    = 3;
			int gY                    = 2;
			int walkTime              = 10;
			int taxiTime              = 2;
			int expected__            = 50;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}
		case 1: {
			int[] tXs                 = {-2, -2};
			int[] tYs                 = {0, -2};
			int gX                    = -4;
			int gY                    = -2;
			int walkTime              = 15;
			int taxiTime              = 3;
			int expected__            = 42;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}
		case 2: {
			int[] tXs                 = {3};
			int[] tYs                 = {0};
			int gX                    = 5;
			int gY                    = 0;
			int walkTime              = 10;
			int taxiTime              = 20;
			int expected__            = 50;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}
		case 3: {
			int[] tXs                 = {34, -12, 1, 0, 21, -43, -98, 11, 86, -31};
			int[] tYs                 = {11, 5, -68, 69, -78, -49, -36, -2, 1, 70};
			int gX                    = -97;
			int gY                    = -39;
			int walkTime              = 47;
			int taxiTime              = 13;
			int expected__            = 2476;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}
		case 4: {
			int[] tXs                 = {82, -60, 57, 98, 30, -67, 84, -42, -100, 62};
			int[] tYs                 = {-7, 90, 53, -56, -15, -87, 22, -3, -61, -30};
			int gX                    = 21;
			int gY                    = 15;
			int walkTime              = 53;
			int taxiTime              = 2;
			int expected__            = 1908;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}

		// custom cases

/*      case 5: {
			int[] tXs                 = ;
			int[] tYs                 = ;
			int gX                    = ;
			int gY                    = ;
			int walkTime              = ;
			int taxiTime              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}*/
/*      case 6: {
			int[] tXs                 = ;
			int[] tYs                 = ;
			int gX                    = ;
			int gY                    = ;
			int walkTime              = ;
			int taxiTime              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}*/
/*      case 7: {
			int[] tXs                 = ;
			int[] tYs                 = ;
			int gX                    = ;
			int gY                    = ;
			int walkTime              = ;
			int taxiTime              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GrabbingTaxi().minTime(tXs, tYs, gX, gY, walkTime, taxiTime));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
