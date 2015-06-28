package tcSecond;
// Paste me into the FileEdit configuration dialog

public class GearsDiv2 {
    public int getmin(String Directions) {
		int min;
		int cnt = 0;
		int len = Directions.length();
		
		char begin =  Directions.charAt(0);
		char cur = Directions.charAt(0);
		
		for(int i=1; i<len-1; i++){
			if(cur=='Z'){
				cur = Directions.charAt(i);
				continue;
			}
			if(Directions.charAt(i) == cur){
				cur = 'Z';
				cnt++;
			}
			else{
				cur = Directions.charAt(i);
			}
		}
		if(Directions.charAt(len-1)==begin || Directions.charAt(len-1) == cur) cnt++;
		min = cnt;
		
		cnt = 1;
		begin = 'Z';
		cur = 'Z';
		for(int i=1; i<len; i++){
			if(cur=='Z'){
				cur = Directions.charAt(i);
				continue;
			}
			if(Directions.charAt(i) == cur){
				cur = 'Z';
				cnt++;
			}
			else{
				cur = Directions.charAt(i);
			}
		}
		min = Math.min(cnt, min);
		
		return min;
		
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			GearsDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				GearsDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class GearsDiv2Harness {
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
			String Directions         = "LRRR";
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}
		case 1: {
			String Directions         = "RRR";
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}
		case 2: {
			String Directions         = "LRLR";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}
		case 3: {
			String Directions         = "LRLLRRLLLRRRLLLL";
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}
		case 4: {
			String Directions         = "RRRRRRRLRRRRRRRLRLRLLRLRLRLRRLRLRLLLRLRLLRLLRRLRRR";
			int expected__            = 14;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}

		// custom cases

      case 5: {
			String Directions         = "LRLRLL";
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}
/*      case 6: {
			String Directions         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}*/
/*      case 7: {
			String Directions         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new GearsDiv2().getmin(Directions));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
