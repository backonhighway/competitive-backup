package tc600s.tc614;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TorusSailingEasy
{
	public double expectedTime(int N, int M, int goalX, int goalY)
	{
		int forward = moves(N,M,goalX,goalY,1);
		int back = moves(N,M,goalX,goalY,-1);
		if (forward == -1 || back == -1) return -1.0;
		return forward * back;
	}
	
	public int moves(int N, int M, int goalX, int goalY, int dir) {
		int x = 0;
		int y = 0;
		int moves = 0;
		for(int i = 0; i < N * M; i++) {
			x = (x + dir) % N;
			if (x < 0) x = N - 1;
			y = (y + dir) % M;
			if (y < 0) y = M - 1;
			moves++;
			
			if (x == goalX && y == goalY) return moves;
		}
		return -1;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer, double p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		TorusSailingEasy obj;
		double answer;
		obj = new TorusSailingEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.expectedTime(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == answer && Math.abs(p4 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p4));
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
		int p1;
		int p2;
		int p3;
		double p4;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 2;
		p1 = 2;
		p2 = 1;
		p3 = 1;
		p4 = 1.0D;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 2;
		p1 = 2;
		p2 = 0;
		p3 = 1;
		p4 = -1.0D;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 3;
		p1 = 3;
		p2 = 1;
		p3 = 1;
		p4 = 2.0D;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 4;
		p1 = 6;
		p2 = 1;
		p3 = 3;
		p4 = 27.0D;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 5;
		p1 = 5;
		p2 = 2;
		p3 = 2;
		p4 = 27.0D;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) ) && all_right;
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
	// Fox Ciel is sailing in the Donut sea. The Donut sea is a torus. For navigation, the torus is divided into N times M cells, as shown in the figure below.
	// 
	// 
	// 
	// 
	// (Image by YassineMrabet from Wikimedia Commons, licensed under CC BY-SA 3.0.)
	// 
	// 
	// 
	// Each of the cells has two integer coordinates (n, m), where 0 <= n < N and 0 <= m < M. Note that the coordinates wrap around modulo N and M. For example, if you are in the cell (N-1, M-1) and you cross over one of its sides, you will reach one of the cells (N-2, M-1), (0, M-1), (N-1, M-2), and (N-1, 0).
	// 
	// 
	// 
	// Ciel starts in the cell (0, 0) and wants to reach the goal cell (goalX, goalY).
	// 
	// 
	// 
	// Unfortunately, Ciel's navigation is very poor. Whenever she moves to a new cell, there are two equally probable outcomes: either both of her coordinates increase by 1, or both of them decrease by 1 (wrapping around if necessary). Formally, if Ciel's current coordinates are (n, m), her new coordinates will be either ((n+1) modulo N, (m+1) modulo M), or ((n-1) modulo N, (m-1) modulo M), with equal probability. Each such move takes one day.
	// 
	// 
	// 
	// If Ciel can never reach her goal, return -1. Otherwise, return the expected number of days Ciel will need to reach her goal.
	// 
	// 
	// 
	// DEFINITION
	// Class:TorusSailingEasy
	// Method:expectedTime
	// Parameters:int, int, int, int
	// Returns:double
	// Method signature:double expectedTime(int N, int M, int goalX, int goalY)
	// 
	// 
	// NOTES
	// -The returned value must have an absolute or relative error less than 1e-9.
	// -In many programming languages the modulo operator returns negative values for negative inputs. If you are using such a language, it is safer to use the formulas ((n-1+N) modulo N) and ((m-1+M) modulo M) to compute Ciel's new coordinates when both of them are supposed to decrease.
	// -Informally, the expected value of a random variable can be seen as its average over very many trials.
	// 
	// 
	// CONSTRAINTS
	// -N will be between 2 and 10, inclusive.
	// -M will be between 2 and 10, inclusive.
	// -goalX will be between 0 and N - 1, inclusive.
	// -goalY will be between 0 and M - 1, inclusive.
	// -(goalX, goalY) will not be (0, 0).
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 2
	// 2
	// 1
	// 1
	// 
	// Returns: 1.0
	// 
	// She will always reach the goal in 1 day.
	// 
	// 1)
	// 2
	// 2
	// 0
	// 1
	// 
	// Returns: -1.0
	// 
	// It is impossible to reach the goal. Ciel will only visit the cells (0, 0) and (1, 1) alternately.
	// 
	// 2)
	// 3
	// 3
	// 1
	// 1
	// 
	// Returns: 2.0
	// 
	// She can reach the goal in 1 day with probability 1/2, in 2 days with probability 1/4, in 3 days with probability 1/8, in 4 days with probability 1/16 and so on. In general, she can reach the goal in n days with probability 1/(2^n) where n is a positive integer.
	// 
	// The answer is (1 * 1/2) + (2 * 1/4) + (3 * 1/8) + (4 * 1/16) + ... = 2.0.
	// 
	// 
	// 3)
	// 4
	// 6
	// 1
	// 3
	// 
	// Returns: 27.0
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!