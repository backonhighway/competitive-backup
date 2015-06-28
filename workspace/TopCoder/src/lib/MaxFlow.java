package lib;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * implemented tutorials from TC
 * @author me
 */
public class MaxFlow {
	
	/*
	 * 2dArrayCapacity-Version
	 */
	public int maxFlow(int[][] cap) {
		int flow = 0;
		while (true) {
			//try sending a flow
			int f = findPath(cap);
//			System.out.println(f);
			if (f == 0) break;
			else flow += f;
		}
		return flow;
	}
	
	//BFS
	public int findPath(int[][] cap) {
		int len = cap.length;
		final int source = 0;
		final int sink = len - 1;
		
		boolean[] visited = new boolean[len];
		int[] from = new int[len]; //tracks the path
		Arrays.fill(from, -1);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(source);
		visited[source] = true;
		
		//search
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == sink) break;
			for (int next = 0; next < len; next++) {
				if (cap[now][next] > 0 && !visited[next]) {
					q.add(next);
					visited[next] = true;
					from[next] = now;
				}
			}
		}
//		System.out.println(Arrays.toString(from));
		//calculate the flow
		//note that the previous position is from[pos]
		int pos = sink;
		int flow = Integer.MAX_VALUE;
		while (from[pos] > -1) {
			flow = Math.min(flow, cap[from[pos]][pos]);
			pos = from[pos];
		}
		if (flow == Integer.MAX_VALUE) return 0;
		
		//update
		pos = sink;
		while (from[pos] > -1) {
			cap[from[pos]][pos] -= flow;
			cap[pos][from[pos]] += flow;
			pos = from[pos];
		}
		
		return flow;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
