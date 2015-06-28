package CoinDP;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        new Main().solve(sc);
    }
    
    public static int INF = 1000000000;
    
    public void solve(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[m];
        for(int i=0; i<m; i++){
        	d[i] = sc.nextInt();
        }
//    	int n = 65; int m = 6;
//    	int[] d = {1,2,7,8,12,50};
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=0; i<=n; i++){
        	for(int j=0; j<d.length; j++){
        		int next = i + d[j];
        		if(next <= n){
        			dp[next] = Math.min(dp[next], dp[i] + 1);
        		}
        	}
        }
        
        System.out.println(dp[n]);
    }

}
