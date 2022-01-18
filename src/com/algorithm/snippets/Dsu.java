package com.algorithm.snippets;

// Implementation without optimization
public class Dsu {

	private final int[] parent;

	public Dsu(int size) {
		this.parent = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		parent[x] = find(parent[x]);
		return parent[x];
	}

	public boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);

		if (parentX == parentY) {
			return false;
		}

		parent[parentY] = parentX;
		return true;
	}
}

// Optimize implementation using size compression
class OptimizeDsu {

	private final int[] parent;
	private final int[] size;

	public OptimizeDsu(int size) {
		this.parent = new int[size];
		this.size = new int[size];

		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < size; i++) {
			this.size[i] = 1;
		}
	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		parent[x] = find(parent[x]);
		return parent[x];
	}

	public boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);

		if (parentX == parentY) {
			return false;
		}

		if (size[parentX] > size[parentY]) {
			parent[parentY] = parentX;
			size[parentX] += size[parentY];
		} else {
			parent[parentX] = parentY;
			size[parentY] += size[parentX];
		}

		return true;
	}
}


