package at1;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] input = new int[N];
		for(int i=0; i<N; i++) input[i] = sc.nextInt();
		
		Arrays.sort(input);
		boolean[] dp = new boolean[N*100+1];
		Arrays.fill(dp,false);
		dp[0]=true;
		
		for(int i=0; i<N; i++){
			boolean[] dpcopy = new boolean[dp.length];
			for(int j=0; j<dp.length; j++){
				dpcopy[j] = dp[j];
			}
			for(int j=0; j<dp.length; j++){
				if(dpcopy[j] && j+input[i]<dp.length){
					dp[j+input[i]] = true;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<dp.length; i++){
			if(dp[i]){
				ans++;
			}
		}
		System.out.println(ans);
	}

}
