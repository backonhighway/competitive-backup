package tc600s.tc637;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class GreaterGame
{
	public final int INF = 1<<30;
	
	public double calc(int[] hand, int[] sothe)
	{
		double ret = 0;
		int len = hand.length;
		boolean[] used = new boolean[len];
		
		// fill the solid
		for (int i=0; i<len; i++) {
			if (sothe[i] == -1) continue;
			
			// pick lowest winner
			int min = INF;
			int pos = -1;
			for (int j=0; j<len; j++) {
				if(hand[j] > sothe[i] && !used[j] && hand[j] < min) {
					min = hand[j];
					pos = j;
				}
			}
			if (min != INF) {
				used[pos] = true;
				ret += 1;
				continue;
			}
			
			// pick lowest loser
			min = INF;
			pos = -1;
			for (int j=0; j<len; j++) {
				if (!used[j] && hand[j] < min) {
					min = hand[j];
					pos = j;
				}
			}
			used[pos] = true;
		}
		System.out.println(Arrays.toString(used));
		
		// get the -1 hands
		List<Integer> sotheHands = new ArrayList<>();
		for (int i=1; i<=2*len; i++) {
			boolean appears = false;
			for (int j=0; j<len; j++) {
				if (hand[j] == i || sothe[j] == i) {
					appears = true;
					break;
				}
			}
			if (!appears) sotheHands.add(i);
		}
		
		// calculate the unknown
		for (int sotheHand : sotheHands) {
			int wincount = 0;
			int losecount = 0;
			for (int j=0; j<len; j++) {
				if (used[j]) continue;
				if (sotheHand > hand[j]) {
					losecount++;
				} else {
					wincount++;
				}
			}
			if (wincount + losecount != 0) {
				ret += (double) wincount / (double) (wincount + losecount);
			}
		}
		
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, double p2) {
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
		GreaterGame obj;
		double answer;
		obj = new GreaterGame();
		long startTime = System.currentTimeMillis();
		answer = obj.calc(p0, p1);
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
		
		int[] p0;
		int[] p1;
		double p2;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{4,2};
		p1 = new int[]{-1,-1};
		p2 = 1.5D;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{4,2};
		p1 = new int[]{1,3};
		p2 = 2.0D;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{2};
		p1 = new int[]{-1};
		p2 = 1.0D;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{1,3,5,7};
		p1 = new int[]{8,-1,4,-1};
		p2 = 2.5D;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{6,12,17,14,20,8,16,7,2,15};
		p1 = new int[]{-1,-1,4,-1,11,3,13,-1,-1,18};
		p2 = 8.0D;
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
	// Cat Snuke and wolf Sothe are playing the Greater Game.
	// The game is played with cards.
	// Each card has a number written on it.
	// There are 2N cards.
	// The numbers on the cards are the integers between 1 and 2N, inclusive.
	// 
	// At the beginning of the game, each player gets N of the cards and chooses the order in which he wants to play them.
	// The game then consists of N turns.
	// In each turn, both players play one of their cards simultaneously.
	// The player who revealed the card with the larger number gets a point.
	// 
	// You are given a int[] hand.
	// The elements of hand are the numbers on Snuke's cards.
	// He can play those cards in any order he chooses.
	// 
	// Obviously, Snuke can determine the numbers on Sothe's cards, but he does not necessarily know the order in which Sothe is going to play his cards.
	// You are given the information Snuke has about Sothe in a int[] sothe.
	// For each i, element i of sothe is either the number on the card Sothe will play in turn i (0-based index), or -1 if Snuke does not know the card Sothe will play in that turn.
	// 
	// Snuke wants to play according to a strategy that maximizes the expected number of points he'll get.
	// Find that strategy and return the corresponding expected number of Snuke's points at the end of the game.
	// 
	// As shown in Example 0, the optimal strategy for Snuke may involve some random decisions.
	// However, note that before the game starts Snuke must choose the order in which he is going to play all his cards.
	// He is not allowed to change their order after he sees some of the cards played by Sothe.
	// 
	// DEFINITION
	// Class:GreaterGame
	// Method:calc
	// Parameters:int[], int[]
	// Returns:double
	// Method signature:double calc(int[] hand, int[] sothe)
	// 
	// 
	// CONSTRAINTS
	// -N will be between 1 and 50, inclusive.
	// -hand and sothe will contain exactly N elements each.
	// -Each element of hand will be an integer between 1 and 2N, inclusive.
	// -Each element of sothe will be either -1, or an integer between 1 and 2N, inclusive.
	// -The positive integers in hand and sothe will be distinct.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {4,2}
	// {-1,-1}
	// 
	// Returns: 1.5
	// 
	// Sothe will play the cards 1 and 3 in some unknown order.
	// The best strategy for Snuke is to flip a coin and to play his cards either in the order {2,4} or in the order {4,2} with equal probability.
	// This leads to two equally likely results of the game:
	// 
	// Snuke plays his 2 against Sothe's 1, and his 4 against Sothe's 3. In this case, Snuke wins both turns and thus scores 2 points.
	// Snuke plays his 2 against Sothe's 3, and his 4 against Sothe's 1. In this case, Snuke scores 1 point.
	// 
	// Therefore, the expected number of Snuke's points is 1.5.
	// 
	// 1)
	// {4,2}
	// {1,3}
	// 
	// Returns: 2.0
	// 
	// If Snuke plays card 2 first and card 4 next, he is guaranteed to score 2 points.
	// 
	// 2)
	// {2}
	// {-1}
	// 
	// Returns: 1.0
	// 
	// Sothe's only card has to be 1, and thus Snuke is guaranteed to win the only turn of this game.
	// 
	// 3)
	// {1,3,5,7}
	// {8,-1,4,-1}
	// 
	// Returns: 2.5
	// 
	// 
	// 
	// 4)
	// {6,12,17,14,20,8,16,7,2,15}
	// {-1,-1,4,-1,11,3,13,-1,-1,18}
	// 
	// Returns: 8.0
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
