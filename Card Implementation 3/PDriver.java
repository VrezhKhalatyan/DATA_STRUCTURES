package Homework1Revised;

import java.util.PriorityQueue;

public class PDriver {
	public static void main(String[] args) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new PCompare());
		pq.add(new Point(3, 2));
		pq.add(new Point(3, 2));
		pq.add(new Point(2, 1));
		pq.add(new Point(4, 2));
		pq.add(new Point(8, 2));
		pq.add(new Point(9, 2));
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
}
