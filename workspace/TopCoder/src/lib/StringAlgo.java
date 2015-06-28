package lib;

import java.util.Arrays;

public class StringAlgo {

	public static void main(String[] args) {
		StringAlgo ins = new StringAlgo();
		int[] z = ins.zAlgo("aaaabbbcaaabbb".toCharArray());
		System.out.println(Arrays.toString(z));
	}
	
	/**
	 * returns int[] 
	 * z[i] =  length of the longest substring starting from S[i] which is also a prefix of S
	 * abracadabra
	 *        abracadabra
	 *        ^^^^
	 * z[8] = 4
	 */
	public int[] zAlgo(char[] str) {
		int n = str.length;
		int[] z = new int[n];
		if (n == 0) return z;
		z[0] = n;
		int l = 0, r = 0;
		for(int i = 1; i < n; i++){
			if (i > r) {
				l = r = i;
				while (r < n && str[r-l] == str[r]) r++;
				z[i] = r-l; r--;
			} else {
				int k = i-l;
				if (z[k] < r-i+1) {
					z[i] = z[k];
				} else {
					l = i;
					while (r < n && str[r-l] == str[r]) r++;
					z[i] = r-l; r--;
				}
			}
		}
		
		return z;
	}
}
