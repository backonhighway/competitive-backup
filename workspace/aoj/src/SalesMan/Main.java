package SalesMan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        new Main().solve(sc);
    }
    
    public static int INF = 1<<30;
    
    public void solve(Scanner sc){
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] cost = new int[V][V];
        for(int i=0; i<cost.length; i++){
            Arrays.fill(cost[i], INF);
        }
        for(int i=0; i<E; i++){
        	int u = sc.nextInt();
        	int v = sc.nextInt();
        	int d = sc.nextInt();
        	cost[u][v] = d;
        }
        
        final int setbits = (1<<V)-1;
        int[][] dp = new int[setbits+1][V];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[setbits][0] = 0;

        
        for(int S=setbits-1; S>=0; S--){ //set
        	for(int p=0; p<V; p++){ //point now
        		for(int q=0; q<V; q++){ //point to go
        			if(((S>>q)&1) == 0 && cost[p][q] != INF){
            			dp[S][p] = Math.min(dp[S][p], dp[S|(1<<q)][q] + cost[p][q]);
        			}
        		}
        	}
        }
        
        System.out.println(dp[0][0]==INF ? -1 : dp[0][0]);
    }

}
