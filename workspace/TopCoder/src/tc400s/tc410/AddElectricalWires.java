package tc400s.tc410;
// Paste me into the FileEdit configuration dialog
import java.util.*;

public class AddElectricalWires {
	List<List> biglist;
	String[] wires;
	boolean[] visited;
	
    public int maxNewWires(String[] wires, int[] grids) {
    	int gridlen = grids.length;
    	List<List> biglist = new ArrayList<List>();
    	this.biglist = biglist;
    	this.wires = wires;
    	boolean[] visited = new boolean[wires.length];
    	this.visited = visited;
    	
		for(int i=0; i<gridlen; i++){
			List<Integer> grouplist = new ArrayList<Integer>();
			grouplist.add(grids[i]);
			dfs(grouplist, grids[i]);
			biglist.add(grouplist);
		}
		int ans = 0;
		int before = 0;
		for(int i=0; i<wires.length; i++){
			for(int j=0; j<wires.length; j++){
				if(wires[i].charAt(j)=='1') before++;
			}
		}
		before /= 2;
		if(gridlen == 0){
			return wires.length * (wires.length-1) / 2 - before;
		}
		int[] size = new int[biglist.size()];
		int k = 0;
		for(List<Integer> l : biglist){
			size[k] = l.size();
			k++;
		}
		Arrays.sort(size);
		for(int i=0; i<visited.length; i++){
			if(!visited[i]) size[size.length-1] ++;
		}
		
		for(int i=0; i<size.length; i++){
			ans += size[i] * (size[i]-1) / 2;
		}
		return ans - before;
    }
    
    public void dfs(List<Integer> grouplist, int row){
    	visited[row] = true;
    	
    	int len = wires.length;
    	for(int i=0; i<len; i++){
			if(!visited[i] && wires[row].charAt(i)=='1'){
				grouplist.add(i);
				dfs(grouplist, i);
			}
    	}
    }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			AddElectricalWiresHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				AddElectricalWiresHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class AddElectricalWiresHarness {
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
			String[] wires            = {"000","000","000"};
			int[] gridConnections     = {0};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}
		case 1: {
			String[] wires            = {"000","000","000"};
			int[] gridConnections     = {0,1};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}
		case 2: {
			String[] wires            = {"01","10"};
			int[] gridConnections     = {0};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}
		case 3: {
			String[] wires            = {"00000","00000","00000","00000","00000"};
			int[] gridConnections     = {0,1,2,3,4};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}
		case 4: {
			String[] wires            = {"01000","10100","01010","00100","00000"};
			int[] gridConnections     = {2,4};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}

		// custom cases

      case 5: {
			String[] wires            = {"00001000000000001000000000000011000000000000100000", "00000000000000000000000000010000000000000000000000", "00000000000100000000000000000000010000010000000000", "00000000000000000000000000000000000000000000010000", "10000000000000001000000000000010100000000000000000", "00000000000000000000100000000100000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000001000000000000001000000000000", "00000000000000000000000010000000000000000000000000", "00000000000000000000000000010000000000000000000000", "00100000000000000000000000000000010000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000000000000000000000000000000000", "10001000000000000000000000000010000000000000000000", "00000000000000000000100000000100000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000001000000000000000100000000000", "00000100000000000100000000001000000000000000000000", "00000000000000000000000000000000010000000000000000", "00000000100000000001000000000000000100000100000000", "00000000000000000000000000000000000000000000000000", "00000000010000000000000000100000000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000000010000000000000000000000000", "01000000001000000000000000000000000000000010000000", "00000000000000000000100000000000000000000000000000", "00000100000000000100000000000000000000000000000000", "10001000000000001000000000000001100000000000000000", "10000000000000000000000000000010100000000000100000", "00001000000000000000000000000011000000000000000000", "00100000000100000000010000000000000000001000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000001000000000000000000000000010", "00000000000000000000000000000000000000000000000000", "00000000100000000000000000000000000000100000000000", "00000000000000000001000000000000000001000000000010", "00100000000000000000000000000000000000000000000000", "00000000000000000000000000000000010000000000000000", "00000000000000000000001000000000000000000000000000", "00000000000000000000000000010000000000000000000000", "00000000000000000000000000000000000000000000000000", "10000000000000000000000000000001000000000000000000", "00010000000000000000000000000000000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000000000000000000000000000000000", "00000000000000000000000000000000000100100000000000", "00000000000000000000000000000000000000000000000000"};
			int[] gridConnections     = {4, 29, 49, 19, 47, 46, 45, 39, 26, 1};
			int expected__            = 207;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}
/*      case 6: {
			String[] wires            = ;
			int[] gridConnections     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}*/
/*      case 7: {
			String[] wires            = ;
			int[] gridConnections     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new AddElectricalWires().maxNewWires(wires, gridConnections));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
