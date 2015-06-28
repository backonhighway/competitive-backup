package lib;

public class UnionFind {

	private int[] nodes;
	
	public UnionFind(int size) {
		nodes = new int[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = i;
		}
	}
	
	private int find(int index) {
		if (nodes[index] == index) return index;
		return nodes[index] = find(nodes[index]);
	}
	
	public void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x == y) return ;
		nodes[x] = y;
	}
	
	public boolean isSame(int a, int b) {
		return find(a) == find(b);
	}
}
