package tc600s.tc624;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BuildingHeights
{
	public final int INF = 1<<30;
	public int minimum(int[] heights)
	{
		int[] a = new int[heights.length+1];
		Arrays.fill(a, INF);

		for (int i=0; i<heights.length; i++) {
			int[] minadd = new int[heights.length];
			Arrays.fill(minadd, INF);
			for (int j=0; j<heights.length; j++) {
				if (heights[i] - heights[j] >= 0) {
					minadd[j] = Math.min(minadd[j], heights[i] - heights[j]);
				}
			}
			Arrays.sort(minadd);
			int cum = 0;
			for (int j=0; j<heights.length; j++) {
				if (minadd[j] == INF) continue;
				cum += minadd[j];
				a[j] = Math.min(a[j], cum);
			}
		}
		
		int ret = a[0];
		for (int i=1; i<heights.length; i++) {
			ret ^= a[i];
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
		BuildingHeights obj;
		int answer;
		obj = new BuildingHeights();
		long startTime = System.currentTimeMillis();
		answer = obj.minimum(p0);
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
		p0 = new int[]{1,5,4,3,8};
		p1 = 22;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{1,2,3};
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{3,4,1,6,8,1};
		p1 = 21;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{990,20,2359,1667,51,2455,1659,1093,2015,205,656,752,1760,1594,857,2033,1868,1932,2408,1518,91,2220,1696,1552,933,143,1888,1261,2298,1975,929,2139,1994,2139,158,896,2093,1816,841,459,2020,1496,63,131,589,919,1015,1308,350,922,326,1792,641,2021,843,425,1015,231,1685,2165,1057,1465,655,550,1103,812,297,2048,1479,1137,6,2350,1484,1420,1332,925,2338,1198,2232,1539,2119,57,830,1611,929,525,888};
		p1 = 56068;
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
	// Byteland is a city with many skyscrapers, so it's a perfect venue for BASE jumping. Danilo is an enthusiastic BASE jumper. He plans to come to Byteland and to jump off some of its buildings.
	// 
	// Danilo can make arbitrarily many jumps in Byteland. However, he has some rules. First, he never jumps off the same building twice. Second, all buildings he selects for his jumps must have the same number of floors. (This is for safety reasons: It is hard to get the timing right if each jump starts at a different height.)
	// 
	// Philipe is the mayor of Byteland. He welcomes Danilo's visit as he would like to use it as a publicity stunt. Of course, the more jumps Danilo makes, the better the publicity will be. But what if there aren't enough buildings with the same height? To avoid this issue, the mayor is willing to prepare the town for Danilo's visit. Before Danilo arrives, Philipe wants to build additional floors on some of the skyscrapers in Byteland.
	// 
	// You are given a int[] heights. Each element of heights is the number of floors in one of Byteland's skyscrapers. Let N be the number of elements in heights. For each M between 1 and N, inclusive, answer the following question: What is the smallest number of additional floors the mayor has to build so that there will be at least M buildings with the same number of floors?
	// 
	// For each i between 1 and N, inclusive, let A[i] be the answer to the above question for M = i. Return the value (A[1] XOR A[2] XOR ... XOR A[N]).
	// 
	// DEFINITION
	// Class:BuildingHeights
	// Method:minimum
	// Parameters:int[]
	// Returns:int
	// Method signature:int minimum(int[] heights)
	// 
	// 
	// NOTES
	// -You may assume that the correct return value always fits into a signed 32-bit integer variable.
	// -Each question should be answered independently of the others. For example, when trying to produce four buildings with the same number of floors, you do not have to start from the optimal solution for three buildings.
	// 
	// 
	// CONSTRAINTS
	// -heights contains between 1 and 4,000 elements, inclusive.
	// -Each element of heights will be between 1 and 4,000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1, 5, 4, 3, 8}
	// 
	// Returns: 22
	// 
	// 
	// Danilo can jump off a building without any changes to the city.
	// To get two equally tall buildings we need to build one additional floor. For example, we can increase building #2 (0-based index) from 4 to 5 floors.
	// To get three equally tall buildings we need to build three additional floors: one on building #2 and two on building #3. This way, the buildings #1, #2, and #3 will have 5 floors each.
	// To get four equally tall buildings we need to build seven additional floors.
	// Making all five buildings equally tall requires us to build 19 additional floors.
	// 
	// 
	// 
	// 1)
	// {1, 2, 3}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 2)
	// {3, 4, 1, 6, 8, 1}
	// 
	// Returns: 21
	// 
	// 
	// 
	// 3)
	// {990, 20, 2359, 1667, 51, 2455, 1659, 1093, 2015, 205, 656, 752, 1760, 1594, 857,
	//  2033, 1868, 1932, 2408, 1518, 91, 2220, 1696, 1552, 933, 143, 1888, 1261, 2298, 1975,
	//  929, 2139, 1994, 2139, 158, 896, 2093, 1816, 841, 459, 2020, 1496, 63, 131, 589, 919,
	//  1015, 1308, 350, 922, 326, 1792, 641, 2021, 843, 425, 1015, 231, 1685, 2165, 1057,
	//  1465, 655, 550, 1103, 812, 297, 2048, 1479, 1137, 6, 2350, 1484, 1420, 1332, 925, 2338,
	//  1198, 2232, 1539, 2119, 57, 830, 1611, 929, 525, 888}
	// 
	// Returns: 56068
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!