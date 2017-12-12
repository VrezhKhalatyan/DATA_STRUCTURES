package homework4final;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		new App().run();
	}

	@SuppressWarnings("rawtypes")
	private void run() {
		try {
			Graph g = new Graph(new File("graph.txt"));
			final Vertex start = g.getVertex(1);
			final Vertex goal = g.getVertex(5);
			final ArrayList<Edge> paths = (ArrayList<Edge>) aStar(g, start, goal);
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
	
	public static <T extends Vertex<T>> ArrayList<T> aStar(Graph g, T start, T goal){
		Set<T> closed = new HashSet<T>();
		Map<T, T> fromMap = new HashMap<T, T>();
		ArrayList<T> route = new ArrayList<T>();
		Map< T, Double> gScore = new HashMap<T, Double>();
		final Map<T, Double> fScore = new HashMap<T, Double>();
		PriorityQueue<T> open = new PriorityQueue<T>(20, new Comparator<T>(){

			@Override
			public int compare(T nodeA, T nodeB) {
				return Double.compare(fScore.get(nodeA), fScore.get(nodeB));
			}
			
		});
		
		gScore.put(start, 0.0);
		fScore.put(start, start.getHeuristic(goal));
		open.offer(start);
		
		while(!open.isEmpty()){
			T current = open.poll();
			if(current.equals(goal)){
				while(current != null){
					route.add(0,current);
					current = fromMap.get(current);
				}
				return route;
			}
			
			closed.add(current);
			
			for(Vertex neighbour : current.getNeighbours()){
				if(closed.contains(neighbour)){
					continue;
				}
				
				double tentG = gScore.get(current) + current.getTraversalCost(neighbour);
				boolean contains = open.contains(neighbour);
				if (!contains || tentG < gScore.get(neighbour)){
					gScore.put((T) neighbour, tentG);
					fScore.put((T) neighbour, tentG + neighbour.getHeuristic(goal));
					
					if(contains){
						open.remove(neighbour);
					}
					
					open.offer((T) neighbour);
					fromMap.put((T) neighbour, current);
				}
			}
		}
		return route;
		
	}

	/*@SuppressWarnings("rawtypes")
	private ArrayList<Edge> aStar(Graph g, final Vertex start, final Vertex goal) {
		final ArrayList<Edge> totalPath = new ArrayList<Edge>();
		final Set<Vertex> closedSet = new HashSet<Vertex>();
		final ArrayList<Vertex> openSet = new ArrayList<Vertex>();

		final Map<Vertex, Vertex> cameFrom = new HashMap<Vertex, Vertex>();
		final Map<Vertex, Integer> gScore = new HashMap<Vertex, Integer>();
		openSet.add(start);
		gScore.put(start, 0);

		final Map<Vertex, Integer> fScore = new HashMap<Vertex, Integer>();

		fScore.put(start, heuristicCostEstimate(start, goal));
		final Comparator<Vertex> comparator = new Comparator<Vertex>() {

			public int compare(Vertex o1, Vertex o2) {
				if (fScore.get(o1) < fScore.get(o2))
					return -1;
				if (fScore.get(o2) < fScore.get(o1))
					return 1;
				return 0;
			}
		};
		while (!openSet.isEmpty()) {
			Vertex current = openSet.get(0);
			
			if (current.equals(goal)) {
				
				while (current != null) {
					final Vertex previous = current;
					current = cameFrom.get(current);
					if (current != null) {
						final Edge edge = current.getEdge(previous);
						totalPath.add(edge);
					}
				}
				Collections.reverse(totalPath);
			}
			openSet.remove(0);
			closedSet.add(current);
			for (Edge edge : totalPath) {
				final Vertex neighbor = g.getVertex(0);
				if (closedSet.contains(neighbor))
					continue;
				final int tenativeGScore = (int) (gScore.get(current) + edge.weight);
				if (!openSet.contains(neighbor))
					openSet.add(neighbor);
				else if (tenativeGScore >= gScore.get(neighbor))
					continue;
				cameFrom.put(neighbor, current);
				gScore.put(neighbor, tenativeGScore);
				final int estimatedFScore = gScore.get(neighbor) + heuristicCostEstimate(neighbor, goal);
				fScore.put(neighbor, estimatedFScore);
				Collections.sort(openSet, comparator);
			}
		}
		return totalPath;
	}*/

	@SuppressWarnings("rawtypes")
	protected int heuristicCostEstimate(Vertex start, Vertex goal) {
		return 1;
	}
}
