package tc500s.tc590;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class FoxAndChess
{
	public String ableToMove(String begin, String target)
	{
		int len = begin.length();
		boolean ok = true;
		
		int lcount = 0;
		int rcount = 0;
		for (int i = 0; i < len; i++) {
			if (begin.charAt(i) == 'R') {
				if (lcount < 0) ok = false;
				rcount++;
			}
			if (begin.charAt(i) == 'L') {
				if (rcount > 0) ok = false;
				lcount++;
			}
			if (target.charAt(i) == 'R') {
				if (lcount < 0) ok = false;
				rcount--;
			}
			if (target.charAt(i) == 'L') {
				if (rcount > 0) ok = false;
				lcount--;
			}
			
			if (lcount > 0 || rcount < 0) ok = false;
		}
		if (lcount != 0 || rcount != 0) ok = false;
		
		return ok ? "Possible" : "Impossible";
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
		System.out.println("]");
		FoxAndChess obj;
		String answer;
		obj = new FoxAndChess();
		long startTime = System.currentTimeMillis();
		answer = obj.ableToMove(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		
		String p0;
		String p1;
		String p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = "R...";
		p1 = "..R.";
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = "..R.";
		p1 = "R...";
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = ".L.R.R.";
		p1 = "L...R.R";
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = ".L.R.";
		p1 = ".R.L.";
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = "LRLLRLRLLRLLRLRLRL";
		p1 = "LRLLRLRLLRLLRLRLRL";
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = "L";
		p1 = ".";
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		// ----- test 5 -----
		disabled = false;
		p0 = "LRRR...L.R.LLLL.R.....LL.LRR..........";
		p1 = "L..RRLR...RLLLL....RLLL...R......R....";
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2) ) && all_right;
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
	// Fox Ciel is playing a game with some chess pawns and a strip of paper.
	// The strip of paper is divided into a row of cells.
	// Each cell can contain at most one pawn.
	// The white pawns will be denoted 'R', because they are only allowed to move to the right.
	// The black pawns will be denoted 'L', because they are only allowed to move to the left.
	// 
	// 
	// You are given a String begin that describes the current state of the strip: 'R' and 'L' are cells with corresponding pawns, and '.' are empty cells.
	// 
	// 
	// You are now allowed to make some moves (as many as you wish, possibly zero).
	// In each move you may either take a 'R' pawn and move it one cell to the right, or take a 'L' pawn and move it one cell to the left.
	// Of course, both types of moves are only valid if the destination cell is currently empty.
	// Pawns are not allowed to move out of bounds.
	// 
	// 
	// You are also given a String target that represents the desired state of the strip.
	// If it is possible to reach target from begin by making some valid moves, return "Possible" (quotes for clarity), otherwise return "Impossible".
	// 
	// DEFINITION
	// Class:FoxAndChess
	// Method:ableToMove
	// Parameters:String, String
	// Returns:String
	// Method signature:String ableToMove(String begin, String target)
	// 
	// 
	// CONSTRAINTS
	// -begin will contain between 1 and 50 elements, inclusive.
	// -begin and target will contain the same number of elements.
	// -Each character in begin and target will be one of '.', 'L' and 'R'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "R..."
	// "..R."
	// 
	// Returns: "Possible"
	// 
	// You have to move the only pawn to the right twice.
	// 
	// 1)
	// "..R."
	// "R..."
	// 
	// Returns: "Impossible"
	// 
	// Here target cannot be reached because the only pawn is only allowed to move to the right.
	// 
	// 2)
	// ".L.R.R."
	// "L...R.R"
	// 
	// Returns: "Possible"
	// 
	// 
	// 
	// 3)
	// ".L.R."
	// ".R.L."
	// 
	// Returns: "Impossible"
	// 
	// 
	// 
	// 4)
	// "LRLLRLRLLRLLRLRLRL"
	// "LRLLRLRLLRLLRLRLRL"
	// 
	// Returns: "Possible"
	// 
	// 
	// 
	// 5)
	// "L"
	// "."
	// 
	// Returns: "Impossible"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
