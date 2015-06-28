package bugged;
import java.util.Arrays;



// Paste me into the FileEdit configuration dialog

public class RotatingBot {
    public int minArea(int[] moves) {
		boolean[][] field = new boolean[250][250];
		field[100][100] = true;
		int posX = 0;
		int posY = 0;
		int maxX = 0;
		int minX = 0;
		int maxY = 0;
		int minY = 0;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int dir = 0;
		int len = moves.length;
		
		for(int i=0; i<len; i++){
			for(int j=0; j<moves[i]; j++){
				posX += dx[dir];
				posY += dy[dir];
				if(field[posY+100][posX+100] == true){
					return -1;
				}
				field[posY+100][posX+100] = true;
			}
			dir = (dir+1) % 4;
			maxX = Math.max(maxX, posX);
			maxY = Math.max(maxY, posY);
			minX = Math.min(minX, posX);
			minY = Math.min(minY, posY);
		}
		
		posX = 0;
		posY = 0;
		dir = 0;
		for(int i=0; i<250; i++){
			Arrays.fill(field[i], false);
		}
		field[100][100]= true;
		for(int i=0; i<len; i++){
			for(int j=0; j<moves[i]; j++){
				posX += dx[dir];
				posY += dy[dir];
				field[posY+100][posX+100] = true;
			}
			if(i==len-1) break;
			
			int nx = posX + dx[dir];
			int ny = posY + dy[dir];
			if(minX <= nx && nx <= maxX && minY <= ny && ny <= maxY
					&& field[ny+100][nx+100] != true){
				return -1;
			}
			dir = (dir+1) % 4;
		}
		
		return (maxX - minX + 1) * (maxY - minY + 1);
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			RotatingBotHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RotatingBotHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class RotatingBotHarness {
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
			int[] moves               = {15};
			int expected__            = 16;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
		case 1: {
			int[] moves               = {3,10};
			int expected__            = 44;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
		case 2: {
			int[] moves               = {1,1,1,1};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
		case 3: {
			int[] moves               = {9,5,11,10,11,4,10};
			int expected__            = 132;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
		case 4: {
			int[] moves               = {12,1,27,14,27,12,26,11,25,10,24,9,23,8,22,7,21,6,20,5,19,4,18,3,17,2,16,1,15};
			int expected__            = 420;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
		case 5: {
			int[] moves               = {8,6,6,1};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
		case 6: {
			int[] moves               = {8,6,6};
			int expected__            = 63;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
		case 7: {
			int[] moves               = {5,4,5,3,3};
			int expected__            = 30;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}

		// custom cases

        case 8: {
			int[] moves               = {4,3,5,4,6,1};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}
/*      case 9: {
			int[] moves               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}*/
/*      case 10: {
			int[] moves               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new RotatingBot().minArea(moves));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
