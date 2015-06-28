package tc500s.tc591;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TheTree
{
	public int maximumDiameter(int[] cnt)
	{
		int len = cnt.length;
		
		int ret = 0;
		int temp = 0;
		for (int i = len - 1; i >= 0; i--) {
			temp += 1;
			if (cnt[i] > 1) {
				ret = Math.max(ret, temp + goDown(i, cnt));
			}
		}
		return ret = Math.max(ret, temp);
	}
	
	public int goDown(int n, int[] cnt) {
		int ret = 0;
		for (int i = n; i < cnt.length; i++) {
			if (cnt[i] == 1) break;
			ret += 1;
		}
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		TheTree obj;
		int answer;
		obj = new TheTree();
		long startTime = System.currentTimeMillis();
		answer = obj.maximumDiameter(p0);
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
		
		int[] p0;
		int p1;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{3};
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{2,2};
		p1 = 4;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{4,1,2,4};
		p1 = 5;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{4,2,1,3,2,5,7,2,4,5,2,3,1,13,6};
		p1 = 21;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
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
	// Manao is working in the Tree Research Center.
	// It may come as a surprise that the trees they research are not the ones you can see in a park.
	// Instead, they are researching special graphs.
	// (See Notes for definitions of terms related to these trees.)
	// 
	// Manao's daily job is reconstructing trees, given some partial information about them.
	// Today Manao faced a difficult task.
	// He needed to find the maximum possible diameter of a tree, given the following information:
	// 
	// 
	// Some vertex in the tree is called V.
	// The distance between V and the farthest vertex from V is D.
	// For each x between 1 and D, inclusive, Manao knows the number of vertices such that their distance from V is x.
	// 
	// 
	// You are given a int[] cnt containing D strictly positive integers.
	// For each i, the i-th element of cnt is equal to the number of vertices which have distance i+1 from V.
	// Please help Manao with his task.
	// Return the maximum possible diameter of a tree that matches the given information.
	// 
	// 
	// DEFINITION
	// Class:TheTree
	// Method:maximumDiameter
	// Parameters:int[]
	// Returns:int
	// Method signature:int maximumDiameter(int[] cnt)
	// 
	// 
	// NOTES
	// -A tree is a connected graph with no cycles. Note that each tree with N vertices has precisely N-1 edges.
	// -The distance between two vertices of a tree is the smallest number of edges one has to traverse in order to get from one of the vertices to the other one.
	// -The diameter of a tree is the maximum of all pairwise distances. In other words, the diameter is the distance between the two vertices that are the farthest away from each other.
	// 
	// 
	// CONSTRAINTS
	// -cnt will contain between 1 and 50 elements, inclusive.
	// -Each element of cnt will be between 1 and 1000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {3}
	// 
	// Returns: 2
	// 
	// The only tree that matches the given information is shown below. The vertex V is red.
	// 
	// 
	// 
	// 
	// 1)
	// {2, 2}
	// 
	// Returns: 4
	// 
	// There are two trees which correspond to the given partial information:
	// 
	// 
	// 
	// The tree on the left has diameter 3 and the tree on the right has diameter 4.
	// 
	// 2)
	// {4, 1, 2, 4}
	// 
	// Returns: 5
	// 
	// This is one example of a tree that corresponds to the given constraints and has the largest possible diameter.
	// 
	// 
	// 
	// 3)
	// {4, 2, 1, 3, 2, 5, 7, 2, 4, 5, 2, 3, 1, 13, 6}
	// 
	// Returns: 21
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
