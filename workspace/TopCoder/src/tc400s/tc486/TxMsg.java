package tc400s.tc486;
import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class TxMsg {
   public String getMessage(String original) {
		String[] splitted = original.split(" ");
		String[] ret = new String[splitted.length];
		Arrays.fill(ret, "");
		
		for(int i=0; i<splitted.length; i++){
			int cnt = 0;
			for(int j=0; j<splitted[i].length(); j++){
				if(!isVowel(splitted[i].charAt(j))) cnt++;
			}
			//!splitted[i].matches("[^aeiou]")
			if(cnt==0)  ret[i] = splitted[i];
			else{
				for(int j=0; j<splitted[i].length(); j++){
					if(j==0){
						if(!isVowel(splitted[i].charAt(j))) ret[i] += splitted[i].charAt(j);
					}
					else{
						if(isVowel(splitted[i].charAt(j-1)) && !isVowel(splitted[i].charAt(j))){
							ret[i] += splitted[i].charAt(j);
						}
					}
				}
			}
		}
		
		String last = "";
		for(int i=0; i<ret.length; i++){
			if(i==ret.length-1) last += ret[i];
			else last += ret[i] + " ";
		}
		return last;
   }
   
   public boolean isVowel(char c){
	   return (c!='a' && c!='e' && c!='i' && c!='o' && c!='u') ? false : true;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TxMsgHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TxMsgHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TxMsgHarness {
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
			String original           = "text message";
			String expected__         = "tx msg";

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}
		case 1: {
			String original           = "ps i love u";
			String expected__         = "p i lv u";

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}
		case 2: {
			String original           = "please please me";
			String expected__         = "ps ps m";

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}
		case 3: {
			String original           = "back to the ussr";
			String expected__         = "bc t t s";

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}
		case 4: {
			String original           = "aeiou bcdfghjklmnpqrstvwxyz";
			String expected__         = "aeiou b";

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}

		// custom cases

/*      case 5: {
			String original           = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}*/
/*      case 6: {
			String original           = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}*/
/*      case 7: {
			String original           = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new TxMsg().getMessage(original));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
