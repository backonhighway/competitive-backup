package tc400s.tc476;

import java.util.Arrays;
// Paste me into the FileEdit configuration dialog

public class Badgers {
   public int feedMost(int[] hunger, int[] greed, int totalFood) {
	   int len = hunger.length;
	   int res = 0;
	   for(int i=0; i<len; i++){
		   int[] food = new int[len];
		   for(int j=0; j<len; j++){
			   food[j] = hunger[j] + greed[j] * i;
		   }
		   Arrays.sort(food);
		   int total = 0;
		   for(int j=0; j<=i; j++){
			   total += food[j];
		   }
		   if(total>totalFood){
			   break;
		   }else{
			   res = i+1;
		   }
	   }
	   return res;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			BadgersHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BadgersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class BadgersHarness {
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
			int[] hunger              = {1,2,3};
			int[] greed               = {2,2,1};
			int totalFood             = 7;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new Badgers().feedMost(hunger, greed, totalFood));
		}
		case 1: {
			int[] hunger              = {5,2,1,5};
			int[] greed               = {0,2,4,1};
			int totalFood             = 19;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new Badgers().feedMost(hunger, greed, totalFood));
		}
		case 2: {
			int[] hunger              = {1,1,1,1,1};
			int[] greed               = {1000,1000,1000,1000,1000};
			int totalFood             = 10;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new Badgers().feedMost(hunger, greed, totalFood));
		}
		case 3: {
			int[] hunger              = {1,2,3,4,5,6,7,8,9,10};
			int[] greed               = {10,9,8,7,6,5,4,3,2,1};
			int totalFood             = 100;
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new Badgers().feedMost(hunger, greed, totalFood));
		}

		// custom cases

/*      case 4: {
			int[] hunger              = ;
			int[] greed               = ;
			int totalFood             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Badgers().feedMost(hunger, greed, totalFood));
		}*/
/*      case 5: {
			int[] hunger              = ;
			int[] greed               = ;
			int totalFood             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Badgers().feedMost(hunger, greed, totalFood));
		}*/
/*      case 6: {
			int[] hunger              = ;
			int[] greed               = ;
			int totalFood             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Badgers().feedMost(hunger, greed, totalFood));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
