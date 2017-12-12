package Homework1Revised;

import java.util.PriorityQueue;

public class App {
	public static void main(String[] args) {
		Deck<Card> deck = new Deck<Card>();

		for (int i = 0; i < 52; i++) {
			deck.addCard(new Card(i));
		}

		deck.shuffle();

		final int a[] = deck.search();
		final int max = a[0];
		final int min = a[1];
		// problem 1
		System.out.println("max card is at location " + max);
		System.out.println("min card is at location " + min);

		// problem 2
		deck.printPermutation(3);
		deck.printPermutation(4);
		deck.printPermutation(5);

		// problem 3
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
