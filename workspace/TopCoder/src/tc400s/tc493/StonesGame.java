package tc400s.tc493;
// Paste me into the FileEdit configuration dialog

public class StonesGame {
	int leftpos;
	int rightpos;
   public String winner(int N, int M, int K, int L) {//N=all,M=curpos,K=flipnum,L=goal
	   long begintime = System.currentTimeMillis();
	   boolean firstwin = canWin(N,M,K,L);
	   boolean secondcantwin = false;
		
	   for(int i=1; i<=N; i++){
		   if(canWin(N,M,K,i) && !canWin(N,i,K,L)){
			   secondcantwin = true;
			   break;
		   }
	   }
		
		String ret;
		if(firstwin) ret = "Romeo";
		else if(secondcantwin) ret = "Draw";
		else ret = "Strangelet";
		
		long endtime = System.currentTimeMillis();
		System.out.println(endtime-begintime);
		return ret;
		
		
   }
   public int move(int left, int right, int curpos){
	   int dist = Math.min(curpos-left, right-curpos);
	   return (left + dist == curpos) ? right - dist : left + dist;
   }
   
   public boolean canWin(int N, int M, int K, int L){
	   boolean canwin = false;
		int right = Math.min(N,  M + K -1);
		int rightpos = move(right-K+1, right, M);
		int left = Math.max(1,  M - K + 1);
		int leftpos = move(left, left+K-1, M);
		this.rightpos = rightpos;
		this.leftpos = leftpos;
		
		if(K%2==0){
			if(leftpos<=L && L<=rightpos && Math.abs((L-M)%2)==1) canwin = true;
		}
		else{
			if(leftpos<=L && L<=rightpos && Math.abs((L-M)%2)==0) canwin = true;
		}
		return canwin;
   }



// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			StonesGameHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				StonesGameHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class StonesGameHarness {
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
			int N                     = 3;
			int M                     = 1;
			int K                     = 1;
			int L                     = 2;
			String expected__         = "Draw";

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}
		case 1: {
			int N                     = 5;
			int M                     = 1;
			int K                     = 2;
			int L                     = 2;
			String expected__         = "Romeo";

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}
		case 2: {
			int N                     = 5;
			int M                     = 5;
			int K                     = 2;
			int L                     = 3;
			String expected__         = "Strangelet";

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}
		case 3: {
			int N                     = 5;
			int M                     = 5;
			int K                     = 2;
			int L                     = 2;
			String expected__         = "Draw";

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}
		case 4: {
			int N                     = 1000000;
			int M                     = 804588;
			int K                     = 705444;
			int L                     = 292263;
			String expected__         = "Romeo";

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}
		case 5: {
			int N                     = 1000000;
			int M                     = 100000;
			int K                     = 500000;
			int L                     = 600000;
			String expected__         = "Strangelet";

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}

		// custom cases

      case 6: {
			int N                     = 3;
			int M                     = 1;
			int K                     = 3;
			int L                     = 2;
			String expected__         = "Draw";

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}
/*      case 7: {
			int N                     = ;
			int M                     = ;
			int K                     = ;
			int L                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}*/
/*      case 8: {
			int N                     = ;
			int M                     = ;
			int K                     = ;
			int L                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new StonesGame().winner(N, M, K, L));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
