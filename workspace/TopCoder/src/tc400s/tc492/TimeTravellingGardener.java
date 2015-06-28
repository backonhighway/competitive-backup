package tc400s.tc492;
// Paste me into the FileEdit configuration dialog

public class TimeTravellingGardener {
	
   public final double EPS = 1e-11;
   public int determineUsage(int[] distance, int[] height) {
	   
	   int treelen = height.length;
	   int minchange = height.length-1;
	   int[] dist = new int[treelen];
	   dist[0] = 0;
	   for(int i=1; i<treelen; i++){
		   dist[i] = dist[i-1] + distance[i-1];
	   }
	   
	   for(int begin=0; begin<treelen; begin++){
		   for(int end=begin+1; end<treelen; end++){
			   int x = dist[end] - dist[begin];
			   int y = height[end] - height[begin];
			   double slope = (double)y / (double)x;
			   
			   int changecnt = 0;
			   boolean valid = true;
			   for(int i=0; i<treelen; i++){
				   if(i == begin) continue;

				   int ay = height[i];
				   
				   double propery = (dist[i]-dist[begin]) * slope + height[begin];
				   if(Math.abs(propery-ay) < EPS) continue;
				   else if(propery > ay || propery < -EPS){
					   valid = false;
					   break;
				   }
				   else if(propery < ay){
					   changecnt++;
				   }
			   }
			   if(valid) minchange = Math.min(minchange, changecnt);
		   }
	   }
	   return minchange;
	   
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TimeTravellingGardenerHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TimeTravellingGardenerHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TimeTravellingGardenerHarness {
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
			int[] distance            = {2,2};
			int[] height              = {1,3,10};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}
		case 1: {
			int[] distance            = {3,3};
			int[] height              = {3,1,3};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}
		case 2: {
			int[] distance            = {1,3};
			int[] height              = {4,4,4};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}
		case 3: {
			int[] distance            = {4,2};
			int[] height              = {9,8,5};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}
		case 4: {
			int[] distance            = {476,465,260,484};
			int[] height              = {39,13,8,72,80};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}
		case 5: {
			int[] distance            = {173,36,668,79,26,544};
			int[] height              = {488,743,203,446,444,91,453};
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}
		case 6: {
			int[] distance            = {2,4,2,2,4,2,4,2,2,4};
			int[] height              = {2,2,10,10,10,16,16,22,22,28,28};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}

		// custom cases

/*      case 7: {
			int[] distance            = ;
			int[] height              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}*/
/*      case 8: {
			int[] distance            = ;
			int[] height              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}*/
/*      case 9: {
			int[] distance            = ;
			int[] height              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TimeTravellingGardener().determineUsage(distance, height));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
