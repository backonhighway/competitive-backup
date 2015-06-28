package tc400s.tc403;
// Paste me into the FileEdit configuration dialog

public class TheLuckyNumbers {
    public int count(int a, int b) {
    	return count(b) - count(a-1);
    }
    
    public int count(int x){
    	if(x==0) return 0;
		int digit = retDigit(x);
		int cnt = 0;
		for(int i=1; i<digit; i++){
			cnt += Math.pow(2, i);
		}
		for(int i=0; i<(1<<digit); i++){
			int num = 0;
			for(int j=digit-1; j>=0; j--){
				if( (i & (1<<j)) != 0){
					num = num*10 + 7;
				}else{
					num = num*10 + 4;
				}
			}
			if(num>x){
				break;
			}
			cnt++;
		}
		return cnt;
    }
    
    public int retDigit(int x){//0=0
    	int cnt = 0;
    	while(x>0){
    		x = x/10;
    		cnt++;
    	}
    	return cnt;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TheLuckyNumbersHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TheLuckyNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TheLuckyNumbersHarness {
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
			int a                     = 1;
			int b                     = 10;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new TheLuckyNumbers().count(a, b));
		}
		case 1: {
			int a                     = 11;
			int b                     = 20;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new TheLuckyNumbers().count(a, b));
		}
		case 2: {
			int a                     = 74;
			int b                     = 77;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new TheLuckyNumbers().count(a, b));
		}
		case 3: {
			int a                     = 1000000;
			int b                     = 5000000;
			int expected__            = 64;

			return verifyCase(casenum__, expected__, new TheLuckyNumbers().count(a, b));
		}

		// custom cases

/*      case 4: {
			int a                     = ;
			int b                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheLuckyNumbers().count(a, b));
		}*/
/*      case 5: {
			int a                     = ;
			int b                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheLuckyNumbers().count(a, b));
		}*/
/*      case 6: {
			int a                     = ;
			int b                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TheLuckyNumbers().count(a, b));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
