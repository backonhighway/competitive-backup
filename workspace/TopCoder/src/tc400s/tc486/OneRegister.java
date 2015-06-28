package tc400s.tc486;


// Paste me into the FileEdit configuration dialog
import java.util.*;

public class OneRegister {
	public boolean canMake = false;
	public boolean firstTry = true;
	public int t;
	public List<String> list = new ArrayList<String>();
	public HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
	
   public String getProgram(int s, int t) {
	   this.t = t;
	   String ret ="";
	   if(s==1 && t==1) return "";
	   else if(t==1) return "/";
	   else{
		   dfs(s,"");
		   if(canMake){
			   String[] choose = list.toArray(new String[0]);
			   Arrays.sort(choose, new Comparator<String>(){
				   @Override
				public int compare(String o1, String o2) {
					int temp = o1.length() - o2.length();
					return temp == 0 ? o1.compareTo(o2): temp;
				}
			   });
			   ret = choose[0];
		   }
		   else ret = ":-(";
	   }
	   return ret;
		
   }
   public void dfs(int input, String program){
	   if(input>t && !firstTry) return;
	   else if(visited.containsKey(input) && visited.get(input) <= program.length()) return;
	   else if(input == this.t){
		   canMake = true;
		   list.add(program);
		   return;
	   }
	   visited.put(input, program.length());
	   firstTry=false;
	   boolean overflowed = false;
	   if(input>Math.sqrt(Integer.MAX_VALUE)) overflowed = true;
	   if(!overflowed) dfs(input * input, program + "*");
	   dfs(input + input, program + "+");
	   dfs(1, program + "/");
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			OneRegisterHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				OneRegisterHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class OneRegisterHarness {
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
			int s                     = 7;
			int t                     = 392;
			String expected__         = "+*+";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}
		case 1: {
			int s                     = 7;
			int t                     = 256;
			String expected__         = "/+***";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}
		case 2: {
			int s                     = 4;
			int t                     = 256;
			String expected__         = "**";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}
		case 3: {
			int s                     = 7;
			int t                     = 7;
			String expected__         = "";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}
		case 4: {
			int s                     = 7;
			int t                     = 9;
			String expected__         = ":-(";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}
		case 5: {
			int s                     = 10;
			int t                     = 1;
			String expected__         = "/";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}

		// custom cases

      case 6: {
			int s                     = 1000000000;
			int t                     = 536870912;
			String expected__         = "/+*+*+**+";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}
      case 7: {
			int s                     = 12345678;
			int t                     = 260846532;
			String expected__         = ":-(";

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}
/*      case 8: {
			int s                     = ;
			int t                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new OneRegister().getProgram(s, t));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
