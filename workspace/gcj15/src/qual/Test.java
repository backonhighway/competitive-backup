package qual;

public class Test {
	public static void main(String[] args) {
		int x = 3;
        int r = 3;
        int c = 1;
        boolean richCanWin = false;
        // of the omni
        int minlen = x / 2 + 1;
        int maxlen = x;
        if (r < minlen || c < minlen) richCanWin = true;
        if (r < maxlen && c < maxlen) richCanWin = true;
        
        int leftArea = r * c - x;
        if (leftArea % x != 0) richCanWin = true;
        
        String ans = richCanWin ? "RICHARD" : "GABRIEL";
    	System.out.println(ans);
    }
}
