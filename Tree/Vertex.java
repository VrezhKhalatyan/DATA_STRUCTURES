package homework4final;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Vertex<E> implements Comparable<Vertex> {
	final int id;
	final double x;
	final double y;
	final ArrayList<Edge> edges = new ArrayList<Edge>();

	public Vertex(final int id, final double x, final double y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return id + "@" + "(" + x + "," + y + ")";
	}

	public void addEdge(E edge) {
		edges.add((Edge) edge);
	}

	public int compareTo(Vertex o) {
		if (this.id == o.id) {
			return 0;
		} else {
			return 1;
		}
	}

	public double getHeuristic(Vertex goal) {
		return Math.min(Math.abs(x - goal.x), Math.abs(y - goal.y));
	}
	
	public Set<Vertex> getNeighbours(){
		Set<Vertex> neighbours = new HashSet<Vertex>();
		for (int i = (int) (x - 1); i <= x + 1; i++){
			for (int j = (int) (y - 1); j <= y + 1; j++){
				if((i == x && j == y) || i < 0 || j < 0 || j >= edges.size()){
					continue;
				}
				neighbours.add(new Vertex(id, i , j));
			}
		}
		return neighbours;
	}
	
	public double getTraversalCost(Vertex neighbour){
		return 1;
	}
}
