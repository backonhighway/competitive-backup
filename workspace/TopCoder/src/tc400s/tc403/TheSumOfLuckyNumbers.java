package tc400s.tc403;
// Paste me into the FileEdit configuration dialog
import java.util.*;

public class TheSumOfLuckyNumbers {
	
	int[] memo;
	int[] path;
    List<Integer> luckylist = new ArrayList<Integer>();
    final int INF = 10000000;
    
	public int[] sum(int n) {
		memo = new int[n+1];
		path = new int[n+1];
		Arrays.fill(memo,INF);
		Arrays.fill(path,INF);
		
		for(int digit=1; digit<=7; digit++){
			for(int i=0; i<(1<<digit); i++){
				int num = 0;
				for(int j=digit-1; j>=0; j--){
					if( (i & (1<<j)) != 0){
						num = num*10 + 7;
					}else{
						num = num*10 + 4;
					}
				}
				if(num>n){
					break;
				}
				luckylist.add(num);
				memo[num] = 1;
			}
		}
		for(int i=1; i<=n; i++){
			if(memo[i] < INF){
				for(int j : luckylist){
					int move = memo[i] + 1;
					if(i+j <= n && move <= memo[i+j]){
						if(i+j==451) System.out.println(path[i+j]);
						memo[i+j] = move;
						path[i+j] = j;
					}
				}
			}
		}
		int[] ret;
		List<Integer> list = new ArrayList<Integer>();
		if(memo[n] != INF){
			int index = n;
			while(path[index] != INF){
				list.add(path[index]);
				index = index - path[index];
			}
			list.add(index);
		}
		ret = new int[list.size()];
		int i = 0;
		for(Integer e : list) ret[i++] = e.intValue();
		
		return memo[n]<INF ? ret : new int[]{};
		
    }
	

	



// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TheSumOfLuckyNumbersHarness.run_test(-1);
		} else {
			for (int i=1; i<args.length; ++i)
				TheSumOfLuckyNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TheSumOfLuckyNumbersHarness {
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
			int n                     = 11;
			int[] expected__          = {4, 7 };

			return verifyCase(casenum__, expected__, new TheSumOfLuckyNumbers().sum(n));
		}
		case 1: {
			int n                     = 12;
			int[] expected__          = {4, 4, 4 };

			return verifyCase(casenum__, expected__, new TheSumOfLuckyNumbers().sum(n));
		}
		case 2: {
			int n                     = 13;
			int[] expected__          = { };

			return verifyCase(casenum__, expected__, new TheSumOfLuckyNumbers().sum(n));
		}
		case 3: {
			int n                     = 100;
			int[] expected__          = {4, 4, 4, 44, 44 };

			return verifyCase(casenum__, expected__, new TheSumOfLuckyNumbers().sum(n));
		}

		// custom cases

//      case 4: {
//			int n                     = 1000000;
//			int[] expected__          = { 4, 4, 44444, 477774, 477774 };
//
//			return verifyCase(casenum__, expected__, new TheSumOfLuckyNumbers().sum(n));
//		}
      case 5: {
			int n                     = 895;
			int[] expected__          = {4, 444, 447};

			return verifyCase(casenum__, expected__, new TheSumOfLuckyNumbers().sum(n));
		}
/*      case 6: {
			int n                     = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new TheSumOfLuckyNumbers().sum(n));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
