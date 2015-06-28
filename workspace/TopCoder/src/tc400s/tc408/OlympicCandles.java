package tc400s.tc408;
import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class OlympicCandles {
    public int numberOfNights(int[] candles) {
		int night = 1;
		int len = candles.length;
		while(canlight(candles, night)){
			Arrays.sort(candles);
			for(int i=len-1; i>=len-night; i--){
				candles[i]--;
			}
			night++;
		}
		return --night;
    }
    
    public boolean canlight(int[] candles, int night){
    	int len = candles.length;
    	int count = 0;
    	for(int i=0; i<len; i++){
    		if(candles[i]>0) count++;
    	}
    	return count>=night;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			OlympicCandlesHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				OlympicCandlesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class OlympicCandlesHarness {
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
			int[] candles             = {2, 2, 2};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}
		case 1: {
			int[] candles             = {2, 2, 2, 4};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}
		case 2: {
			int[] candles             = {5, 2, 2, 1};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}
		case 3: {
			int[] candles             = {1, 2, 3, 4, 5, 6};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}
		case 4: {
			int[] candles             = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}

		// custom cases

/*      case 5: {
			int[] candles             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}*/
/*      case 6: {
			int[] candles             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}*/
/*      case 7: {
			int[] candles             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new OlympicCandles().numberOfNights(candles));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
