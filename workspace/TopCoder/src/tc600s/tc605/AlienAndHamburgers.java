package tc600s.tc605;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class AlienAndHamburgers
{
	public static final int INF = 1_000_000_000;
	public int getNumber(int[] type, int[] taste)
	{
		int[] typemax = new int[101];
		Arrays.fill(typemax, -INF);
		int len = type.length;
		
		//take all positive
		int tastesum = 0;
		for (int i = 0; i < len; i++) {
			if (taste[i] >= 0) {
				tastesum += taste[i];
				typemax[type[i]] = taste[i];
			}
		}
		int typecount = 0;
		for (int i = 0; i < typemax.length; i++) {
			if (typemax[i] != -INF) typecount++;
		}
		int sum = typecount * tastesum;
		
		//take increasing negative
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (taste[i] < 0 && taste[i] > typemax[type[i]]) {
				list.remove(Integer.valueOf(typemax[type[i]]));
				list.add(taste[i]);
				typemax[type[i]] = taste[i];
			}
		}
		Collections.sort(list, Comparator.reverseOrder());
		for (int t : list) {
			if ((typecount+1) * (tastesum+t) > sum) {
				typecount++;
				tastesum += t;
				sum = typecount * tastesum;
			}
		}
		return sum;
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
		AlienAndHamburgers obj;
		int answer;
		obj = new AlienAndHamburgers();
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
		p0 = new int[]{1,2};
		p1 = new int[]{4,7};
		p2 = 22;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{1,1};
		p1 = new int[]{-1,-1};
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{1,2,3};
		p1 = new int[]{7,4,-1};
		p2 = 30;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{1,2,3,2,3,1,3,2,3,1,1,1};
		p1 = new int[]{1,7,-2,3,-4,-1,3,1,3,-5,-1,0};
		p2 = 54;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{30,20,10};
		p1 = new int[]{100000,-100000,100000};
		p2 = 400000;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{18, 4, 29, 38, 98, 46, 22, 31, 36, 77, 2, 91, 32, 62, 85, 5, 41, 77, 87, 86, 22, 38, 19, 47, 73, 78, 22, 49, 59, 73, 42, 71, 6, 22, 77, 20, 40, 5, 43};
		p1 = new int[]{-95929, -20247, -16930, -23102, -3631, 9730, 79498, 89280, 61680, 28355, -32337, -89897, 69331, -34638, -1407, -89899, 93620, 97350, 72452, 35505, -41564, -10552, -52729, -89549, -8728, 29689, 41012, -73449, -71143, -67902, 44435, -83504, -74404, -86814, 38628, -68284, -81822, -81364, -38733};
		p2 = 12579805;
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
	// 
	// Alien Fred wants to destroy the Earth.
	// But before he does that, he wants to eat some hamburgers.
	// 
	// 
	// 
	// 
	// You are given two int[]s: type and taste.
	// They describe all hamburgers available in the shop he found.
	// Each hamburger has a type (some positive integer) and a taste (some, possibly negative, integer).
	// For each i, type[i] represents the type of i-th hamburger (0-based index), and taste[i] represents the taste of i-th hamburger.
	// It is possible that different hamburgers have the same type but a different taste.
	// 
	// 
	// 
	// 
	// Fred wants to eat some subset of those hamburgers (possibly none or all of them).
	// Eating the chosen hamburgers will give him some amount of joy.
	// This amount can be computed as Y * A, where Y is the number of different types of hamburgers eaten, and A is their total taste.
	// 
	// 
	// 
	// 
	// Return the largest possible amount of joy he can get.
	// 
	// 
	// DEFINITION
	// Class:AlienAndHamburgers
	// Method:getNumber
	// Parameters:int[], int[]
	// Returns:int
	// Method signature:int getNumber(int[] type, int[] taste)
	// 
	// 
	// CONSTRAINTS
	// -type will contain between 1 and 50 elements, inclusive.
	// -type and taste will contain the same number of elements.
	// -Each element of type will be between 1 and 100, inclusive.
	// -Each element of taste will be between -100,000 and 100,000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1, 2}
	// {4, 7}
	// 
	// Returns: 22
	// 
	// In this case, the best choice is to choose both hamburgers. The number of different types is 2, and the total taste is 11. Thus, the answer is 2*11 = 22.
	// 
	// 1)
	// {1, 1}
	// {-1, -1}
	// 
	// Returns: 0
	// 
	// Note that sometimes the best choice is not to eat any hamburgers. In such a case the amount of joy is 0.
	// 
	// 2)
	// {1, 2, 3}
	// {7, 4, -1}
	// 
	// Returns: 30
	// 
	// 
	// 
	// 3)
	// {1, 2, 3, 2, 3, 1, 3, 2, 3, 1, 1, 1}
	// {1, 7, -2, 3, -4, -1, 3, 1, 3, -5, -1, 0}
	// 
	// Returns: 54
	// 
	// 
	// 
	// 4)
	// {30, 20, 10}
	// {100000, -100000, 100000}
	// 
	// Returns: 400000
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
