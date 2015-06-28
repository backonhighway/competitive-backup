package tc600s.tc622;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BuildingRoutes
{
	public int build(String[] dist, int T)
	{
		int len = dist.length;
		int[][] d = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				d[i][j] = (int) dist[i].charAt(j) - 48;
			}
		}
		
		// Warshall-Floyd
		for (int k = 0; k < len; k++) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
		
		// for each pair(a,b) can (x,y) be used?
		int[][] count = new int[len][len]; 
		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len; b++) {
				for (int x = 0; x < len; x++) {
					for (int y = 0; y < len; y++) {
						int originald = (int) dist[x].charAt(y) - 48;
						if (d[a][x] + originald + d[y][b] == d[a][b]) {
							count[x][y] ++;
						}
					}
				}
			}
		}
		
		int ret = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (count[i][j] >= T) {
					ret += d[i][j];
				}
			}
		}
		
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		BuildingRoutes obj;
		int answer;
		obj = new BuildingRoutes();
		long startTime = System.currentTimeMillis();
		answer = obj.build(p0, p1);
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
		
		String[] p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new String[]{"011","101","110"};
		p1 = 1;
		p2 = 6;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"033","309","390"};
		p1 = 1;
		p2 = 12;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"0123","1023","1203","1230"};
		p1 = 2;
		p2 = 5;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"05789654","10347583","65085479","55602398","76590934","57939045","12345608","68647640"};
		p1 = 3;
		p2 = 40;
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
	// In the Republic of Nlogonia there are N cities.
	// For convenience, the cities are numbered 0 through N-1.
	// For each two different cities i and j, there is a direct one-way road from i to j.
	// You are given the lengths of those roads as a String[] dist with N elements, each with N characters.
	// For each i and j, the character dist[i][j] represents the length of the road from i to j.
	// 
	// The lengths of roads are integers between 1 and 9, inclusive, and they are represented by digits '1' through '9'.
	// That is, for distinct i and j, dist[i][j] will be between '1' and '9'.
	// For each i, dist[i][i] will be '0'.
	// Note that the roads from i to j and from j to i may have different lengths.
	// 
	// Every year on Algorithms Day (the most important holiday in Nlogonia) people travel between the cities.
	// More precisely, for each pair of distinct cities i and j, one full bus of people travels from i to j.
	// Each of those buses drives along a shortest path from its origin to its destination.
	// If there are multiple shortest paths, the bus driver picks one of them arbitrarily.
	// 
	// The roads in Nlogonia are currently limited.
	// You are given an int T with the following meaning: 
	// each of the current roads is only safe if it is guaranteed that there will be strictly fewer than T buses driving along the road.
	// In other words, a road is unsafe if it is possible that T or more buses will use it.
	// The government wants to rebuild all unsafe roads before the next Algorithms Day.
	// Return the sum of lengths of all unsafe roads.
	// 
	// DEFINITION
	// Class:BuildingRoutes
	// Method:build
	// Parameters:String[], int
	// Returns:int
	// Method signature:int build(String[] dist, int T)
	// 
	// 
	// CONSTRAINTS
	// -N will be between 2 and 50, inclusive.
	// -dist will contain exactly N elements.
	// -Each element of dist will contain exactly N characters.
	// -For each i, dist[i][i] will be '0'.
	// -For each pair of distinct i and j, dist[i][j] will be between '1' and '9', inclusive.
	// -T will be between 1 and 2500, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"011",
	//  "101",
	//  "110"}
	// 1
	// 
	// Returns: 6
	// 
	// As T=1, a road is unsafe as soon as it is possible that a bus will use it. 
	// Each of the six roads in this test case belongs to some shortest path, hence each of them is unsafe
	// 
	// 1)
	// {"033",
	//  "309",
	//  "390"}
	// 1
	// 
	// Returns: 12
	// 
	// The roads 1->2 and 2->1 (the two roads of length 9) will not be used by any bus.
	// Only the four remaining roads are unsafe in this case.
	// 
	// 2)
	// {"0123",
	//  "1023",
	//  "1203",
	//  "1230"}
	// 2
	// 
	// Returns: 5
	// 
	// 
	// 
	// 3)
	// {"05789654",
	//  "10347583",
	//  "65085479",
	//  "55602398",
	//  "76590934",
	//  "57939045",
	//  "12345608",
	//  "68647640"}
	// 3
	// 
	// Returns: 40
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
