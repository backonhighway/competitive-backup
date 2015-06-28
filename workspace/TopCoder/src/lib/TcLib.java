package lib;

import java.util.*;
public class TcLib {
	
	class Point{
		int y;
		int x;
		
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	{
		PriorityQueue<Point> pq = new PriorityQueue<>(1,
				Comparator.comparing(point -> point.x));
	}
	public boolean isSmall(int[] a, int[] b){
		int A = a.length;
		int B = b.length;
		if(A<B) return true;
		if(A>B) return false;
		for(int i=0; i<a.length; i++){
			if(a[i]<b[i]) return true;
			if(a[i]>b[i]) return false;
		}
		return false;
	}
	
	public final static int LIM_NCR = 50;
	public long[][]ncr = new long[LIM_NCR][LIM_NCR];
	
	public void gennCr(){
	    int i, j;

	    ncr[0][0]=1;
	    for(i = 1; i <= LIM_NCR; i++){
	        for(j = 0; j <= LIM_NCR; j++){
	            if(j > i) ncr[i][j] = 0;
	            else if(j == i || j == 0) ncr[i][j] = 1;
	            else ncr[i][j] = ncr[i-1][j-1] + ncr[i-1][j];
	        }
	    }
	}
	
	public int lcm(int a, int b){
		return a * b / gcd(a, b);
	}
	
	public int gcd(int a, int b){
		return b != 0 ? gcd(b, a % b) : a;
	}
	
	public boolean isPrime(int n){
		for(int i=2; i*i <= n; i++){
			if(n%i == 0) return false;
		}
		return n != 1; //1 is exception
	}
	
	//‘fˆö”•ª‰ðHHH
	public List<Integer> primeDivisor(int n){ //O(n)
		List<Integer> list = new ArrayList<>();
		for(int i=2; i*i<=n; i++){
			while (n%i==0) {
				list.add(i);
				n /= i;
			}
		}
		if (n != 1) list.add(n); //n is prime
		return list;
	}
	
	public HashMap<Integer, Integer> primeDivisorMap(int n){ //O(sqrt n)
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 2; i*i <= n; i++){
			while (n % i == 0) {
				Integer count = map.get(i);
				if (count == null) {
					map.put(i, 1);
				} else {
					map.put(i, count + 1);
				}
				n /= i;
			}
		}
		if (n != 1) map.put(n, 1); //n is prime
		
		return map;
	}
	
	public int[] divisor(int n){ //O(sqrt n)
		List<Integer> list = new ArrayList<>();
		for(int i=1; i*i<=n; i++){
			if(n%i==0){
				list.add(i);
				if(i != n/i){
					list.add(n/i);
				}
			}
		}
		int[] ret = new int[list.size()];
		int i = 0;
		for(Integer e : list) ret[i++] = e.intValue();
		return ret;
	}
	
	public static final int MAX_N = 1000;
	public int[] prime = new int[MAX_N]; //i-th primenumber
	public boolean[] isPrime = new boolean[MAX_N+1]; //i==true then i is prime
	
	public int sieve(int n){ //Eratosthenes
		int p = 0;
		for(int i=0; i<=n; i++) isPrime[i] = true;
		isPrime[0] = isPrime [1] = false;
		for(int i=2; i<=n; i++){
			if(isPrime[i]){
				prime[p++] = i;
				for(int j=2*i; j<=n; j+=i) isPrime[j] = false;
			}
		}
		return p; //number of primes that are <=p
	}
	
	public void sieveOnly(int n){ //Eratosthenes
		for(int i=0; i<=n; i++) isPrime[i] = true;
		isPrime[0] = isPrime [1] = false;
		for(int i=2; i<=n; i++){
			if(isPrime[i]){
				for(int j=2*i; j<=n; j+=i) isPrime[j] = false;
			}
		}
	}
	
	public int[] toIntArray(List<Integer> list)  {
		int[] ret = new int[list.size()];
		int i = 0;
		for(Integer e : list) ret[i++] = e.intValue();
		return ret;
	}
	
	//normal Math.pow will return bad answers even in 13^15
	public long intpow(int a, int b){//a^b
		long ret = 1;
		for(int i=0; i<b; i++){
			ret *= a;
		}
		return ret;
	}
	
	public String rev(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
    public String replaceChar(String str, int index, int val){
    	StringBuffer sb = new StringBuffer(str);
    	char ch = String.valueOf(val).charAt(0);
    	sb.setCharAt(index, ch);
    	return sb.toString();
    }
    
    public char intToChar(int input){//only one digit, just to memo 48
    	return (char)(input+48);
    }
    
	/**
	 * {1,2,1,2} {1,3,1,2} = {1,1,2}
	 * Greedy from front will only make {1,2}
	 * 0000
	 * 010
	 * 01X
	 * 0
	 */
	public int lcs(int[] a, int[] b) {
		int alen = a.length;
		int blen = b.length;
		
		int[][] dp = new int[alen+1][blen+1];
		for (int i = 0; i < alen; i++) {
			for (int j = 0; j < blen; j++) {
				if (a[i] == b[j]) {
					dp[i+1][j+1] = dp[i][j] + 1;
				} else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		return dp[alen][blen];
	}
	


}
