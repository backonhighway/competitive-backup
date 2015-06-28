package tc588;
// Paste me into the FileEdit configuration dialog
import java.util.*;

public class GameInDarknessDiv2 {
	
    public String check(String[] field, String[] moves) {
    	
    	int height = field.length;
    	int width = field[0].length();
    	int[] dy = {-1, 0, 1, 0};
    	int[] dx = {0, 1, 0, -1};
    	int bobx=0;
    	int boby=0;

    	String alicemove = "";		
    	for(int i=0; i<moves.length; i++) alicemove += moves[i];
    	int movelen = alicemove.length();
    	int[] alicex = new int[movelen+1]; //bob's x-th move
    	int[] alicey = new int[movelen+1];
    	boolean[][][] visited = new boolean[height][width][movelen+2];
    	
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				if(field[i].charAt(j)=='B'){
					boby = i;
					bobx = j;
				}
				if(field[i].charAt(j)=='A'){
					alicey[0] = i;
					alicex[0] = j;
				}
			}
		}
		for(int i=0; i<movelen; i++){
			int alicedir = "URDL".indexOf(alicemove.charAt(i));
			alicex[i+1] = alicex[i] + dx[alicedir];
			alicey[i+1] = alicey[i] + dy[alicedir];
		}
		if(bobx == alicex[1] && boby == alicey[1]) return "Alice wins";
		
		int time = 1;
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qtime = new LinkedList<Integer>();
		qx.add(bobx); qy.add(boby); qtime.add(time);
		boolean canEscape = false;
		
		while(!qx.isEmpty()){
			bobx = qx.poll();
			boby = qy.poll();
			time = qtime.poll();
			visited[boby][bobx][time] = true;
			for(int i=0; i<4; i++){
				int nextx = bobx + dx[i];
				int nexty = boby + dy[i];
				if(0<=nextx && nextx<width && 0<=nexty && nexty<height
						&& field[nexty].charAt(nextx)!='#'
						&& ((time>=movelen) || (nextx != alicex[time+1] || nexty != alicey[time+1]))
						&& (nextx != alicex[time] || nexty != alicey[time])
						&& !visited[nexty][nextx][time+1]){
					if(time>=movelen){
						canEscape = true;
						break;
					}
					if(!(qx.contains(nextx) && qy.contains(nexty) && qtime.contains(time+1))){
						qx.add(nextx);
						qy.add(nexty);
						qtime.add(time+1);
					}
				}
			}
		}
		
		return canEscape ? "Bob wins" : "Alice wins";
		
    }
    
    


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			GameInDarknessDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				GameInDarknessDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class GameInDarknessDiv2Harness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}
	
	static int verifyCase(int casenum, String expected, String received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			String[] field            = {"A.B..",
 "##.##",
 "##.##"};
			String[] moves            = {"RRDUR"};
			String expected__         = "Alice wins";

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}
		case 1: {
			String[] field            = {"A.B..",
 "##.##",
 "##..."};
			String[] moves            = {"RRRLD"};
			String expected__         = "Bob wins";

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}
		case 2: {
			String[] field            = {"###.#",
 "###..",
 "A..B#",
 "###..",
 "###.#"};
			String[] moves            = {"RR", "R", "UDD"};
			String expected__         = "Alice wins";

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}
		case 3: {
			String[] field            = {"A.###",
 ".B..."};
			String[] moves            = {"RDRRRLLLLUDUDRLURDLUD"};
			String expected__         = "Bob wins";

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}
		case 4: {
			String[] field            = {".....",
 ".#.#.",
 "##.#.",
 "A###.",
 "B...."};
			String[] moves            = {"D"};
			String expected__         = "Alice wins";

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}
		case 5: {
			String[] field            = {".#...#....#.......#....#......",
 "...###.#.#..#.#.#..###...#.#.#",
 ".#.#...#...#..#..#.....##.#...",
 "#..#.##..##..#.#..###.#....#.#",
 "..#..#..#...#...#....#..##.#..",
 "#..##..#..##.#.#.####..#.#...#",
 ".#....##.#.....#......##.#.#..",
 ".###.#...#.#.#..#.#.##...##.#.",
 ".....#.#.##..#.#..##...##...#.",
 "#.#.#...#...#.#.#...#.#.#.##.#",
 ".#..##.#..##..#.###...........",
 "..##.....####.......##.#.#.##.",
 "#....##.#.#...####.#...#.#.#..",
 "#.#.#......##.#...#..#.#..#..#",
 "..#..#.#.##...#.#..#..#..#..#.",
 ".#..#...#...#..#..#.#..#..#A#.",
 "..#..#.#.B##.##..#...#.#.##...",
 "#.#.##..#......#.#.#.#.#...#.#",
 "#.#...#.######...#.#.#.#.#.#..",
 "..#.##.#.....#.##..#...#.#.#.#",
 ".#..#..#.#.#.#.#..#.#####..#.#",
 "..#.#.##.#.#.##.#......#..#...",
 "#..#.....#.#.....#.#.##..##.#.",
 "##..###.#..#.#.#.#..##..#...##",
 "##.#...#..##.#.#..#.#..#.#.#..",
 "#..#.#.####..#..#..#..#......#",
 "..#..#.....####..#.##.#.###.#.",
 ".#..#.####.#.#..#.....#...#...",
 "..##.......#...#..####.##.#.#.",
 "#....#.#.#..#.###....#....#..#"};
			String[] moves            = {"UURURUULLLLLLLLLLDLLLLUDLLUDDLRDDDULLDLLDDRRRRRDDU","RRUUURUULLD"};
			String expected__         = "Alice wins";

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}

		// custom cases

/*      case 6: {
			String[] field            = ;
			String[] moves            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}*/
/*      case 7: {
			String[] field            = ;
			String[] moves            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}*/
/*      case 8: {
			String[] field            = ;
			String[] moves            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new GameInDarknessDiv2().check(field, moves));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
