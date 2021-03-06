package tc500s.tc599;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BigFatInteger
{
	public int minOperations(int A, int B)
	{
		HashMap<Integer, Integer> map = primeDivisor(A);
		int ret = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ret = Math.max(ret, getMoves((double)entry.getValue() * B));
		}
		ret += map.size() - 1;
		return ret;
	}
	
	public int getMoves(double n) {
		int count = 0;
		while (n != 1.0) {
			n = Math.ceil(n / 2.0);
			count++;
		}
		return count + 1;
	}
	
	public HashMap<Integer, Integer> primeDivisor(int n){ //O(n)
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=2; i<=n; i++){
			while (n%i==0) {
				if (!map.containsKey(i)) {
					map.put(i, 1);
				} else {
					map.put(i, map.get(i) + 1);
				}
				n /= i;
			}
		}
		return map;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		BigFatInteger obj;
		int answer;
		obj = new BigFatInteger();
		long startTime = System.currentTimeMillis();
		answer = obj.minOperations(p0, p1);
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
		
		int p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 6;
		p1 = 1;
		p2 = 2;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 162;
		p1 = 1;
		p2 = 4;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 999983;
		p1 = 9;
		p2 = 5;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 360;
		p1 = 8;
		p2 = 8;
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
	// This problem statement contains superscipts that may not display properly outside the applet.
	// 
	// Lun the dog loves very large integers. Her favorite is AB (A to the power of B).
	// 
	// 
	// She has an integer variable X. Initially, the value of X is set to 1. She can perform the following two kinds of operations in any order, any number of times.
	// 
	// Operation 1: choose a prime number p, then multiply X by p.
	// Operation 2: choose a positive divisor d of the value of X at that point, then multiply X by d.
	// 
	// 
	// 
	// You are given two ints A and B. Return the minimum number of operations Lun needs to perform
	// in order to obtain X = AB from the initial state X = 1.
	// 
	// DEFINITION
	// Class:BigFatInteger
	// Method:minOperations
	// Parameters:int, int
	// Returns:int
	// Method signature:int minOperations(int A, int B)
	// 
	// 
	// CONSTRAINTS
	// -A will be between 2 and 1,000,000 (106), inclusive.
	// -B will be between 1 and 1,000,000 (106), inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 6
	// 1
	// 
	// Returns: 2
	// 
	// Here, AB = 61 = 6. Here is one of the optimal sequences of operations:
	// 
	// Perform operation 1 by choosing p=2. X is now 1*2 = 2.
	// Perform operation 1 by choosing p=3. X is now 2*3 = 6.
	// 
	// 
	// 1)
	// 162
	// 1
	// 
	// Returns: 4
	// 
	// One of the optimal sequences of operations:
	// 
	// Perform operation 1 by choosing p=3. X is now 1*3 = 3.
	// Perform operation 1 by choosing p=3. X is now 3*3 = 9.
	// Perform operation 2 by choosing d=9. X is now 9*9 = 81.
	// Perform operation 1 by choosing p=2. X is now 81*2 = 162.
	// 
	// 
	// 2)
	// 999983
	// 9
	// 
	// Returns: 5
	// 
	// Here, A is prime. One of the optimal sequences of operations:
	// 
	// Perform operation 1 by choosing p=A. X is now A.
	// Perform operation 1 by choosing p=A. X is now A2.
	// Perform operation 1 by choosing p=A. X is now A3.
	// Perform operation 2 by choosing d=A3. X is now A6.
	// Perform operation 2 by choosing d=A3. X is now A9.
	// 
	// 
	// 3)
	// 360
	// 8
	// 
	// Returns: 8
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
