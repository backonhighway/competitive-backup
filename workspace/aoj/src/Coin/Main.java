package Coin;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        new Main().solve(sc);
    }
    
    public static int INF = 1000000000;
    public int[][] dp;
    public int[] d;
    
    public void solve(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[m];
        for(int i=0; i<m; i++){
        	d[i] = sc.nextInt();
        }
//    	int n = 65; int m = 6;
//    	int[] d = {1,2,7,8,12,50};
        this.d = d;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++){
        	Arrays.fill(dp[i], INF);
        }
        this.dp = dp;
        if(m==1){
        	System.out.println(n);
        } else {
            System.out.println(rec(m, n));
        }

    }
    
    public int rec(int m, int n){
    	if(dp[m][n] != INF){
    		return dp[m][n];
    	}
    	if(m==2){
    		return dp[m][n] = n/d[m-1] + n%d[m-1];
    	}
    	int ret = INF;
    	for(int i=0; i*d[m-1]<=n; i++){
    		ret = Math.min(ret, rec(m-1, n-i*d[m-1]) + i);
    	}
    	return dp[m][n] = ret;
    }

}
