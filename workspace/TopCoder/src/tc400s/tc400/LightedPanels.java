package tc400s.tc400;
import java.util.*;

// Paste me into the FileEdit configuration dialog

public class LightedPanels {
	
	int[][] newBoard;
	int[][] flipBoard;
    public int minTouch(String[] board) {
    	int width = board[0].length();
    	int height = board.length;
    	int ret = 100000;
		for(int subset = 0; subset<(1<<width+height-1); subset++){
			int[][] newBoard = new int[height+2][width+2];
			int[][] flipBoard = new int[height+2][width+2];
			for(int i=0; i<height; i++)
				for(int j=0; j<width; j++){
					if(board[i].charAt(j)=='*') newBoard[i+1][j+1] = 1;
					if(board[i].charAt(j)=='.') newBoard[i+1][j+1] = 2;
				}
			
			this.newBoard = newBoard;
			this.flipBoard = flipBoard;
			
			for(int i=0; i<width+height-1; i++){
				if( (subset & 1<<i) != 0){
					if(i<width) flip(1, i+1);
					else flip(i-width+2, 1);
				}
			}
			
			for(int i=1; i<height; i++)
				for(int j=1; j<width; j++){
					if(newBoard[i][j] == 2) flip(i+1, j+1);
				}

			boolean canFlip = true;
			int flipCount = 0;
			for(int i=1; i<=height; i++)
				for(int j=1; j<=width; j++){
					if(newBoard[i][j] == 2) canFlip = false;
					if(flipBoard[i][j] == 1) flipCount++;
				}
			
			if(canFlip) ret = Math.min(ret, flipCount);
		}
		
		return ret == 100000 ? -1 : ret;
    }
    
    public void flip(int y, int x){
    	flipBoard[y][x] = 1;
    	for(int i=-1; i<=1; i++){
    		for(int j=-1; j<=1; j++){
    			newBoard[y+i][x+j] = 3 - newBoard[y+i][x+j];
    		}
    	}
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			LightedPanelsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				LightedPanelsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class LightedPanelsHarness {
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
			String[] board            = {"*****",
 "*...*",
 "*...*",
 "*...*",
 "*****"};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new LightedPanels().minTouch(board));
		}
		case 1: {
			String[] board            = {".*"};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new LightedPanels().minTouch(board));
		}
		case 2: {
			String[] board            = {"**.",
 "**.",
 "..."};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new LightedPanels().minTouch(board));
		}
		case 3: {
			String[] board            = {"*...",
 "**..",
 "..**",
 "...*"};
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new LightedPanels().minTouch(board));
		}

		// custom cases

      case 4: {
			String[] board            = {"****", "*..*", ".***", "...*"};
			int expected__            = 15;

			return verifyCase(casenum__, expected__, new LightedPanels().minTouch(board));
		}
/*      case 5: {
			String[] board            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LightedPanels().minTouch(board));
		}*/
/*      case 6: {
			String[] board            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LightedPanels().minTouch(board));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
