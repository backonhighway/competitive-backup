package tc400s.tc400;


public class StrongPrimePower {
	public static double EPS = 1e-11;
    public int[] baseAndExponent(String n) {

    	long N = Long.parseLong(n);

		boolean isStrong = false;
		int[] retOK = new int[2];
		int[] retNG = {};
		for(int q=2; q<=59; q++){
			double dp = Math.pow(N, 1.0/q);
			int aboutp = (int)Math.round(dp);
			long pow = 1;
			for(int i=0; i<q; i++){
				pow *= aboutp;
			}
			if(isPrime(aboutp) && pow==N){
				isStrong = true; retOK[0] = aboutp; retOK[1] = q;
			}
		}
		return isStrong ? retOK : retNG;
    }
    
	public boolean isPrime(int n){
		for(int i=2; i*i <= n; i++){
			if(n%i == 0) return false;
		}
		return n != 1; //1 is exception
	}



// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			StrongPrimePowerHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				StrongPrimePowerHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class StrongPrimePowerHarness {
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
	
	static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}
	
	static int verifyCase(int casenum, int[] expected, int[] received) { 
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
			String n                  = "27";
			int[] expected__          = {3, 3 };

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}
		case 1: {
			String n                  = "10";
			int[] expected__          = { };

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}
		case 2: {
			String n                  = "7";
			int[] expected__          = { };

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}
		case 3: {
			String n                  = "1296";
			int[] expected__          = { };

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}
		case 4: {
			String n                  = "576460752303423488";
			int[] expected__          = {2, 59 };

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}
		case 5: {
			String n                  = "999999874000003969";
			int[] expected__          = {999999937, 2 };

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}

		// custom cases

      case 6: {
			String n                  = "828100056420000961";
			int[] expected__          = {910000031, 2};

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}
      case 7: {
			String n                  = "51185893014090757";
			int[] expected__          = {13, 15};

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}
/*      case 8: {
			String n                  = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new StrongPrimePower().baseAndExponent(n));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
