package tc600s.tc616;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class WakingUp
{
	public final int INF = 1<<30;
	public int maxSleepiness(int[] period, int[] start, int[] volume, int D)
	{
		int sim = 10000;
		int len = period.length;
		int sum = 0;
		int min = 0;
		for (int i = 1; i < sim; i++) {
			sum += D;
			for (int j = 0; j < len; j++) {
				sum -= getVol(i, period[j], start[j], volume[j]);
			}
			min = Math.min(min, sum);
		}
		int min2 = min;
		for (int i = sim; i < sim * 2; i++) {
			sum += D;
			for (int j = 0; j < len; j++) {
				sum -= getVol(i, period[j], start[j], volume[j]);
			}
			min2 = Math.min(min2, sum);
		}
		int ret;
		if (min <= 0) {
			if (min <= min2) {
				ret = -min;
			} else {
				ret = -1;
			}
		} else {
			ret = -1;
		}
		
		return ret;
	}
	
	public int getVol(int now, int p, int s, int v) {
		boolean rings = (now - s) % p == 0; 
		return rings ? v : 0;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, int p3, boolean hasAnswer, int p4) {
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
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + p3);
		System.out.println("]");
		WakingUp obj;
		int answer;
		obj = new WakingUp();
		long startTime = System.currentTimeMillis();
		answer = obj.maxSleepiness(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p4;
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
		int[] p2;
		int p3;
		int p4;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{2,3};
		p1 = new int[]{1,2};
		p2 = new int[]{3,4};
		p3 = 3;
		p4 = 2;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{1};
		p1 = new int[]{1};
		p2 = new int[]{17};
		p3 = 17;
		p4 = 0;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{2};
		p1 = new int[]{1};
		p2 = new int[]{2};
		p3 = 1;
		p4 = 1;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{9,2,5,5,7};
		p1 = new int[]{6,1,4,1,6};
		p2 = new int[]{71,66,7,34,6};
		p3 = 50;
		p4 = 78;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{5,6,5,3,8,3,4};
		p1 = new int[]{1,1,3,2,6,3,3};
		p2 = new int[]{42,85,10,86,21,78,38};
		p3 = 88;
		p4 = -1;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) ) && all_right;
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
	// Alex is sleeping soundly. At any minute T, his sleepiness can be characterized by an integer. Initially, at minute 0, Alex's sleepiness is some unknown integer S.
	// 
	// Unfortunately, there are several repeatedly ringing alarms disturbing him.
	// 
	// Starting from minute 1, the following happens each minute. First, Alex's sleepiness increases by D. Then some of the alarms ring, decreasing Alex's sleepiness.
	// 
	// Formally, alarms' characteristics are given in three int[]s period, start and volume. The i-th alarm rings at minutes start[i], start[i] + period[i], start[i] + 2 * period[i], etc., and each time it rings, Alex's sleepiness instantly decreases by volume[i]. If several alarms ring at the same minute, their effects are added up, so each of them decreases Alex's sleepiness by its volume.
	// 
	// While Alex's sleepiness is positive, he's still sleeping. Once it becomes less than or equal to zero, Alex immediately wakes up. Note that Alex's initial sleepiness can be non-positive. In that case he just wakes up at minute 0.
	// 
	// You are given the int[]s period, start, volume, and the int D. Return the largest possible value of S (Alex's initial sleepiness) such that he will wake up at some moment. If he is guaranteed to wake up for all possible values of S, return -1 instead.
	// 
	// 
	// DEFINITION
	// Class:WakingUp
	// Method:maxSleepiness
	// Parameters:int[], int[], int[], int
	// Returns:int
	// Method signature:int maxSleepiness(int[] period, int[] start, int[] volume, int D)
	// 
	// 
	// NOTES
	// -It is possible to prove that the answer for any test case fits into a 32-bit signed integer type.
	// 
	// 
	// CONSTRAINTS
	// -period will contain between 1 and 50 elements, inclusive.
	// -period, start and volume will contain the same number of elements.
	// -Each element of period will be between 1 and 10, inclusive.
	// -start[i] will be between 1 and period[i], inclusive.
	// -Each element of volume will be between 1 and 1000, inclusive.
	// -D will be between 1 and 100, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {2, 3}
	// {1, 2}
	// {3, 4}
	// 3
	// 
	// Returns: 2
	// 
	// There are two alarms. The first alarm rings every 2 minutes, starting from minute 1, and has volume 3. The second alarm rings every 3 minutes, starting from minute 2, and has volume 4.
	// 
	// Here is what would happen for S = 2:
	// 
	// 
	// At minute 0, Alex's sleepiness is 2.
	// At minute 1, Alex's sleepiness increases to 5. Then the first alarm rings, decreasing his sleepiness to 2.
	// At minute 2, Alex's sleepiness increases to 5. Then the second alarm rings, decreasing his sleepiness to 1.
	// At minute 3, Alex's sleepiness increases to 4. Then the first alarm rings, decreasing his sleepiness to 1.
	// At minute 4, Alex's sleepiness increases to 4. No alarm rings at this minute.
	// At minute 5, Alex's sleepiness increases to 7. Then both alarms ring, decreasing his sleepiness to 0, so he wakes up.
	// 
	// 
	// It can be proven that for any larger S, Alex will never wake up.
	// 
	// 
	// 1)
	// {1}
	// {1}
	// {17}
	// 17
	// 
	// Returns: 0
	// 
	// For any positive S, Alex will never wake up. It's better not to fall asleep.
	// 
	// 2)
	// {1}
	// {1}
	// {23}
	// 17
	// 
	// Returns: -1
	// 
	// Each minute Alex's sleepiness decreases by 6. That means he will wake up at some moment, regardless of the initial sleepiness.
	// 
	// 3)
	// {9, 2, 5, 5, 7}
	// {6, 1, 4, 1, 6}
	// {71, 66, 7, 34, 6}
	// 50
	// 
	// Returns: 78
	// 
	// 
	// 
	// 4)
	// {5, 6, 5, 3, 8, 3, 4}
	// {1, 1, 3, 2, 6, 3, 3}
	// {42, 85, 10, 86, 21, 78, 38}
	// 88
	// 
	// Returns: -1
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
