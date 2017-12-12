package homework4final;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		try {
			Graph g = new Graph(new File("graph_v2.txt"));
			final Vertex start = g.getVertex(1);
			final Vertex goal = g.getVertex(5);
			final ArrayList<Edge> paths = aStar(g, start, goal);
			System.out.println("start: " + start);
			if (paths == null) {
				System.out.println("no path found");
			} else {
				for (Edge path : paths) {
					System.out.println(path);
				}
			}
			System.out.println("end: " + goal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   //This is the algorithm that needs fixed
   //Keep the same parameters
	private ArrayList<Edge> aStar(Graph g, final Vertex start, final Vertex goal) {
		final Set<Vertex> closedSet = new HashSet<Vertex>();
		final ArrayList<Vertex> openSet = new ArrayList<Vertex>();

		final Map<Vertex, Vertex> cameFrom = new HashMap<Vertex, Vertex>();
		final Map<Vertex, Integer> gScore = new HashMap<Vertex, Integer>();
		openSet.add(start);
		gScore.put(start, 0);

		final Map<Vertex, Integer> fScore = new HashMap<Vertex, Integer>();

		while (!openSet.isEmpty()) {
			Vertex current = openSet.get(0);

			if (current.equals(goal)) {
				final ArrayList<Edge> totalPath = new ArrayList<Edge>();
				while (current != null) {
					final Vertex previous = current;
					current = cameFrom.get(current);
					if (current != null) {
						final Edge edge = new Edge(previous, previous, 0);
						
						totalPath.add(edge);
					}
				}
				Collections.reverse(totalPath);
			}
		}
		return null;
	}
}
