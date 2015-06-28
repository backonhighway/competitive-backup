package tc400s.tc414;
// Paste me into the FileEdit configuration dialog

public class Embassy {
	
	final int INF = 1000000000;
	
    public int visaApplication(int[] forms, int dayLength, int openTime) {
    	
    	int ans = INF;
    	
		for(int i=0; i<forms.length; i++){
			
			int ians = 0;
			int curtime = 0;
			
			for(int j=i+1; j<forms.length; j++){//after i-th
				ians += forms[j];
				curtime = (curtime + forms[j]) % dayLength;
				if(curtime > openTime){ //if embassy is shut
					ians += dayLength - curtime;
					curtime = 0;
				}
			}
			
			curtime = 0;
			for(int j=i; j>=0; j--){//before i-th
				if(curtime > openTime){
					ians += curtime - openTime;
					curtime = openTime;
				}
				ians += forms[j];
				curtime = (curtime - forms[j]) % dayLength;
				if(curtime < 0) curtime += dayLength; //if minus
			}
			ans = Math.min(ans, ians);
		}
		
		return ans;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			EmbassyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				EmbassyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class EmbassyHarness {
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
			int[] forms               = {4,4,4};
			int dayLength             = 24;
			int openTime              = 8;
			int expected__            = 12;

			return verifyCase(casenum__, expected__, new Embassy().visaApplication(forms, dayLength, openTime));
		}
		case 1: {
			int[] forms               = {4,4,4,4};
			int dayLength             = 24;
			int openTime              = 8;
			int expected__            = 28;

			return verifyCase(casenum__, expected__, new Embassy().visaApplication(forms, dayLength, openTime));
		}
		case 2: {
			int[] forms               = {2,2,2,2};
			int dayLength             = 24;
			int openTime              = 1;
			int expected__            = 73;

			return verifyCase(casenum__, expected__, new Embassy().visaApplication(forms, dayLength, openTime));
		}
		case 3: {
			int[] forms               = {25,500,630,2500,1000,350,22,58,100,400,500,5000};
			int dayLength             = 1440;
			int openTime              = 360;
			int expected__            = 16945;

			return verifyCase(casenum__, expected__, new Embassy().visaApplication(forms, dayLength, openTime));
		}

		// custom cases

/*      case 4: {
			int[] forms               = ;
			int dayLength             = ;
			int openTime              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Embassy().visaApplication(forms, dayLength, openTime));
		}*/
/*      case 5: {
			int[] forms               = ;
			int dayLength             = ;
			int openTime              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Embassy().visaApplication(forms, dayLength, openTime));
		}*/
/*      case 6: {
			int[] forms               = ;
			int dayLength             = ;
			int openTime              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Embassy().visaApplication(forms, dayLength, openTime));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
