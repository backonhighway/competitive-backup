package tc400s.tc415;
// Paste me into the FileEdit configuration dialog

public class ThreePhotos {
	
    public int removeCubes(String[] A, String[] B, String[] C) {
    	int N = A.length;
		boolean[][][] noCube = new boolean[N][N][N];
		int cnt = 0;

    	for(int i=0; i<N; i++){
    		for(int j=0; j<N; j++){
    			if(A[i].charAt(j) == 'N'){
    				for(int z=0; z<N; z++){
    					if(noCube[i][j][z] == false){
    						cnt++;
    						noCube[i][j][z] = true;
    					}
    				}
    			}
    			if(B[i].charAt(j) == 'N'){
    				for(int z=0; z<N; z++){
    					if(noCube[i][z][j] == false){
    						cnt++;
    						noCube[i][z][j] = true;
    					}
    				}
    			}
    			if(C[i].charAt(j) == 'N'){
    				for(int z=0; z<N; z++){
    					if(noCube[z][i][j] == false){
    						cnt++;
    						noCube[z][i][j] = true;
    					}
    				}
    			}
    		}
    	}
    	
    	boolean can = true;
    	for(int i=0; i<N; i++){
    		for(int j=0; j<N; j++){
    			if(A[i].charAt(j) == 'Y'){
    				boolean anycube = false;;
    				for(int z=0; z<N; z++){
    					if(noCube[i][j][z] == false){
    						anycube = true;
    					}
    				}
    				if(!anycube) can = false;
    			}
    			if(B[i].charAt(j) == 'Y'){
    				boolean anycube = false;;
    				for(int z=0; z<N; z++){
    					if(noCube[i][z][j] == false){
    						anycube = true;
    					}
    				}
    				if(!anycube) can = false;
    			}
    			if(C[i].charAt(j) == 'Y'){
    				boolean anycube = false;;
    				for(int z=0; z<N; z++){
    					if(noCube[z][i][j] == false){
    						anycube = true;
    					}
    				}
    				if(!anycube) can = false;
    			}
    		}
    	}
		
		return can ? cnt : -1;
    }
    


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ThreePhotosHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ThreePhotosHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ThreePhotosHarness {
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
			String[] A                = {"YY","YY"};
			String[] B                = {"YY","YY"};
			String[] C                = {"YY","YY"};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ThreePhotos().removeCubes(A, B, C));
		}
		case 1: {
			String[] A                = {"NNN","NNN","NNN"};
			String[] B                = {"NNN","NNN","NNN"};
			String[] C                = {"NNN","NNN","NNN"};
			int expected__            = 27;

			return verifyCase(casenum__, expected__, new ThreePhotos().removeCubes(A, B, C));
		}
		case 2: {
			String[] A                = {"NNNNN","NNNNN","NNNNN","YYNNN","NNNNN"};
			String[] B                = {"NNNNN","NNNNN","NNNNN","NNYNY","NNNNN"};
			String[] C                = {"NNYNN","NNNNY","NNNNN","NNNNN","NNNNN"};
			int expected__            = 123;

			return verifyCase(casenum__, expected__, new ThreePhotos().removeCubes(A, B, C));
		}
		case 3: {
			String[] A                = {"YY","YY"};
			String[] B                = {"YY","YY"};
			String[] C                = {"YN","YN"};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new ThreePhotos().removeCubes(A, B, C));
		}

		// custom cases

/*      case 4: {
			String[] A                = ;
			String[] B                = ;
			String[] C                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ThreePhotos().removeCubes(A, B, C));
		}*/
/*      case 5: {
			String[] A                = ;
			String[] B                = ;
			String[] C                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ThreePhotos().removeCubes(A, B, C));
		}*/
/*      case 6: {
			String[] A                = ;
			String[] B                = ;
			String[] C                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ThreePhotos().removeCubes(A, B, C));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
