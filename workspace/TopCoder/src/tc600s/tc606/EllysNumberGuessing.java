package tc600s.tc606;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class EllysNumberGuessing
{
	public int getNumber(int[] guesses, int[] answers)
	{
		int[] ans = new int[2];
		ans[0] = guesses[0] + answers[0];
		ans[1] = guesses[0] - answers[0];
		ans[0] = ans[0] <= 1000000000 ? ans[0] : 0;
		ans[1] = 1 <= ans[1] ? ans[1] : 0;
		
		int len = guesses.length;
		for (int i = 1; i < len; i++) {
			int high = guesses[i] + answers[i];
			int low = guesses[i] - answers[i];
			high = high <= 1000000000 ? high : -1;
			low = 1 <= low ? low : -1;
			for (int j = 0; j < 2; j++) {
				if (ans[j] != high && ans[j] != low) {
					ans[j] = 0;
				}
			}
		}
		if (ans[0] != 0 && ans[1] != 0) return -1;
		else if (ans[0] == 0 && ans[1] == 0) return -2;
		else return ans[0] == 0 ? ans[1] : ans[0];
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		EllysNumberGuessing obj;
		int answer;
		obj = new EllysNumberGuessing();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0, p1);
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
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{600,594};
		p1 = new int[]{6,12};
		p2 = 606;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{100,50,34,40};
		p1 = new int[]{58,8,8,2};
		p2 = 42;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{500000,600000,700000};
		p1 = new int[]{120013,220013,79987};
		p2 = -2;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{500000000};
		p1 = new int[]{133742666};
		p2 = -1;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{76938260,523164588,14196746,296286419,535893832,41243148,364561227,270003278,472017422,367932361,395758413,301278456,186276934,316343129,336557549,52536121,98343562,356769915,89249181,335191879};
		p1 = new int[]{466274085,20047757,529015599,246925926,7318513,501969197,178651118,273209067,71194923,175279984,147453932,241933889,356935411,226869216,206654796,490676224,444868783,186442430,453963164,208020466};
		p2 = 543212345;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new int[]{42};
		p1 = new int[]{42};
		p2 = 84;
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 6 -----
		disabled = false;
		p0 = new int[]{999900000};
		p1 = new int[]{100001};
		p2 = 999799999;
		all_right = (disabled || KawigiEdit_RunTest(6, p0, p1, true, p2) ) && all_right;
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
	// Elly and Kris play the following game. In the beginning Kristina thinks of a number between 1 and 1,000,000,000, inclusive. After that Elly starts trying to guess it. In each round she says a number and Kristina says what is the absolute difference between the number she has thought of, and the number Elly guessed. Now Elly wonders if the guesses she has already made are sufficient to uniquely determine Kristina's number.
	// 
	// You are given a int[] guesses and a int[] answers of the same length. For each valid i, in round i of the game (0-based index) Elly guessed the number guesses[i] and Kristina answered answers[i]. If Kristina's number can be uniquely determined, return that number. If there are multiple possibilities that are consistent with the current set of guesses and answers, return -1. If it can be shown that at some point Kristina has lied (some of her answers were inconsistent), return -2.
	// 
	// DEFINITION
	// Class:EllysNumberGuessing
	// Method:getNumber
	// Parameters:int[], int[]
	// Returns:int
	// Method signature:int getNumber(int[] guesses, int[] answers)
	// 
	// 
	// CONSTRAINTS
	// -guesses and answers will each contain between 1 and 50 elements, inclusive.
	// -guesses and answers will contain the same number of elements.
	// -Each element of guesses will be between 1 and 1,000,000,000, inclusive.
	// -Each element of answers will be between 1 and 999,999,999, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {600, 594}
	// {6, 12}
	// 
	// Returns: 606
	// 
	// Apparently Kristina has thought of the number of this SRM.
	// 
	// 1)
	// {100, 50, 34, 40}
	// {58, 8, 8, 2}
	// 
	// Returns: 42
	// 
	// It is not guaranteed that Elly has used a perfect strategy so far.
	// 
	// 2)
	// {500000, 600000, 700000}
	// {120013, 220013, 79987}
	// 
	// Returns: -2
	// 
	// The answers here are inconsistent. After the second guess we can conclude that the answer is below 500000. But the third one indicates that it is above 500000. Thus, Kristina is a liar and you should return -2.
	// 
	// 3)
	// {500000000}
	// {133742666}
	// 
	// Returns: -1
	// 
	// There are multiple possibilities here, thus you should return -1.
	// 
	// 4)
	// {76938260, 523164588, 14196746, 296286419, 535893832,
	//  41243148, 364561227, 270003278, 472017422, 367932361,
	//  395758413, 301278456, 186276934, 316343129, 336557549,
	//  52536121, 98343562, 356769915, 89249181, 335191879}
	// {466274085, 20047757, 529015599, 246925926, 7318513,
	//  501969197, 178651118, 273209067, 71194923, 175279984,
	//  147453932, 241933889, 356935411, 226869216, 206654796,
	//  490676224, 444868783, 186442430, 453963164, 208020466}
	// 
	// Returns: 543212345
	// 
	// 
	// 
	// 5)
	// {42}
	// {42}
	// 
	// Returns: 84
	// 
	// Don't forget that the number Kris has thought of must be between 1 and 1,000,000,000.
	// 
	// 6)
	// {999900000}
	// {100001}
	// 
	// Returns: 999799999
	// 
	// Don't forget that the number Kris has thought of must be between 1 and 1,000,000,000.
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
