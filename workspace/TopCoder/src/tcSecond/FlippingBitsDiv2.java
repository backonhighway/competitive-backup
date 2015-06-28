package tcSecond;
// Paste me into the FileEdit configuration dialog

public class FlippingBitsDiv2 {
    public int getmin(String[] S, int M) {
		String big = "";
		for(int i=0; i<S.length; i++) big+=S[i];
		int min = 0;
		int len = big.length();
		int zerocnt = 0;
		int onecnt = 0;
		int k = 1;
		do{
			for(int i=(k-1)*M; i<k*M; i++){
				if(big.charAt(i)=='0') zerocnt++;
				if(big.charAt(i)=='1') onecnt++;
			}
			k++;
		}while(zerocnt>onecnt);
		int memo = (k-2)*M;
		min += onecnt;
		String begin = "";
		for(int i=0; i<memo; i++){
			if(big.charAt(i)=='0') begin +='1';
			if(big.charAt(i)=='1') begin +='0';
		}
		zerocnt = 0;
		onecnt = 0;
		k = 1;
		do{
			for(int i=len-1-(k-1)*M; i>len-1-k*M; i--){
				if(begin.charAt(i)=='0') zerocnt++;
				if(begin.charAt(i)=='1') onecnt++;
			}
			k++;
		}while(zerocnt>onecnt);
		
		min+=zerocnt;
		return min;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FlippingBitsDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FlippingBitsDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FlippingBitsDiv2Harness {
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
			String[] S                = {"00111000"};
			int M                     = 1;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}
		case 1: {
			String[] S                = {"00111000"};
			int M                     = 2;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}
		case 2: {
			String[] S                = {"111111"};
			int M                     = 3;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}
		case 3: {
			String[] S                = {"00100"};
			int M                     = 5;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}
		case 4: {
			String[] S                = {"00010","11010110","1010111","110001010","0110001100"
,"000110110","011010101","00","111","100"}
;
			int M                     = 13;
			int expected__            = 31;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}

		// custom cases

/*      case 5: {
			String[] S                = ;
			int M                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}*/
/*      case 6: {
			String[] S                = ;
			int M                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}*/
/*      case 7: {
			String[] S                = ;
			int M                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FlippingBitsDiv2().getmin(S, M));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
