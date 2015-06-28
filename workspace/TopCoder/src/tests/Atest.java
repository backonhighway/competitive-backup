package tests;

import java.util.*;

public class Atest {
	
	public static void main(String[] args){
		double tes;
		int a = 3;
		double b = 4.0;
		tes = a*b;
		System.out.println(tes==12);
		
		int[][] moto = {{3,4,5},{6,7,8},{9,1,2}};
		int[][] saki = new int[3][3];
		
		//moto, startmoto, saki, placefrom, len
		System.arraycopy(moto, 0, saki, 0, 3);
		show(moto);
		show(saki);
		System.out.println("---------------------");
		
		show(moto);
		show(saki);
		System.out.println("----------tantai-----------");
		
		int[] tanmoto = {3,4,5,6};
		int[] tansaki = new int[4];
		
		System.arraycopy(tanmoto, 0, tansaki, 0, 4);
		System.out.println(Arrays.toString(tanmoto));
		System.out.println(Arrays.toString(tansaki));
		System.out.println("------------------");
		tanmoto[2] = 9;
		System.out.println(Arrays.toString(tanmoto));
		System.out.println(Arrays.toString(tansaki));
		
		System.out.println("----------object--------");
		Point[] pt = {new Point(1,2), new Point(2,3), new Point(3,1)};
		Point[] sakipt = new Point[3];
		System.arraycopy(pt, 0, sakipt, 0, 3);
		Arrays.sort(sakipt, new Comparator<Point>(){
			@Override
			public int compare(Point o1, Point o2){
				return o1.y - o2.y;
			}
		});
		pt[2].x = 9;
		for(int i=0; i<pt.length; i++){
			System.out.print(pt[i].x);
		}
		System.out.println("");
		for(int i=0; i<sakipt.length; i++){
			System.out.print(sakipt[i].x);
		}
	}
	
	public static void show(int[][] input){
		for(int i=0; i<input.length; i++){
			for(int j=0; j<input[i].length; j++){
				System.out.print(input[i][j]);
			}
			System.out.println("");
		}
	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
