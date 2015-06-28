package tc600s.tc614;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class MinimumSquare
{
	public final long INF = 1L<<62;
	public long minArea(int[] x, int[] y, int K)
	{
		int len = x.length;
		long area = INF;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				List<Integer> list = new ArrayList<>();
				for (int l = 0; l < len; l++) {
					if (x[l] >= x[i] && y[l] >= y[j]) {
						list.add(Math.max(x[l]-x[i], y[l]-y[j]));
					}
				}
				Collections.sort(list);
				if (list.size() < K) continue;
				int l = list.get(K-1);
				long newarea = (long)(l+2) * (long)(l+2);
				area = Math.min(area, newarea);
			}
		}
		return area;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, long p3) {
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
		System.out.print("}" + "," + p2);
		System.out.println("]");
		MinimumSquare obj;
		long answer;
		obj = new MinimumSquare();
		long startTime = System.currentTimeMillis();
		answer = obj.minArea(p0, p1, p2);
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
		
		int[] p0;
		int[] p1;
		int p2;
		long p3;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{0,3};
		p1 = new int[]{0,7};
		p2 = 2;
		p3 = 81L;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{-4,3,1};
		p1 = new int[]{3,-1,-2};
		p2 = 2;
		p3 = 16L;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{0,0,1,1,2,2};
		p1 = new int[]{0,1,0,1,0,1};
		p2 = 4;
		p3 = 9L;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{1000000000,1000000000,1000000000,-1000000000,-1000000000,-1000000000};
		p1 = new int[]{1000000000,0,-1000000000,1000000000,0,-1000000000};
		p2 = 3;
		p3 = 4000000008000000004L;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{-47881,28623,1769,-38328,-16737,16653,-23181,37360,41429,26282,254,728,8299,-41080,-29498,17488,-23937,-11,33319,25232};
		p1 = new int[]{-46462,48985,-43820,-19587,-33593,-28337,13667,-48131,-5568,-2332,-41918,-31370,-3695,42599,-37788,-40096,39049,25045,-2122,3874};
		p2 = 8;
		p3 = 1695545329L;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, true, p3) ) && all_right;
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
	// There are N points in the plane. You are given their description as two int[]s, x and y, with N elements each. The N points have coordinates (x[0],y[0]), (x[1],y[1]), ..., (x[N-1],y[N-1]).
	// 
	// You want to draw a single square onto the plane. The vertices of the square must have integer coordinates, and the sides of the square must be parallel to the coordinate axes. There is one additional constraint: at least K of the N given points must lie strictly inside the square (i.e., not on its boundary).
	// 
	// You are given x, y, and the int K. Return the smallest possible area of a square that satisfies the constraints above.
	// 
	// DEFINITION
	// Class:MinimumSquare
	// Method:minArea
	// Parameters:int[], int[], int
	// Returns:long
	// Method signature:long minArea(int[] x, int[] y, int K)
	// 
	// 
	// CONSTRAINTS
	// -x will contain between 2 and 100 elements, inclusive.
	// -y will contain the same number of elements as x.
	// -K will be between 1 and the number of elements in x, inclusive.
	// -All points will be pairwise distinct.
	// -Each element of x will be between -1,000,000,000 and 1,000,000,000, inclusive.
	// -Each element of y will be between -1,000,000,000 and 1,000,000,000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {0, 3}
	// {0, 7}
	// 2
	// 
	// Returns: 81
	// 
	// The square we seek must contain both given points. One optimal solution is the square with opposite corners at (-1,-1) and (8,8).
	// 
	// 1)
	// {-4, 3, 1}
	// {3 , -1, -2}
	// 2
	// 
	// Returns: 16
	// 
	// 
	// 
	// 2)
	// {0, 0, 1, 1, 2, 2}
	// {0, 1, 0, 1, 0, 1}
	// 4
	// 
	// Returns: 9
	// 
	// 
	// 
	// 3)
	// {1000000000, 1000000000, 1000000000, -1000000000, -1000000000, -1000000000}
	// {1000000000, 0, -1000000000, 1000000000, 0, -1000000000}
	// 3
	// 
	// Returns: 4000000008000000004
	// 
	// In this case one of the optimal solutions is a square that contains all six points.
	// 
	// 4)
	// {-47881, 28623, 1769, -38328, -16737, 16653, -23181, 37360, 41429, 26282, 254, 728, 8299, -41080, -29498, 17488, -23937, -11, 33319, 25232}
	// {-46462, 48985, -43820, -19587, -33593, -28337, 13667, -48131, -5568, -2332, -41918, -31370, -3695, 42599, -37788, -40096, 39049, 25045, -2122, 3874}
	// 8
	// 
	// Returns: 1695545329
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
