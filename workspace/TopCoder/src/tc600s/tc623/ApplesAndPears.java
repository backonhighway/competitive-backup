package tc600s.tc623;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ApplesAndPears
{
	public int getArea(String[] board, int K)
	{
		int len = board.length;
		//pre-calc
		int[][] apple = new int[len][len];
		int[][] pear = new int[len][len];
		int[][] empty = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i > 0) {
					apple[i][j] += apple[i-1][j];
					pear[i][j] += pear[i-1][j];
					empty[i][j] += empty[i-1][j];
				}
				if (j > 0) {
					apple[i][j] += apple[i][j-1];
					pear[i][j] += pear[i][j-1];
					empty[i][j] += empty[i][j-1];
				}
				if (i > 0 && j > 0) {
					apple[i][j] -= apple[i-1][j-1];
					pear[i][j] -= pear[i-1][j-1];
					empty[i][j] -= empty[i-1][j-1];
				}
				if (board[i].charAt(j) == 'A') apple[i][j]++;
				if (board[i].charAt(j) == 'P') pear[i][j]++;
				if (board[i].charAt(j) == '.') empty[i][j]++;
			}
		}
		boolean noEmpty = empty[len-1][len-1] == 0;
		
		//calculate
		int ret = 0;
		for (int i = 0; i < len; i++) {
			for (int i2 = i; i2 < len; i2++) {
				for (int j = 0; j < len; j++) {
					for (int j2 = j; j2 < len; j2++) {
						int area = (j2 - j + 1) * (i2 - i + 1);
						// counts
						int aCount = getCount(apple, i, i2, j, j2);
						int pCount = getCount(pear, i, i2, j, j2);
						int eCount = getCount(empty, i, i2, j, j2);
						// moves
						if (noEmpty) {
							if (aCount == area) ret = Math.max(ret, area);
							if (pCount == area) ret = Math.max(ret, area);
						} else {
							if (pCount*2 + eCount <= K && area <= apple[len-1][len-1]) {
								ret = Math.max(ret, area);
							}
							if (aCount*2 + eCount <= K && area <= pear[len-1][len-1]) {
								ret = Math.max(ret, area);
							}
							if (pCount + aCount <= K && area <= empty[len-1][len-1]) {
								ret = Math.max(ret, area);
							}
						}
					}
				}
			}
		}
		return ret;
	}
	
	public int getCount (int[][] count, int i, int i2, int j, int j2) {
		int aCount = count[i2][j2];
		if (i > 0) aCount -= count[i-1][j2];
		if (j > 0) aCount -= count[i2][j-1];
		if (i > 0 && j > 0) aCount += count[i-1][j-1];
		return aCount;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		ApplesAndPears obj;
		int answer;
		obj = new ApplesAndPears();
		long startTime = System.currentTimeMillis();
		answer = obj.getArea(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		int p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new String[]{".A","P."};
		p1 = 0;
		p2 = 1;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{".A","P."};
		p1 = 1;
		p2 = 2;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{".PP","PPA","PAP"};
		p1 = 3;
		p2 = 6;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"A.P.PAAPPA","PPP..P.PPP","AAP.A.PAPA","P.PA.AAA.A","...PA.P.PA","P..A.A.P..","PAAP..A.A.","PAAPPA.APA",".P.AP.P.AA","..APAPAA.."};
		p1 = 10;
		p2 = 21;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
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
	// A square board is divided into N rows by N columns of unit square cells.
	// Some cells of the board are empty.
	// Each of the other cells contains either an apple or a pear.
	// You are given the current state of the board as a String[] board.
	// In board, the character '.' denotes an empty cell, 'A' denotes an apple, and 'P' denotes a pear.
	// 
	// You are allowed to perform at most K moves.
	// In each move, you can pick up one fruit (an apple or a pear) and place it onto any empty cell.
	// (The new cell doesn't have to be adjacent to the old one.)
	// Note that you cannot remove fruit from the board, you are only allowed to move it onto different cells.
	// 
	// A rectangular section of the board is called uniform if all cells in the rectangle are the same:
	// that is, either all those cells contain apples, or they all contain pears, or all of them are empty.
	// After you are done moving the fruit, you want to have a uniform rectangle that is as large as possible somewhere on the board.
	// Return the largest possible area of such a rectangle.
	// 
	// DEFINITION
	// Class:ApplesAndPears
	// Method:getArea
	// Parameters:String[], int
	// Returns:int
	// Method signature:int getArea(String[] board, int K)
	// 
	// 
	// CONSTRAINTS
	// -N will be between 1 and 50, inclusive.
	// -board will contain exactly N elements.
	// -Each element of board will contain exactly N characters.
	// -Each character in board will be '.', 'A', or 'P'.
	// -K will be between 0 and 1000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {".A",
	//  "P."}
	// 0
	// 
	// Returns: 1
	// 
	// As K=0, you are not allowed to make any moves.
	// Currently, the largest uniform rectangle is just a single cell.
	// 
	// 1)
	// {".A",
	//  "P."}
	// 1
	// 
	// Returns: 2
	// 
	// Move any piece of fruit onto any of the two currently empty cells.
	// After the move, there will be two adjacent empty cells.
	// These form a 2x1 uniform rectangle.
	// 
	// 2)
	// {".PP", 
	//  "PPA", 
	//  "PAP"}
	// 3
	// 
	// Returns: 6
	// 
	// In three moves, you can create a 3x2 rectangle of cells that contain pears.
	// 
	// 3)
	// {"A.P.PAAPPA",
	//  "PPP..P.PPP",
	//  "AAP.A.PAPA",
	//  "P.PA.AAA.A",
	//  "...PA.P.PA",
	//  "P..A.A.P..",
	//  "PAAP..A.A.",
	//  "PAAPPA.APA",
	//  ".P.AP.P.AA",
	//  "..APAPAA.."}
	// 10
	// 
	// Returns: 21
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
