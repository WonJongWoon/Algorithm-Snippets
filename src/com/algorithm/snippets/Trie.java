package com.algorithm.snippets;

class Trie {

	public static class Node {
		private boolean isEnd;
		private final Node[] next;

		public Node(int size) {
			this.isEnd = false;
			this.next = new Node[size];
		}

		public Node next(int v) {
			return this.next[v];
		}

		public boolean isEnd() {
			return isEnd;
		}
	}

	private final char start;
	private final int size;
	private final Node root;

	public Trie(char start, char end) {
		this.start = start;
		this.size = end - start + 1;
		this.root = new Node(size);
	}

	public void make(String s) {
		Node now = root;

		for (char c : s.toCharArray()) {
			if (now.next[c - start] == null) {
				now.next[c - start] = new Node(size);
			}
			now = now.next[c - start];
		}

		now.isEnd = true;
	}

	public Node getRoot() {
		return root;
	}
}
