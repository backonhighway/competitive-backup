package tc400s.tc481;
// Paste me into the FileEdit configuration dialog

public class ChickenOracle {
   public String theTruth(int n, int eggCount, int lieCount, int liarCount) {
	   //chickentest
	   boolean chickentrue = false;
	   int saidChicken = n - lieCount;
	   int saidEgg = lieCount;
	   for(int i=0; i<=liarCount; i++){//i==number of people told egg lying
		   if(i>saidEgg || liarCount-i>saidChicken) continue;
		   if(eggCount == saidEgg - i + liarCount - i
				   && n-eggCount == saidChicken + i -(liarCount-i)){
			   chickentrue = true;
		   }
	   }
	   
	   //eggtest
	   boolean eggtrue = false;
	   saidEgg = n - lieCount;
	   saidChicken = lieCount;
	   for(int i=0; i<=liarCount; i++){//i==number of people told egg lying
		   if(i>saidEgg || liarCount-i>saidChicken) continue;
		   if(eggCount == saidEgg - i + liarCount - i
				   && n-eggCount == saidChicken + i - (liarCount - i)){
			   eggtrue = true;
		   }
	   }
	   
	   if(eggtrue && chickentrue) return "Ambiguous";
	   else if(eggtrue) return "The egg";
	   else if(chickentrue) return "The chicken";
	   else return "The oracle is a lie";
	   
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ChickenOracleHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ChickenOracleHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ChickenOracleHarness {
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
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}
	
	static int verifyCase(int casenum, String expected, String received) { 
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
			int n                     = 10;
			int eggCount              = 10;
			int lieCount              = 0;
			int liarCount             = 0;
			String expected__         = "The egg";

			return verifyCase(casenum__, expected__, new ChickenOracle().theTruth(n, eggCount, lieCount, liarCount));
		}
		case 1: {
			int n                     = 60;
			int eggCount              = 40;
			int lieCount              = 0;
			int liarCount             = 30;
			String expected__         = "The oracle is a lie";

			return verifyCase(casenum__, expected__, new ChickenOracle().theTruth(n, eggCount, lieCount, liarCount));
		}
		case 2: {
			int n                     = 60;
			int eggCount              = 20;
			int lieCount              = 5;
			int liarCount             = 25;
			String expected__         = "The chicken";

			return verifyCase(casenum__, expected__, new ChickenOracle().theTruth(n, eggCount, lieCount, liarCount));
		}
		case 3: {
			int n                     = 1000;
			int eggCount              = 500;
			int lieCount              = 250;
			int liarCount             = 250;
			String expected__         = "Ambiguous";

			return verifyCase(casenum__, expected__, new ChickenOracle().theTruth(n, eggCount, lieCount, liarCount));
		}

		// custom cases

/*      case 4: {
			int n                     = ;
			int eggCount              = ;
			int lieCount              = ;
			int liarCount             = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ChickenOracle().theTruth(n, eggCount, lieCount, liarCount));
		}*/
/*      case 5: {
			int n                     = ;
			int eggCount              = ;
			int lieCount              = ;
			int liarCount             = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ChickenOracle().theTruth(n, eggCount, lieCount, liarCount));
		}*/
/*      case 6: {
			int n                     = ;
			int eggCount              = ;
			int lieCount              = ;
			int liarCount             = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ChickenOracle().theTruth(n, eggCount, lieCount, liarCount));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
