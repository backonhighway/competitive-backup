package paiza;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Paiza1 {
	
	public static void main(String args[]) throws Exception {
		// 入力受け取り
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		int N = Integer.parseInt(num[0]); //商品点数
		int D = Integer.parseInt(num[1]); //キャンペーン日数
		int[] pp = new int[N]; //商品値段
		int[] cp = new int[D]; //キャンペーン設定金額
		for(int i=0; i<N; i++){
			pp[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<D; i++){
			cp[i] = Integer.parseInt(br.readLine());
		}
		
		// 以下計算部分。ソートして各設定金額に対して二分探索:O(D*NlogN)
		Arrays.sort(pp);
		
		for(int i=0; i<D; i++){
			int closemax = 0;
			for(int j=0; j<N; j++){
				int lb = -1; //下限インデックス
				int ub = N; //上限インデックス
				int target = cp[i] - pp[j]; //近づけたい金額
				
				while(lb + 1 < ub){
					int mid = (lb + ub) / 2;
					if(pp[mid] <= target){ //条件を満たせば解はmid<=ans<ub
						lb = mid;
					}else{ //満たさなければlb<=ans<mid
						ub = mid;
					}
				}
				if(lb == j){ //同じものは使えない
					lb -= 1;
				}
				if(lb < 0){ //満たすものがない
					continue;
				}
				closemax = Math.max(closemax, pp[j] + pp[lb]);
			}
			System.out.println(closemax);
		}
	}
}
