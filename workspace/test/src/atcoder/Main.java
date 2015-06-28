package atcoder;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aN = sc.nextInt();
		int bN = sc.nextInt();
		int[] ascore = new int[aN];
		int[] bscore = new int[bN];
		for(int i=0; i<aN; i++) ascore[aN - i - 1] = sc.nextInt();
		for(int i=0; i<bN; i++) bscore[bN - i - 1] = sc.nextInt();
		
		int[] Atotal = new int[aN+1];
		for(int i=1; i<=aN; i++){
			Atotal[i] = Atotal[i-1] + ascore[i-1];
		}
		int[] Btotal = new int[bN+1];
		for(int i=1; i<=bN; i++){
			Btotal[i] = Btotal[i-1] + bscore[i-1];
		}
		
		int[][] dpmemo = new int[aN+1][bN+1];
		for(int[] ar : dpmemo) Arrays.fill(ar, -1);
		
		for(int i=0; i<=aN; i++){
			for(int j=0; j<=bN; j++){
				int ABtotal = Atotal[i] + Btotal[j];
				int max = 0;
				if(i>0){
					max = Math.max(max, ABtotal - dpmemo[i-1][j]);
				}
				if(j>0){
					max = Math.max(max, ABtotal - dpmemo[i][j-1]);
				}
				dpmemo[i][j] = max;
			}
			
		}
		
		System.out.println(dpmemo[aN][bN]);
	}

}
