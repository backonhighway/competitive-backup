package tc400s.tc477;

import java.util.Arrays;
// Paste me into the FileEdit configuration dialog

public class Islands {
   public int beachLength(String[] kingdom) {
	   int res = 0;
	   
	   String[] banpei = new String[kingdom.length+2];
	   Arrays.fill(banpei, "");
	   for(int i=0; i<kingdom[0].length()+2; i++){
		   banpei[0] += "X";
		   banpei[banpei.length-1] += "X";
	   }
	   for(int i=1; i<banpei.length-1; i++){
		   banpei[i] += "X" + kingdom[i-1] + "X";
	   }
	   
	   for(int i=1; i<banpei.length-1; i++){
		   for(int j=1; j<banpei[i].length()-1; j++){
			   int shift = i%2;
			   if(banpei[i].charAt(j) == '#'){
				   if(banpei[i-1].charAt(j-shift)=='.') res++;
				   if(banpei[i-1].charAt(j-shift+1)=='.') res++;
				   if(banpei[i].charAt(j-1)=='.') res++;
				   if(banpei[i].charAt(j+1)=='.') res++;
				   if(banpei[i+1].charAt(j-shift)=='.') res++;
				   if(banpei[i+1].charAt(j-shift+1)=='.') res++;
			   }
		   }
	   }
	   return res;

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			IslandsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				IslandsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class IslandsHarness {
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
			String[] kingdom          = {".#...#.."};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}
		case 1: {
			String[] kingdom          = {"..#.##", 
 ".##.#.", 
 "#.#..."};
			int expected__            = 19;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}
		case 2: {
			String[] kingdom          = {"#...#.....",
 "##..#...#."};
			int expected__            = 15;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}
		case 3: {
			String[] kingdom          = {"....#.",
 ".#....",
 "..#..#",
 "####.."};
			int expected__            = 24;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}

		// custom cases

/*      case 4: {
			String[] kingdom          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}*/
/*      case 5: {
			String[] kingdom          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}*/
/*      case 6: {
			String[] kingdom          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
