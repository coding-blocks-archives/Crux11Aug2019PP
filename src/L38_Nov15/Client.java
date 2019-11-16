package L38_Nov15;

import java.util.HashMap;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Nov-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		Graph graph = new Graph(7);

		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 3);
		graph.addEdge(1, 4, 10);
		graph.addEdge(3, 4, 1);
		graph.addEdge(4, 5, 8);
		graph.addEdge(5, 6, 5);
		graph.addEdge(6, 7, 4);
		graph.addEdge(5, 7, 6);

		graph.display();

		// graph.removeEdge(1, 2);
		// graph.removeEdge(5, 6);

		// System.out.println(graph.hasPath(1, 6, new HashMap<>()));

		// graph.printAllPaths(1, 6, "1", new HashMap<>());
		//
		// System.out.println(graph.bfs(1, 6));
		//
		// System.out.println(graph.dfs(1, 6));
		//
		//// graph.bft();
		// System.out.println("--");
		//
		// graph.dft();

		// System.out.println(graph.isConnected());
		// System.out.println(graph.isCyclic());
		// System.out.println(graph.isTree());
		// System.out.println(graph.getCC());
		//
		// System.out.println(graph.isBipartite());

		graph.prims().display();
		
		graph.dijkstra(3);

	}
}
