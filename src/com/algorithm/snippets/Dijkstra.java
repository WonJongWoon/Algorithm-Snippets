package com.algorithm.snippets;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {

	public static final int INF = 987654321;

	public static class Pair implements Comparable<Pair> {

		private final int x;
		private final int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}

			return this.x - o.x;
		}
	}

	private Dijkstra() {
	}

	/*
	 * Queue`s Element Pair = (cost, vertex)
	 * Graph`s Element Pair = (dest, cost)
	 * n : number of vertices ( n >= 1 )
	 * start : start vertex number ( start >= 1 )
	 * return : shortest cost
	 * result[i] = shortest cost for start to i ( 1 <= i <= n )
	 * if result[i] is INF, can't approach at i
	 * */
	public static int[] dijkstra(int n, int start, List<List<Pair>> graph) {
		int[] cost = new int[n];
		Arrays.fill(cost, INF);

		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(0, start));
		cost[start] = 0;

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int nowCost = cur.getX();
			int nowVertex = cur.getY();

			if (cost[nowVertex] != nowCost) {
				continue;
			}

			for (Pair next : graph.get(nowVertex)) {
				int nextVertex = next.getX();
				int nextCost = nowCost + next.getY();

				if (nextCost < cost[nextVertex]) {
					cost[nextVertex] = nextCost;
					q.offer(new Pair(nextCost, nextVertex));
				}
			}
		}

		return cost;
	}
}
