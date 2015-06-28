package tc400s.tc470;
// Paste me into the FileEdit configuration dialog

import java.util.*;

public class DoorsGame {
   public int determineOutcome(String doors, int trophy) {
	   int len = doors.length();
	   int[] john = new int[16];
	   int[] gogo = new int[16];
	   int johnColor = 0;
	   int gogoColor = 0;
	   Arrays.fill(john, 0);
	   Arrays.fill(gogo, 0);
	   
	   for(int i=0; i<trophy; i++){
		   if(john[doors.charAt(i)-'A'] != 1){
			   john[doors.charAt(i)-'A'] = 1;
			   johnColor++;
		   }
	   }
	   for(int j=len-1; j>=trophy; j--){
		   if(gogo[doors.charAt(j)-'A'] != 1){
			   gogo[doors.charAt(j)-'A'] = 1;
			   gogoColor++;
		   }
	   }
	   int sameColor = 0;
	   for(int i=0; i<16; i++){
		   if(john[i]==1 && gogo[i]==1){
			   sameColor++;
		   }
	   }
	   
	   int ret;
	   if(johnColor +sameColor <= gogoColor){
		   ret = johnColor*2 - 1;
	   }
	   else if(johnColor > gogoColor + sameColor){
		   ret = -(gogoColor*2);
	   }
	   else{
		   ret = 0;
	   }
	   return ret;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			DoorsGameHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				DoorsGameHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class DoorsGameHarness {
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
			String doors              = "ABCD";
			int trophy                = 2;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 1: {
			String doors              = "ABCC";
			int trophy                = 2;
			int expected__            = -2;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 2: {
			String doors              = "ABABAB";
			int trophy                = 3;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 3: {
			String doors              = "ABAPDCAA";
			int trophy                = 5;
			int expected__            = -4;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 4: {
			String doors              = "MOCFDCE";
			int trophy                = 3;
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 5: {
			String doors              = "ABCCDE";
			int trophy                = 3;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}
		case 6: {
			String doors              = "ABCCD";
			int trophy                = 3;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}

		// custom cases

/*      case 7: {
			String doors              = ;
			int trophy                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}*/
/*      case 8: {
			String doors              = ;
			int trophy                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}*/
/*      case 9: {
			String doors              = ;
			int trophy                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DoorsGame().determineOutcome(doors, trophy));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
