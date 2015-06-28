package tc600s.tc634;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ShoppingSurveyDiv1
{
	public int minValue(int N, int K, int[] s)
	{
		int ret = 0;
		for (int i=N; i>=0; i--) {
			int total = 0;
			for (int j=0; j<s.length; j++) {
				if (s[j]-i > 0) {
					total += s[j] - i;
				}
			}
			if (total <= (K-1) * (N-i)) ret = i;
		}
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		ShoppingSurveyDiv1 obj;
		int answer;
		obj = new ShoppingSurveyDiv1();
		long startTime = System.currentTimeMillis();
		answer = obj.minValue(p0, p1, p2);
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
		int p1;
		int[] p2;
		int p3;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 10;
		p1 = 2;
		p2 = new int[]{1,2,3};
		p3 = 0;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 5;
		p1 = 2;
		p2 = new int[]{1,2,3};
		p3 = 1;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 4;
		p1 = 4;
		p2 = new int[]{4,4,4,2};
		p3 = 2;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 20;
		p1 = 3;
		p2 = new int[]{1,10,3,4,8,15,3,16,18,2,7,3};
		p3 = 10;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = 4;
		p1 = 2;
		p2 = new int[]{1,2,1,1,3,1,2,2,1,2,1};
		p3 = 2;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = 2;
		p1 = 3;
		p2 = new int[]{1,1,1,2};
		p3 = 1;
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, p2, true, p3) ) && all_right;
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
	// A store sells M different items, conveniently numbered 0 through M-1.
	// For a shopping survey you interviewed N customers.
	// Each customer responded to the survey with a list of items they've bought.
	// Each customer bought at most one of each item.
	// It is possible that some customers did not buy anything at all.
	// 
	// 
	// 
	// After collecting the responses, you've summed up the results and found that s[i] people have bought item i.
	// Due to an unfortunate accident, you've then lost the actual survey responses.
	// All you have left are the values s[i] you computed.
	// 
	// 
	// 
	// You are now supposed to report the number of big shoppers among the survey respondents.
	// A big shopper is defined as a customer who has bought K or more items.
	// Of course, having lost the detailed responses, you might be unable to determine the actual number of big shoppers.
	// 
	// 
	// 
	// You are given the ints N and K, and the int[] s with M elements.
	// Compute and return the smallest possible number of big shoppers.
	// 
	// 
	// DEFINITION
	// Class:ShoppingSurveyDiv1
	// Method:minValue
	// Parameters:int, int, int[]
	// Returns:int
	// Method signature:int minValue(int N, int K, int[] s)
	// 
	// 
	// CONSTRAINTS
	// -N will be between 1 and 500, inclusive.
	// -s will contain between 1 and 500 elements, inclusive.
	// -Each element in s will be between 0 and N, inclusive.
	// -K will be between 1 and the length of s, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 10
	// 2
	// {1, 2, 3}
	// 
	// Returns: 0
	// 
	// There are 10 customers.
	// Item 0 was bought by 1 customer, item 1 by 2 customers, and item 2 by 3 of the customers.
	// A big shopper is a customer who bought at least 2 items.
	// Given this data it is possible that there are no big shoppers at all.
	// (There could have been six customers who bought one item each, and four other customers who didn't buy anything at all.)
	// 
	// 1)
	// 5
	// 2
	// {1, 2, 3}
	// 
	// Returns: 1
	// 
	// 
	// 
	// 2)
	// 4
	// 4
	// {4, 4, 4, 2}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 3)
	// 20
	// 3
	// {1, 10, 3, 4, 8, 15, 3, 16, 18, 2, 7, 3}
	// 
	// Returns: 10
	// 
	// 
	// 
	// 4)
	// 4
	// 2
	// {1, 2, 1, 1, 3, 1, 2, 2, 1, 2, 1}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 5)
	// 2
	// 3
	// {1, 1, 1, 2}
	// 
	// Returns: 1
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!