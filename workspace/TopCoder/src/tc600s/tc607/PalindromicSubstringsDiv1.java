package tc600s.tc607;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PalindromicSubstringsDiv1
{
	public double expectedPalindromes(String[] S1, String[] S2)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S1.length; i++) {
			sb.append(S1[i]);
		}
		for (int i = 0; i < S2.length; i++) {
			sb.append(S2[i]);
		}
		String str = sb.toString();
		int len = str.length();
		
		double sum = 0;
		//odd
		for (int m = 0; m < len; m++) { //center
			double exp = 1.0;
			for (int d = 0; 0 <= m-d && m+d < len; d++) {
				if (d > 0) {
					exp *= getExp(str.charAt(m-d), str.charAt(m+d));
				}
				sum += exp;
			}
		}
		//even
		for (int m = 1; m < len; m++) { //right
			double exp = 1.0;
			for (int d = 1; 0 <= m-d && m+d-1 < len; d++) {
				exp *= getExp(str.charAt(m-d), str.charAt(m+d-1));
				sum += exp;
			}
		}
		
		return sum;
	}
	
	public double getExp(char a, char b) {
		if (a == '?' || b == '?') {
			return 1.0 / 26.0;
		} else if (a != b) {
			return 0.0;
		} else {
			return 1.0;
		}
	}
	
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, boolean hasAnswer, double p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		PalindromicSubstringsDiv1 obj;
		double answer;
		obj = new PalindromicSubstringsDiv1();
		long startTime = System.currentTimeMillis();
		answer = obj.expectedPalindromes(p0, p1);
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
			res = answer == answer && Math.abs(p2 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p2));
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
		String[] p1;
		double p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new String[]{"a","a",""};
		p1 = new String[]{"a"};
		p2 = 6.0D;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"z??"};
		p1 = new String[]{};
		p2 = 3.115384615384615D;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"ab","c"};
		p1 = new String[]{"??","a?"};
		p2 = 7.315088757396449D;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{};
		p1 = new String[]{"?"};
		p2 = 1.0D;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{"ab?def","?"};
		p1 = new String[]{"f??a"};
		p2 = 12.545971779699588D;
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
	// Marco likes strings.
	// In particular, he likes strings that have a lot of palindromic substrings.
	// For example, he really likes the string "aaa" because it has 6 palindromic substrings: "a" occurs three times, "aa" occurs twice, and "aaa" occurs once.
	// 
	// Right now, Marco has a string S composed of lowercase letters and question marks.
	// You are to reconstruct S from the given String[]s S1 and S2 as follows:
	// 
	// Concatenate all elements of S1 to make a string A.
	// Concatenate all elements of S2 to make a string B.
	// Finally, concatenate A and B to get S.
	// 
	// 
	// 
	// Marco is going to replace every question mark in S with a random lowercase letter ('a' - 'z').
	// Return the expected number of palindromic substrings in the resulting string.
	// 
	// DEFINITION
	// Class:PalindromicSubstringsDiv1
	// Method:expectedPalindromes
	// Parameters:String[], String[]
	// Returns:double
	// Method signature:double expectedPalindromes(String[] S1, String[] S2)
	// 
	// 
	// NOTES
	// -For each question mark, the letter used to replace it is chosen uniformly at random. That is, the probability of choosing any particular letter is 1/26. All random choices are mutually independent.
	// -A palindromic string is a string that reads the same forwards and backwards.
	// -Your return value must have an absolute or a relative error of less than 1e-9.
	// 
	// 
	// CONSTRAINTS
	// -S1 and S2 will contain no more than 50 elements.
	// -Each element of S1 and S2 will contain no more than 50 characters.
	// -S will contain at least 1 character.
	// -S will contain only lowercase letters ('a' - 'z') and question marks ('?').
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"a","a",""}
	// {"a"}
	// 
	// Returns: 6.0
	// 
	// This is the example given in the statement.
	// 
	// 1)
	// {"z??"}
	// {}
	// 
	// Returns: 3.115384615384615
	// 
	// There are 26^2 = 676 equally likely possibilities for the letters used to replace the question marks.
	// Here are all possible outcomes:
	// 
	// The string "zzz" has 6 palindromic substrings.
	// Each of the 25 strings "zaz", "zbz", ..., "zyz" has 4 palindromic substrings.
	// Each of the 25 strings "zza", "zzb", ..., "zzy" has 4 palindromic substrings.
	// Each of the 25 strings "zaa", "zbb", ..., "zyy" has 4 palindromic substrings.
	// Each of the remaining 600 possible strings only has the 3 single-letter palindromic substrings.
	// 
	// The expected number of palindromic substrings can be computed simply as the average over all 676 possible cases.
	// Hence, the correct return value is (6 + 75*4 + 600*3) / 676.
	// 
	// 2)
	// {"ab","c"}
	// {"??","a?"}
	// 
	// Returns: 7.315088757396449
	// 
	// 
	// 
	// 3)
	// {}
	// {"?"}
	// 
	// Returns: 1.0
	// 
	// 
	// 
	// 4)
	// {"ab?def","?"}
	// {"f??a"}
	// 
	// Returns: 12.545971779699588
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!