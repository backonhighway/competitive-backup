package Knapsack01;

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
//    	int N = 2; int W = 20;
//    	int[] v = {5,4};
//    	int[] w = {9,10};
        
        int[][] dp = new int[N+1][W+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(dp[i], 0);
        }
        
        for(int i=0; i<N; i++){
        	for(int j=0; j<=W; j++){
        		//dont use
        		dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
        		//use
        		int nw = j + w[i];
        		int nv = dp[i][j] + v[i];
        		if(nw <= W){
            		dp[i+1][nw] = Math.max(dp[i+1][nw], nv);
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
