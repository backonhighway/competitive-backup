package tc400s.tc402;
// Paste me into the FileEdit configuration dialog
import java.util.*;

public class RandomSort {
	HashMap<String,Double> expected;
	
    public double getExpected(int[] permutation) {
		int len = permutation.length;
		HashMap<String, Double> expected = new HashMap<String, Double>();
		this.expected = expected;
		
		String input = "";
		for(int i=0; i<len; i++){
			input += String.valueOf(permutation[i]);
		}
		double ans = rec(input);
		
		return ans;
    }
    
    public double rec(String input){
    	if(expected.containsKey(input)){
    		return expected.get(input);
    	}
    	
    	double sum = 0;
    	int len = input.length();
    	int cntPossible= 0;
    	for(int i=0; i<len-1; i++){
    		for(int j=i+1; j<len; j++){
    			if(input.charAt(i)<input.charAt(j)) continue;
    			cntPossible++;
    			String next = swap(input, i, j);
    			sum += rec(next) + 1;
    		}
    	}
    	if(cntPossible==0){
    		expected.put(input, 0.0);
    		return 0;
    	}else{
    		expected.put(input, sum/(double)cntPossible);
    		return sum/(double)cntPossible;
    	}
    }
    
    public String swap(String input, int a, int b){
    	char[] ch = input.toCharArray();
    	char temp = ch[a];
    	ch[a] = ch[b];
    	ch[b] = temp;
    	return String.valueOf(ch);
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			RandomSortHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RandomSortHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class RandomSortHarness {
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
	
	static final double MAX_DOUBLE_ERROR = 1E-9;
	static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
	static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }
	
	static String formatResult(double res) {
		return String.format("%.10g", res);
	}
	
	static int verifyCase(int casenum, double expected, double received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
			System.err.println();
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
			int[] permutation         = {1,3,2};
			double expected__         = 1.0;

			return verifyCase(casenum__, expected__, new RandomSort().getExpected(permutation));
		}
		case 1: {
			int[] permutation         = {4,3,2,1};
			double expected__         = 4.066666666666666;

			return verifyCase(casenum__, expected__, new RandomSort().getExpected(permutation));
		}
		case 2: {
			int[] permutation         = {1};
			double expected__         = 0.0;

			return verifyCase(casenum__, expected__, new RandomSort().getExpected(permutation));
		}
		case 3: {
			int[] permutation         = {2,5,1,6,3,4};
			double expected__         = 5.666666666666666;

			return verifyCase(casenum__, expected__, new RandomSort().getExpected(permutation));
		}

		// custom cases

/*      case 4: {
			int[] permutation         = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new RandomSort().getExpected(permutation));
		}*/
/*      case 5: {
			int[] permutation         = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new RandomSort().getExpected(permutation));
		}*/
/*      case 6: {
			int[] permutation         = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new RandomSort().getExpected(permutation));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
