package tc400s.tc470;
// Paste me into the FileEdit configuration dialog

public class LinearTravellingSalesman {
   public int findMinimumDistance(int[] x, int[] y) {
		int minx = 20000;
		int maxx = 0;
		int miny = 20000;
		int maxy = 0;
		int start = 0;
		int end = 0;
		int len = x.length;
		
		for(int i=0; i<len; i++){
			if(x[i]<=minx){
				minx = x[i];
				start = i;
			}
			if(x[i]>=maxx){
				maxx = x[i];
				end = i;
			}
		}
		if(start == end){
			for(int i=0; i<len; i++){
				if(y[i]<=miny){
					miny = y[i];
					start = i;
				}
				if(y[i]>=maxy){
					maxy = y[i];
					end = i;
				}
			}
		}
		System.out.println(start+","+end);
		return Math.abs(x[start]-x[end]) + Math.abs(y[start]-y[end]);
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			LinearTravellingSalesmanHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				LinearTravellingSalesmanHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class LinearTravellingSalesmanHarness {
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
			int[] x                   = {1,3,5};
			int[] y                   = {2,2,2};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}
		case 1: {
			int[] x                   = {3,2,1};
			int[] y                   = {3,2,1};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}
		case 2: {
			int[] x                   = {0,100,1000,10000};
			int[] y                   = {0,10,100,1000};
			int expected__            = 11000;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}
		case 3: {
			int[] x                   = {80,60,70,50};
			int[] y                   = {50,70,60,80};
			int expected__            = 60;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}
		case 4: {
			int[] x                   = {7,7,7,7,7,7,7};
			int[] y                   = {105,1231,5663,295,3062,380,7777};
			int expected__            = 7672;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}

		// custom cases

/*      case 5: {
			int[] x                   = ;
			int[] y                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}*/
/*      case 6: {
			int[] x                   = ;
			int[] y                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}*/
/*      case 7: {
			int[] x                   = ;
			int[] y                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LinearTravellingSalesman().findMinimumDistance(x, y));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
