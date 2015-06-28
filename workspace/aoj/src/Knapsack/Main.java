package Knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        new Main().solve(sc);
    }
    
    public static int INF = 1000000000;
    
    public void solve(Scanner sc){
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for(int i=0; i<N; i++){
        	v[i] = sc.nextInt();
        	w[i] = sc.nextInt();
        }
//    	int N = 4; int W = 8;
//    	int[] v = {4,5,2,8};
//    	int[] w = {2,2,1,3};
        
        int[][] dp = new int[N+1][W+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(dp[i], 0);
        }
        
        for(int i=0; i<N; i++){
        	for(int j=0; j<=W; j++){
        		int pw = j - w[i];
        		if(pw < 0){
            		dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
        		} else {
        			dp[i+1][j] = Math.max(dp[i][j], dp[i+1][pw] + v[i]);
        		}
        	}
        }
        int ans = 0;
        for(int i=0; i<=W; i++){
        	ans = Math.max(ans, dp[N][i]);
        }
        
        System.out.println(ans);
    }

}
