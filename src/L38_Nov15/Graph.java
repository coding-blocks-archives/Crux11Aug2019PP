package L38_Nov15;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Nov-2019
 *
 */

public class Graph {

	int[][] matrix;

	public Graph(int v) {
		matrix = new int[v + 1][v + 1];
	}

	public void addEdge(int u, int v, int cost) {

		matrix[u][v] = cost;
		matrix[v][u] = cost;

	}

	public int removeEdge(int u, int v) {

		int temp = matrix[u][v];

		matrix[u][v] = 0;
		matrix[v][u] = 0;

		return temp;
	}

	public boolean containsEdge(int u, int v) {
		return matrix[u][v] != 0;
	}

	public int numEdges() {

		int count = 0;

		for (int i = 1; i < matrix.length; i++) {

			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] != 0) {
					count++;
				}
			}
		}

		return count / 2;

	}

	public void display() {

		System.out.println("--------------------------");

		for (int i = 1; i < matrix.length; i++) {

			String str = i + " -> ";

			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] != 0) {

					str += j + "[" + matrix[i][j] + "] ";
				}
			}

			System.out.println(str);
		}

		System.out.println("--------------------------");

	}

	public boolean hasPath(int src, int dst, HashMap<Integer, Boolean> visited) {

		// if (containsEdge(src, dst)) {
		if (src == dst)
			return true;

		visited.put(src, true);

		for (int j = 1; j < matrix[0].length; j++) {

			if (matrix[src][j] != 0 && !visited.containsKey(j)) {

				boolean res = hasPath(j, dst, visited);

				if (res) {
					return true;
				}
			}
		}

		return false;

	}

	public void printAllPaths(int src, int dst, String ans, HashMap<Integer, Boolean> visited) {

		if (src == dst) {
			System.out.println(ans);
			return;
		}

		visited.put(src, true);

		for (int j = 1; j < matrix[0].length; j++) {

			if (matrix[src][j] != 0 && !visited.containsKey(j)) {

				printAllPaths(j, dst, ans + j, visited);

			}
		}

		visited.remove(src);

	}

	private class Pair {
		int vname;
		String psf;
	}

	public boolean bfs(int src, int dst) {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// make a sp and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "";

		queue.addLast(sp);

		// work till queue is not empty
		while (!queue.isEmpty()) {

			// remove the pair from queue
			Pair rp = queue.removeFirst();

			// ignore the second C
			if (visited.containsKey(rp.vname)) {
				continue;
			}

			// correct position to return true
			if (rp.vname == dst) {
				System.out.println(rp.psf);
				return true;
			}

			// put true in map
			visited.put(rp.vname, true);

			// loop on nbrs
			for (int j = 1; j < matrix[0].length; j++) {

				// consider only unvisited nbrs
				if (matrix[rp.vname][j] != 0 && !visited.containsKey(j)) {

					// make a pair for nbr and put in queue
					Pair np = new Pair();
					np.vname = j;
					np.psf = rp.psf + j;

					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean dfs(int src, int dst) {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// make a sp and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "";

		stack.addFirst(sp);

		// work till queue is not empty
		while (!stack.isEmpty()) {

			// remove the pair from queue
			Pair rp = stack.removeFirst();

			// ignore the second C
			if (visited.containsKey(rp.vname)) {
				continue;
			}

			// correct position to return true
			if (rp.vname == dst) {
				System.out.println(rp.psf);
				return true;
			}

			// put true in map
			visited.put(rp.vname, true);

			// loop on nbrs
			for (int j = 1; j < matrix[0].length; j++) {

				// consider only unvisited nbrs
				if (matrix[rp.vname][j] != 0 && !visited.containsKey(j)) {

					// make a pair for nbr and put in queue
					Pair np = new Pair();
					np.vname = j;
					np.psf = rp.psf + j;

					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void bft() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (int src = 1; src < matrix.length; src++) {

			if (visited.containsKey(src)) {
				continue;
			}

			// make a sp and put in queue
			Pair sp = new Pair();
			sp.vname = src;
			sp.psf = src + "";

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (visited.containsKey(rp.vname)) {
					continue;
				}

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// put true in map
				visited.put(rp.vname, true);

				// loop on nbrs
				for (int j = 1; j < matrix[0].length; j++) {

					// consider only unvisited nbrs
					if (matrix[rp.vname][j] != 0 && !visited.containsKey(j)) {

						// make a pair for nbr and put in queue
						Pair np = new Pair();
						np.vname = j;
						np.psf = rp.psf + j;

						queue.addLast(np);
					}
				}

			}

		}

	}

	public void dft() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (int src = 1; src < matrix.length; src++) {

			if (visited.containsKey(src)) {
				continue;
			}

			// make a sp and put in queue
			Pair sp = new Pair();
			sp.vname = src;
			sp.psf = src + "";

			stack.addFirst(sp);

			// work till queue is not empty
			while (!stack.isEmpty()) {

				// remove the pair from queue
				Pair rp = stack.removeFirst();

				// ignore the second C
				if (visited.containsKey(rp.vname)) {
					continue;
				}

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// put true in map
				visited.put(rp.vname, true);

				// loop on nbrs
				for (int j = 1; j < matrix[0].length; j++) {

					// consider only unvisited nbrs
					if (matrix[rp.vname][j] != 0 && !visited.containsKey(j)) {

						// make a pair for nbr and put in queue
						Pair np = new Pair();
						np.vname = j;
						np.psf = rp.psf + j;

						stack.addFirst(np);
					}
				}

			}

		}

	}

}
