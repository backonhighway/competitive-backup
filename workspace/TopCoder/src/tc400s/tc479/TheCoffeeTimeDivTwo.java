package tc400s.tc479;

import java.util.*;

// Paste me into the FileEdit configuration dialog

public class TheCoffeeTimeDivTwo {
   public int find(int n, int[] tea) {
	   int res = 0;
	   Arrays.sort(tea);
	   int tealen = tea.length;

	   res += tealen*4;
	   while(tealen > 0){
		   res += tea[tealen-1]*2;
		   tealen -= 7;
		   res += 47;
	   }
	   
	   if(tea.length != n){
		   int[] coffee = new int[n-tea.length];
		   List<Integer> tealist = new ArrayList<Integer>();
		   for(int i:tea) tealist.add(i);
		   int coffeecnt = 0;
		   for(int i=1; i<=n; i++){
			   if(!tealist.contains(i)){
				   coffee[coffeecnt] = i;
				   coffeecnt++;
			   }
		   }
		   int coflen = coffee.length;
		   res += coflen*4;
		   while(coflen > 0){
			   res += coffee[coflen-1]*2;
			   coflen -= 7;
			   res += 47;
		   }
	   }
	   
	   return res;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TheCoffeeTimeDivTwoHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TheCoffeeTimeDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TheCoffeeTimeDivTwoHarness {
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
			int n                     = 2;
			int[] tea                 = {1};
			int expected__            = 108;

			return verifyCase(casenum__, expected__, new TheCoffeeTimeDivTwo().find(n, tea));
		}
		case 1: {
			int n                     = 2;
			int[] tea                 = {2, 1};
			int expected__            = 59;

			return verifyCase(casenum__, expected__, new TheCoffeeTimeDivTwo().find(n, tea));
		}
		case 2: {
			int n                     = 15;
			int[] tea                 = {1, 2, 3, 4, 5, 6, 7};
			int expected__            = 261;

			return verifyCase(casenum__, expected__, new TheCoffeeTimeDivTwo().find(n, tea));
		}
		case 3: {
			int n                     = 47;
			int[] tea                 = {1, 10, 6, 2, 4};
			int expected__            = 891;

			return verifyCase(casenum__, expected__, new TheCoffeeTimeDivTwo().find(n, tea));
		}

		// custom cases

/*      case 4: {
			int n                     = ;
			int[] tea                 = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheCoffeeTimeDivTwo().find(n, tea));
		}*/
/*      case 5: {
			int n                     = ;
			int[] tea                 = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheCoffeeTimeDivTwo().find(n, tea));
		}*/
/*      case 6: {
			int n                     = ;
			int[] tea                 = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheCoffeeTimeDivTwo().find(n, tea));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
