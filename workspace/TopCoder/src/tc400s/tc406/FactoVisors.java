package tc400s.tc406;

// Paste me into the FileEdit configuration dialog

public class FactoVisors {
	int[] divisors;
    public int getNum(int[] divisors, int[] multiples) {
    	
    	this.divisors = divisors.clone();
		
		int gcd = multiples[0];
		if(multiples.length>1){
			for(int i=1; i<multiples.length; i++){
				gcd = gcd(gcd, multiples[i]);
			}
		}
		
		int count = 0;
		for(int i=1; i*i<=gcd; i++){
			if(gcd%i==0){
				if(checkdivisor(i)) count++;
				int d = gcd/i;
				if(i != d){
					if(gcd%d==0 && checkdivisor(d)) count++;
				}
			}
		}
		
		return count;
    }
    
    public boolean checkdivisor(int input){
    	boolean ret = true;
    	for(int i=0; i<divisors.length; i++){
    		if(input%divisors[i] != 0) ret = false;
    	}
    	return ret;
    }
	
	public int gcd(int a, int b){
		return b != 0 ? gcd(b, a % b) : a;
	}


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FactoVisorsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FactoVisorsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FactoVisorsHarness {
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
			int[] divisors            = {1};
			int[] multiples           = {100};
			int expected__            = 9;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}
		case 1: {
			int[] divisors            = {6,9};
			int[] multiples           = {18};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}
		case 2: {
			int[] divisors            = {6,9};
			int[] multiples           = {96,180};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}
		case 3: {
			int[] divisors            = {2,4};
			int[] multiples           = {256};
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}
		case 4: {
			int[] divisors            = {1000,10000,100000};
			int[] multiples           = {1000000000};
			int expected__            = 25;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}

		// custom cases

      case 5: {
			int[] divisors            = {92342009, 646394063, 973, 4650317, 1, 1, 664331, 646394063, 973, 139, 664331, 4650317, 92342009, 139, 646394063, 973, 1, 646394063, 973, 92342009, 139, 1, 7, 7, 139, 139, 4650317, 7, 973, 7, 7, 664331, 4650317, 664331, 139, 664331, 92342009, 7, 973, 646394063};
			int[] multiples           = {646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063, 646394063};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}
/*      case 6: {
			int[] divisors            = ;
			int[] multiples           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}*/
/*      case 7: {
			int[] divisors            = ;
			int[] multiples           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FactoVisors().getNum(divisors, multiples));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
