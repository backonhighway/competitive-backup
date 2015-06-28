package tc400s.tc416;
// Paste me into the FileEdit configuration dialog

public class NextNumber {
    public int getNextNumber(int N) {
		
		String str = Integer.toBinaryString(N);
		int len = str.length();
		int index = -1;
		char rightmost = str.charAt(len-1);
		if(rightmost=='1'){
			for(int i=len-1; i>=0; i--){
				if(str.charAt(i) == '0'){
					index = i;
					break;
				}
			}
			if(index == -1){
				str = "10" + str.substring(1); 
			}else{
				str = str.substring(0, index) + "10" + str.substring(index+2);
			}
		}
		else if(rightmost=='0'){
			int index1 = len-1;
			for(int i=len-1; i>=0; i--){
				if(str.charAt(i) == '1'){
					index1 = i;
					break;
				}
			}
			for(int i=index1; i>=0; i--){
				if(str.charAt(i) == '0'){
					index = i;
					break;
				}
			}
			if(index == -1){
				str = "10" + str.substring(1);
				index = 2;
			}else{
				str = str.substring(0, index) + "10" + str.substring(index+2);
				index += 2;
			}
			String sub = str.substring(index);
			int sublen = sub.length();
			int bitcnt = 0;
			for(int i=0; i<sublen; i++){
				if(sub.charAt(i)=='1'){
					bitcnt++;
				}
			}
			str = str.substring(0,index);
			for(int i=0; i<sublen-bitcnt; i++){
				str += "0";
			}
			for(int i=0; i<bitcnt; i++){
				str += "1";
			}
		}

		return Integer.parseInt(str, 2);
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			NextNumberHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				NextNumberHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class NextNumberHarness {
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
			int N                     = 1717;
			int expected__            = 1718;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}
		case 1: {
			int N                     = 4;
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}
		case 2: {
			int N                     = 7;
			int expected__            = 11;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}
		case 3: {
			int N                     = 12;
			int expected__            = 17;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}
		case 4: {
			int N                     = 555555;
			int expected__            = 555557;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}

		// custom cases

      case 5: {
			int N                     = 536870910;
			int expected__            = 671088639;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}
/*      case 6: {
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}*/
/*      case 7: {
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NextNumber().getNextNumber(N));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
