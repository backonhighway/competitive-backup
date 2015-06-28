package tc600s.tc626;
import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class NegativeGraphDiv2 {
	
	static int INF = 100000 * 100;
	
    public long findMin(int N, int[] s, int[] t, int[] weight, int charges) {

    	long[][] dp = new long[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				dp[i][j] = INF;
			}
			dp[i][i] = 0;
		}
		
		for(int i=0; i<s.length; i++){
			int u = s[i] - 1;
			int v = t[i] - 1;
			dp[u][v] = Math.min(dp[u][v], weight[i]);
		}
		
		for(int k=0; k<N; k++){
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		long[][] dist = new long[charges+1][N];
		for(int i=0; i<N; i++){
			dist[charges][i] = dp[i][N-1];
		}
		
		for(int c=charges-1; c>=0; c--){
			for(int i=0; i<N; i++){
				dist[c][i] = dist[c+1][i];
				for(int j=0; j<s.length; j++){
					int u = s[j] - 1;
					int v = t[j] - 1;
					int w = -weight[j];
					dist[c][i] = Math.min(dist[c][i], dp[i][u] + w + dist[c+1][v]);
				}
			}
		}

		return dist[0][0];
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			NegativeGraphDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				NegativeGraphDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class NegativeGraphDiv2Harness {
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
	
	static boolean compareOutput(long expected, long result) { return expected == result; }
	static String formatResult(long res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, long expected, long received) { 
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
			int N                     = 3;
			int[] s                   = {1,1,2,2,3,3};
			int[] t                   = {2,3,1,3,1,2};
			int[] weight              = {1,5,1,10,1,1};
			int charges               = 1;
			long expected__           = -9;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}
		case 1: {
			int N                     = 1;
			int[] s                   = {1};
			int[] t                   = {1};
			int[] weight              = {100};
			int charges               = 1000;
			long expected__           = -100000;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}
		case 2: {
			int N                     = 2;
			int[] s                   = {1,1,2};
			int[] t                   = {2,2,1};
			int[] weight              = {6,1,4};
			int charges               = 2;
			long expected__           = -9;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}
		case 3: {
			int N                     = 2;
			int[] s                   = {1};
			int[] t                   = {2};
			int[] weight              = {98765};
			int charges               = 100;
			long expected__           = -98765;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}

		// custom cases

/*      case 4: {
			int N                     = ;
			int[] s                   = ;
			int[] t                   = ;
			int[] weight              = ;
			int charges               = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}*/
/*      case 5: {
			int N                     = ;
			int[] s                   = ;
			int[] t                   = ;
			int[] weight              = ;
			int charges               = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}*/
/*      case 6: {
			int N                     = ;
			int[] s                   = ;
			int[] t                   = ;
			int[] weight              = ;
			int charges               = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new NegativeGraphDiv2().findMin(N, s, t, weight, charges));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
