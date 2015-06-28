package tc400s.tc473;
// Paste me into the FileEdit configuration dialog

public class SequenceOfCommands {
   public String whatHappens(String[] commands) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int len = commands.length;
		Point pt = new Point(0,0,0);
		
		for(int i=0; i<len; i++){
			int strlen = commands[i].length();
			for(int j=0; j<strlen; j++){
				int ch = commands[i].charAt(j);
				if(ch == 'S'){
					pt.x += dx[pt.dir];
					pt.y += dy[pt.dir];
				}
				else if(ch == 'L'){
					pt.dir = (pt.dir+3)%4;
				}
				else if(ch == 'R'){
					pt.dir = (pt.dir+1)%4;
				}
			}
		}
		int dirx = pt.x;
		int diry = pt.y;
		int dirdir = pt.dir;
		boolean bool = pt.x == 0 && pt.y == 0;

		for(int i=0; i<4; i++){
			switch(pt.dir){
				case 0: pt.x += dirx;
						pt.y += diry;
						break;
				case 1: pt.x += diry;
						pt.y -= dirx;
						break;
				case 2: pt.x -= dirx;
						pt.y -= diry;
						break;
				case 3: pt.x -= diry;
						pt.y += dirx;
						break;
			}
			pt.dir = (pt.dir + dirdir)%4;
			bool = pt.x == 0 && pt.y == 0;
			if(bool) break;
		}
		
		
		return bool ? "bounded" : "unbounded";
   }
   
   class Point{
	   int x;
	   int y;
	   int dir;
	   Point(int x, int y, int dir){
		   this.x = x;
		   this.y = y;
		   this.dir = dir;
	   }
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SequenceOfCommandsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SequenceOfCommandsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SequenceOfCommandsHarness {
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
			String[] commands         = {"L"};
			String expected__         = "bounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}
		case 1: {
			String[] commands         = {"SRSL"};
			String expected__         = "unbounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}
		case 2: {
			String[] commands         = {"SSSS","R"};
			String expected__         = "bounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}
		case 3: {
			String[] commands         = {"SRSL","LLSSSSSSL","SSSSSS","L"};
			String expected__         = "unbounded";

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}

		// custom cases

/*      case 4: {
			String[] commands         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}*/
/*      case 5: {
			String[] commands         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}*/
/*      case 6: {
			String[] commands         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SequenceOfCommands().whatHappens(commands));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
