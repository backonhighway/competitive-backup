package LIS;

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
        int[] a = new int[n];
        for(int i=0; i<n; i++){
        	a[i] = sc.nextInt();
        }
//    	int n = 3;
//    	int[] a = {1,1,1};
        
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        
        for(int i=0; i<n; i++){
        	int lb = -1;
        	int ub = n;
            int m = (lb + ub) / 2;
        	while(ub - lb > 1){
        		m = (lb + ub) / 2;
        		if(a[i] <= dp[m]){
        			ub = m;
        		} else {
        			lb = m;
        		}
        	}
        	dp[ub] = a[i];
        	
        }
        int ans = 0;
        for(int i=0; i<n; i++){
        	if(dp[i] != INF){
        		ans++;
        	}
        }
        System.out.println(ans);
    }

}
