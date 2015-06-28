package tc400s.tc405;
// Paste me into the FileEdit configuration dialog

public class RelativePath {
    public String makeRelative(String path, String currentDir) {
    	if(currentDir.equals("/")) return path.substring(1);
    	
		String[] cur = currentDir.split("/");
		String[] goal = path.split("/");
		int maxlen = Math.min(cur.length, goal.length);
		int samenum = 0;
		for(int i=0; i<maxlen; i++){
			if(cur[i].equals(goal[i])) samenum++;
			else break;
		}
		String ret = "";
		for(int i=0; i<cur.length-samenum; i++){
			ret += "../";
		}
		for(int i=samenum; i<goal.length; i++){
			ret += goal[i] + "/";
		}
		ret = ret.substring(0, ret.length()-1);
		return ret;
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			RelativePathHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RelativePathHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class RelativePathHarness {
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
			String path               = "/home/top/data/file";
			String currentDir         = "/home/user/pictures";
			String expected__         = "../../top/data/file";

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}
		case 1: {
			String path               = "/home/user/movies/title";
			String currentDir         = "/home/user/pictures";
			String expected__         = "../movies/title";

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}
		case 2: {
			String path               = "/file";
			String currentDir         = "/";
			String expected__         = "file";

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}
		case 3: {
			String path               = "/a/b/a/b/a/b";
			String currentDir         = "/a/b/a/a/b/a/b";
			String expected__         = "../../../../b/a/b";

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}
		case 4: {
			String path               = "/root/root/root";
			String currentDir         = "/root";
			String expected__         = "root/root";

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}

		// custom cases

/*      case 5: {
			String path               = ;
			String currentDir         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}*/
/*      case 6: {
			String path               = ;
			String currentDir         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}*/
/*      case 7: {
			String path               = ;
			String currentDir         = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RelativePath().makeRelative(path, currentDir));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
