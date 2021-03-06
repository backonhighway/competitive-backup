package tc500s.tc595;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class LittleElephantAndIntervalsDiv1
{
	public long getNumber(int M, int[] L, int[] R)
	{
		int len = L.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			//test if it will be covered
			boolean[] used = new boolean[1000];
			for (int j = i + 1; j < len; j++) {
				for (int k = L[j] - 1; k <= R[j] - 1; k++) {
					used[k] = true;
				}
			}
			for (int j = L[i] - 1; j <= R[i] - 1; j++) {
				if (!used[j]) {
					count++;
					break;
				}
			}
		}
		return getPow(count);
	}
	
	public long getPow(int count) {
		long ret = 1;
		for (int i = 0; i < count; i++) {
			ret *= 2L;
		}
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, int[] p2, boolean hasAnswer, long p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		LittleElephantAndIntervalsDiv1 obj;
		long answer;
		obj = new LittleElephantAndIntervalsDiv1();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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
		
		int p0;
		int[] p1;
		int[] p2;
		long p3;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 4;
		p1 = new int[]{1,2,3};
		p2 = new int[]{1,2,3};
		p3 = 8L;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 3;
		p1 = new int[]{1,1,2};
		p2 = new int[]{3,1,3};
		p3 = 4L;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 1000;
		p1 = new int[]{47};
		p2 = new int[]{747};
		p3 = 2L;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 42;
		p1 = new int[]{5,23,4,1,15,2,22,26,13,16,28,13,27,9,18,4,10,3,4,4,3,4,1,18,18,2,38,4,10,12,3,30,11,38,2,13,1,13,18,16,13,2,14,27,13,3,26,19,5,10};
		p2 = new int[]{30,41,17,1,21,6,28,30,15,19,31,28,35,27,30,13,31,5,8,25,40,10,3,26,23,9,40,8,40,23,12,37,35,39,11,34,10,21,22,21,24,5,39,27,17,16,26,35,25,36};
		p3 = 256L;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, true, p3) ) && all_right;
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
	// Little Elephant from the Zoo of Lviv has some balls arranged in a row. Each ball can be painted in one of two possible colors: black or white. Initially all the balls are painted white. 
	// 
	// 
	// 
	// 
	// You are given an int M, which represents the number of balls in the row. 
	// The balls are numbered from left to right, starting from 1. 
	// You are also given two int[]s L and R. 
	// To repaint balls, Little Elephant wants to use a robot. 
	// The robot will paint the balls in several consecutive stages.
	// For each i, the i-th stage (1-based index) will look as follows:
	// First, the robot will choose one of the two colors: white or black.
	// Then, the robot will paint the balls with indices from L[i-1] to R[i-1], inclusive, using the chosen color.
	// (Painting a ball covers all previous layers of paint.)
	// 
	// 
	// 
	// 
	// Return the number of different colorings Little Elephant can get after the last stage. (Two colorings are considered different if there exists some ball that is white in one coloring and black in the other one).
	// 
	// 
	// DEFINITION
	// Class:LittleElephantAndIntervalsDiv1
	// Method:getNumber
	// Parameters:int, int[], int[]
	// Returns:long
	// Method signature:long getNumber(int M, int[] L, int[] R)
	// 
	// 
	// CONSTRAINTS
	// -M will be between 1 and 1,000, inclusive. 
	// -L will contain between 1 and 50 elements, inclusive.
	// -R will contain the same number of elements as L.
	// -Each element of R will be between 1 and M, inclusive.
	// -i-th element of L will be between 1 and R[i], inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 4
	// {1, 2, 3}
	// {1, 2, 3}
	// 
	// Returns: 8
	// 
	// In the three stages the robot will choose the color for balls number 1, 2, and 3. The choices are independent of each other. The last, fourth ball will always remain white. Thus there are 2*2*2 = 8 different colorings.
	// 
	// 1)
	// 3
	// {1, 1, 2}
	// {3, 1, 3}
	// 
	// Returns: 4
	// 
	// 
	// 
	// 2)
	// 1000
	// {47}
	// {747}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 3)
	// 42
	// {5, 23, 4, 1, 15, 2, 22, 26, 13, 16, 28, 13, 27, 9, 18, 4, 10, 3, 4, 4, 3, 4, 1, 18, 18, 2, 38, 4, 10, 12, 3, 30, 11, 38, 2, 13, 1, 13, 18, 16, 13, 2, 14, 27, 13, 3, 26, 19, 5, 10}
	// {30, 41, 17, 1, 21, 6, 28, 30, 15, 19, 31, 28, 35, 27, 30, 13, 31, 5, 8, 25, 40, 10, 3, 26, 23, 9, 40, 8, 40, 23, 12, 37, 35, 39, 11, 34, 10, 21, 22, 21, 24, 5, 39, 27, 17, 16, 26, 35, 25, 36}
	// 
	// Returns: 256
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
