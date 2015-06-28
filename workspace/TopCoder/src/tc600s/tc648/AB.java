package tc600s.tc648;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class AB
{
	public String createString(int N, int K)
	{
		for (int i = 1; i < N; i++) {
			int a = i;
			int b = N - i;
			if (a * b < K) continue;
			int x = a * b - K;
			
			return makeString(N, x, a, b);
		}
		return "";
	}
	
	private String makeString(int N, int n, int a, int b) {
		int[] pocket = new int[b+1];
		int index = b;
		while (n > 0) {
			if (index <= n) {
				pocket[index]++;
				n -= index;
			} else {
				index--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b+1; i++) {
			for (int j = 0; j < pocket[i]; j++) {
				sb.append('A');
			}
			if (i != b) {
				sb.append('B');
			}
		}
		StringBuilder asb = new StringBuilder();
		if (sb.length() < N) {
			for (int i = 0; i < N - sb.length(); i++) {
				asb.append('A');
			}
		}
		return asb.toString() + sb.toString();
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		AB obj;
		String answer;
		obj = new AB();
		long startTime = System.currentTimeMillis();
		answer = obj.createString(p0, p1);
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
		
		int p0;
		int p1;
		String p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 3;
		p1 = 2;
		p2 = "ABB";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 2;
		p1 = 0;
		p2 = "BA";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 6;
		p1 = 7;
		p2 = "AABBB";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 10;
		p1 = 12;
		p2 = "BAABBABAAB";
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
	// You are given two ints: N and K. Lun the dog is interested in strings that satisfy the following conditions:
	// 
	// The string has exactly N characters, each of which is either 'A' or 'B'.
	// The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
	// 
	// If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
	// 
	// DEFINITION
	// Class:AB
	// Method:createString
	// Parameters:int, int
	// Returns:String
	// Method signature:String createString(int N, int K)
	// 
	// 
	// CONSTRAINTS
	// -N will be between 2 and 50, inclusive.
	// -K will be between 0 and N(N-1)/2, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 3
	// 2
	// 
	// Returns: "ABB"
	// 
	// This string has exactly two pairs (i, j) mentioned in the statement: (0, 1) and (0, 2).
	// 
	// 1)
	// 2
	// 0
	// 
	// Returns: "BA"
	// 
	// Please note that there are valid test cases with K = 0.
	// 
	// 2)
	// 5
	// 8
	// 
	// Returns: ""
	// 
	// Five characters is too short for this value of K.
	// 
	// 3)
	// 10
	// 12
	// 
	// Returns: "BAABBABAAB"
	// 
	// Please note that this is an example of a solution; other valid solutions will also be accepted.
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
