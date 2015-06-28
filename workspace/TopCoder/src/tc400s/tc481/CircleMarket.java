package tc400s.tc481;
import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class CircleMarket {
   public int makePurchases(int[] openTime, int[] closeTime, int travelTime) {
		int curtime = 0;
		int len = openTime.length;
		int maxcount = 0;
		boolean[] purchased = new boolean[len];
		Arrays.fill(purchased, false);
		
		int maxtime = 0;
		for(int i=0; i<len; i++){
			maxtime = Math.max(maxtime, closeTime[i]);
		}
		while(curtime<=maxtime){
			for(int i=0; i<len; i++){
				if(openTime[i]<=curtime && curtime<=closeTime[i] && !purchased[i]){
					maxcount++;
					purchased[i] = true;
				}
				curtime += travelTime;
			}
		}
		return maxcount;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CircleMarketHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CircleMarketHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CircleMarketHarness {
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
			int[] openTime            = {0, 0, 0};
			int[] closeTime           = {100, 100, 100};
			int travelTime            = 3;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}
		case 1: {
			int[] openTime            = {45, 45, 0};
			int[] closeTime           = {50, 50, 20};
			int travelTime            = 15;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}
		case 2: {
			int[] openTime            = {1000, 1000};
			int[] closeTime           = {1010, 1010};
			int travelTime            = 1;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}
		case 3: {
			int[] openTime            = {999999, 2, 4};
			int[] closeTime           = {1000000, 22, 44};
			int travelTime            = 2;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}
		case 4: {
			int[] openTime            = {363, 237, 382, 232, 392, 3829, 99999, 12};
			int[] closeTime           = {365, 1239, 2384, 234, 394, 3831, 100001, 15};
			int travelTime            = 3;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}

		// custom cases

      case 5: {
			int[] openTime            = {911099, 867079};
			int[] closeTime           = {911100, 867080};
			int travelTime            = 2;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}
/*      case 6: {
			int[] openTime            = ;
			int[] closeTime           = ;
			int travelTime            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}*/
/*      case 7: {
			int[] openTime            = ;
			int[] closeTime           = ;
			int travelTime            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CircleMarket().makePurchases(openTime, closeTime, travelTime));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
