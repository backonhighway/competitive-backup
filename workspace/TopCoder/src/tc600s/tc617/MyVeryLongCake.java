package tc600s.tc617;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class MyVeryLongCake
{
	public int cut(int n)
	{
		List<Integer> list = getPrimeDivisor(n);
		int rem = n;
		for (int i : list) {
			rem -= rem/i;
		}
		return n - rem;
	}
	
	public List<Integer> getPrimeDivisor(int n){ //O(rootn)
		List<Integer> list = new ArrayList<>();
		for(int i=2; i*i<=n; i++){
			if (n % i == 0) list.add(i);
			while (n % i == 0) {
				n /= i;
			}
		}
		if (n != 1) list.add(n); //n is prime
		return list;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + p0);
		System.out.println("]");
		MyVeryLongCake obj;
		int answer;
		obj = new MyVeryLongCake();
		long startTime = System.currentTimeMillis();
		answer = obj.cut(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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
		
		// ----- test 0 -----
		disabled = false;
		p0 = 6;
		p1 = 4;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 3;
		p1 = 1;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 15;
		p1 = 7;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 1000000000;
		p1 = 600000000;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = 577007436;
		p1 = 384671628;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
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
	// You have a long thin cake. For simplicity, we can consider the cake to be one-dimensional. The length of the cake is n. 
	// 
	// You are expecting some friends. You are going to cut the cake into multiple pieces before the friends arrive.
	// 
	// When the friends arrive, you will divide the cake among them, using the following procedure: starting at the beginning of the cake, you will first give some consecutive pieces to your first friend, then some consecutive pieces to your second friend, and so on.
	// 
	// Of course, you want to be fair. That is, each of your friends should receive the same total amount of cake. (The number of pieces may be different for different friends, but the sum of their lengths must be the same.)
	// 
	// As we stated above, you want to cut the cake before your friends arrive. However, you don't know how many friends will actually come. You only know that their count will be a divisor of n smaller than n.
	// 
	// You are given the int n. You want to cut the cake in such a way that for each valid number of friends it will be possible to give each of them the same amount of cake when using the above procedure. Return the smallest possible number of pieces after you cut the cake.
	// 
	// DEFINITION
	// Class:MyVeryLongCake
	// Method:cut
	// Parameters:int
	// Returns:int
	// Method signature:int cut(int n)
	// 
	// 
	// CONSTRAINTS
	// -n will be between 2 and 1,000,000,000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 6
	// 
	// Returns: 4
	// 
	// The best possible solution is to cut the cake into 4 pieces. Let's call the pieces A, B, C, and D, in order. Their lengths will be 2, 1, 1, and 2.
	// 
	// As n=6, there will be 1, 2, or 3 friends. If there is just one friend, she gets all four pieces. If there are two friends, the first gets A+B and the second gets C+D. If there are three friends, the first gets A, the second gets B+C, and the third gets D.
	// 
	// Note that the order of parts matters. For example, dividing the cake into parts of length 2, 1, 2, and 1 is not a valid solution.
	// 
	// 1)
	// 3
	// 
	// Returns: 1
	// 
	// In this case, the only possible number of friends that will come to your house is 1. Hence, you don't even need to cut the cake, simply leave it in one piece.
	// 
	// 2)
	// 15
	// 
	// Returns: 7
	// 
	// You are expecting 1, 3, or 5 friends.
	// 
	// 3)
	// 1000000000
	// 
	// Returns: 600000000
	// 
	// 
	// 
	// 4)
	// 577007436
	// 
	// Returns: 384671628
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!