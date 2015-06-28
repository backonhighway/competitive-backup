package tc600s.tc600;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ORSolitaire
{
	public int getMinimum(int[] numbers, int goal)
	{
		int[] count = new int[32];
		String goalstr = Integer.toBinaryString(goal);
		goalstr = new StringBuilder(goalstr).reverse().toString();
		int gn = goalstr.length();
		
		for (int i = 0; i < numbers.length; i++) {
			String str = Integer.toBinaryString(numbers[i]);
			str = new StringBuilder(str).reverse().toString();
			int n = str.length();
			
			boolean good = true;
			if (gn < n) good = false;
			for (int j = 0; j < n && j < gn ; j++) {
				if (goalstr.charAt(j) == '0' && str.charAt(j) == '1') good = false;
			}
			if (!good) continue;
			
			for (int j = 0; j < n && j < gn ; j++) {
				if (goalstr.charAt(j) == '1' && str.charAt(j) == '1') count[j]++;
			}
		}

		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < gn; i++) {
			if (goalstr.charAt(i) == '1') {
				ret = Math.min(ret, count[i]);
			}
		}
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		ORSolitaire obj;
		int answer;
		obj = new ORSolitaire();
		long startTime = System.currentTimeMillis();
		answer = obj.getMinimum(p0, p1);
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
		
		int[] p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{1,2,4};
		p1 = 7;
		p2 = 1;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{1,2,4,7,8};
		p1 = 7;
		p2 = 2;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{12571295,2174218,2015120};
		p1 = 1;
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{5,2,4,52,62,9,8,3,1,11,6};
		p1 = 11;
		p2 = 3;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{503,505,152,435,491,512,1023,355,510,500,502,255,63,508,509,511,60,250,254,346};
		p1 = 510;
		p2 = 5;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
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
	// Note that the memory limit for all tasks in this SRM is 256 MB.
	// This problem statement contains subscripts that may not display properly if viewed outside of the applet.
	// 
	// Manao is playing a solitaire game called OR-solitaire. In this game, the player starts with a number X = 0 and should obtain the number goal in one or more moves. The set of valid moves is determined by a int[] numbers. In each move, the player chooses some element of numbers and replaces X with the bitwise OR of X and the chosen element.
	// 
	// Fox Ciel wants Manao to stop playing OR-solitaire and move on with his life. She decided to erase some of the elements from numbers in such a way that it becomes impossible to complete the game. Return the minimum number of elements that need to be removed to achieve this.
	// 
	// DEFINITION
	// Class:ORSolitaire
	// Method:getMinimum
	// Parameters:int[], int
	// Returns:int
	// Method signature:int getMinimum(int[] numbers, int goal)
	// 
	// 
	// NOTES
	// -If a and b are single bits then a | b is defined as max(a, b). For two integers, A and B, in order to calculate A | B, they need to be represented in binary: A = (an...a1)2, B = (bn...b1)2 (if the lengths of their representations are different, the shorter one is prepended with the necessary number of leading zeroes). Then A | B = C = (cn...c1)2, where ci = ai | bi. For example, 10 | 3 = (1010)2 | (0011)2 = (1011)2 = 11.
	// 
	// 
	// CONSTRAINTS
	// -numbers will contain between 1 and 50 elements, inclusive.
	// -Each element of numbers will be between 1 and 1,000,000,000.
	// -The elements in numbers will be distinct.
	// -goal will be between 1 and 1,000,000,000.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1, 2, 4}
	// 7
	// 
	// Returns: 1
	// 
	// The goal of the game is to obtain X = 7 from X = 0. The possible moves are to replace X with bitwise OR of X and 1, bitwise OR of X and 2 and bitwise OR of X and 4. X = 7 can be obtained only by using each of the three moves at least once, so removing any single element from numbers will make the game impossible to finish.
	// 
	// 1)
	// {1, 2, 4, 7, 8}
	// 7
	// 
	// Returns: 2
	// 
	// In this example, Fox Ciel should remove the number 7 and one of the numbers 1, 2, 4.
	// 
	// 2)
	// {12571295, 2174218, 2015120}
	// 1
	// 
	// Returns: 0
	// 
	// There is no need to remove elements from numbers, since the game cannot be completed in its initial version.
	// 
	// 3)
	// {5,2,4,52,62,9,8,3,1,11,6}
	// 11
	// 
	// Returns: 3
	// 
	// 
	// 
	// 4)
	// {503, 505, 152, 435, 491, 512, 1023, 355, 510, 500, 502, 255, 63, 508, 509, 511, 60, 250, 254, 346}
	// 510
	// 
	// Returns: 5
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!