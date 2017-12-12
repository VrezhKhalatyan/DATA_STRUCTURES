package homework4final;

import java.util.ArrayList;

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
}
