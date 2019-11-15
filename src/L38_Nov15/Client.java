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

		graph.addEdge(1, 2, 10);
		graph.addEdge(2, 3, 20);
		graph.addEdge(1, 4, 30);
		graph.addEdge(3, 4, 78);
		graph.addEdge(4, 5, 90);
		graph.addEdge(5, 6, 67);
		graph.addEdge(6, 7, 23);
		graph.addEdge(5, 7, 89);

		graph.display();

		// graph.removeEdge(4, 5);

		// System.out.println(graph.hasPath(1, 6, new HashMap<>()));

		graph.printAllPaths(1, 6, "1", new HashMap<>());

		System.out.println(graph.bfs(1, 6));

		System.out.println(graph.dfs(1, 6));

		graph.bft();
		System.out.println("--");

		graph.dft();

	}
}
