package tc600s.tc631;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TaroJiroGrid
{
	public int getNumber(String[] grid)
	{
		int len = grid.length;
		if (isOK(grid)) return 0;
		

		for (int i=0; i<len; i++) {
			String[] grid2 = new String[len];
			grid2[i] = new String("");
			for (int j=0; j<len; j++) {
				if (j == i) {
					for (int k=0; k<len; k++) {
						grid2[j] += "W";
					}
				} else {
					grid2[j] = grid[j];
				}
			}
			if (isOK(grid2)) return 1;
		}
		for (int i=0; i<len; i++) {
			String[] grid2 = new String[len];
			grid2[i] = new String("");
			for (int j=0; j<len; j++) {
				if (j == i) {
					for (int k=0; k<len; k++) {
						grid2[i] += "B";
					}
				} else {
					grid2[j] = grid[j];
				}
			}

			if (isOK(grid2)) return 1;
		}
		return 2;
	}
	
	private boolean isOK(String[] grid) {
		int len = grid.length;
		for (int j=0; j<len; j++) {
			int samecount = 1;
			for (int k=1; k<len; k++) {
				if (grid[k].charAt(j) == grid[k-1].charAt(j)) {
					samecount++;
					if (samecount > len/2) return false;
				} else {
					samecount = 1;
				}
			}
		}
		
		return true;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		TaroJiroGrid obj;
		int answer;
		obj = new TaroJiroGrid();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		boolean disabled;
		boolean tests_disabled;
		all_right = true;
		tests_disabled = false;
		
		String[] p0;
		int p1;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new String[]{"WB","BB"};
		p1 = 1;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"WB","WW"};
		p1 = 1;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"WB","WB"};
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"WBBW","WBWB","WWBB","BWWW"};
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{"WBBWBB","BBWBBW","WWBWBW","BWWBBB","WBWBBW","WWWBWB"};
		p1 = 1;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		if (all_right) {
			if (tests_disabled) {
				System.out.println("You're a stud (but some test cases were disabled)!");
			} else {
				System.out.println("You're a stud (at least on given cases)!");
			}
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// Cat Taro and Fox Jiro work with a square grid with N rows and N columns (N is even).
	// Each cell of the grid is painted either black or white.
	// You are given a String[] grid which represents the current state of the grid.
	// Each element of grid represents one row of the grid.
	// In grid, the character 'W' represents a white cell, and the character 'B' represents a black cell. 
	// 
	// 
	// 
	// 
	// Taro works with the rows of the grid.
	// He will take zero or more turns. In each turn he can choose any row of the grid and perform one of the following operations:
	// 
	// 
	// 
	// Paint all black cells of the row white.
	// 
	// 
	// Paint all white cells of the row black.
	// 
	// 
	// 
	// Jiro works with the columns of the grid.
	// He thinks that a column is bad if there are more than N/2 consecutive cells of the same color in the column.
	// He is happy only if there are no bad columns in the grid.
	// 
	// 
	// 
	// 
	// Return the minimum number of turns that Taro must perform in order to make Jiro happy.
	// 
	// 
	// DEFINITION
	// Class:TaroJiroGrid
	// Method:getNumber
	// Parameters:String[]
	// Returns:int
	// Method signature:int getNumber(String[] grid)
	// 
	// 
	// CONSTRAINTS
	// -N will be between 2 and 50, inclusive.
	// -N will be even.
	// -grid will contain exactly N elements.
	// -Each element of grid will contain exactly N characters.
	// -Each character in grid will be 'W' or 'B'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"WB",
	//  "BB"}
	// 
	// Returns: 1
	// 
	// Initially, Jiro is not happy because all cells of the column 1 (0-based index) are black. In one operation, Taro can paint the first row white. After the operation, Jiro will be happy about the grid. Thus, the answer is 1.
	// 
	// 1)
	// {"WB",
	//  "WW"}
	// 
	// Returns: 1
	// 
	// 
	// 
	// 2)
	// {"WB",
	//  "WB"}
	// 
	// Returns: 2
	// 
	// In this case, Taro should paint the first row white, and the second one black (or vice versa). Note that it is not possible to make Jiro happy in fewer than two operations.
	// 
	// 3)
	// {"WBBW",
	//  "WBWB",
	//  "WWBB",
	//  "BWWW"}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 4)
	// {"WBBWBB",
	//  "BBWBBW",
	//  "WWBWBW",
	//  "BWWBBB",
	//  "WBWBBW",
	//  "WWWBWB"}
	// 
	// Returns: 1
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
