package homework2Revised;

import java.util.ArrayList;
import java.util.Collections;

public class Deck<E extends Comparable<E>> {

	private ArrayList<E> dataCollection = new ArrayList<E>();

	public void addCard(E card) {
		dataCollection.add(card);
	}

	public void insertFront(E card) {
		dataCollection.add(0, card);
	}

	public void shuffle() {
		Collections.shuffle(dataCollection);
	}

	public int[] search() {
		int a[] = { 0, 0 };
		return search(a, 1);
	}

	public int[] search(final int[] maxMin, final int position) {
		if (position == dataCollection.size() - 1) {
			return maxMin;
		} else {
			E current = dataCollection.get(position);
			E maxItem = dataCollection.get(maxMin[0]);
			E minItem = dataCollection.get(maxMin[1]);

			int newMax = maxMin[0];
			int newMin = maxMin[1];

			if (current.compareTo(maxItem) == 1) {
				newMax = position;
			}

			if (current.compareTo(minItem) == -1) {
				newMin = position;
			}

			final int[] a = { newMax, newMin };
			return search(a, position + 1);
		}
	}

	public static <E> void permutationOfCards(final ArrayList<E> prefix, final ArrayList<E> rest) {
		if (rest.size() <= 1) {
			ArrayList<E> array = new ArrayList<E>(prefix);
			array.addAll(rest);
			printArray(array);
		} else {
			for (int i = 0; i < rest.size(); i++) {
				final E cur = rest.get(i);
				final ArrayList<E> before = new ArrayList<E>(rest.subList(0, i));
				final ArrayList<E> after = new ArrayList<E>(rest.subList(i + 1, rest.size()));

				ArrayList<E> newPrefix = new ArrayList<E>(prefix);
				newPrefix.add(cur);
				ArrayList<E> newRest = new ArrayList<E>(before);
				newRest.addAll(after);
				permutationOfCards(newPrefix, newRest);

			}
		}
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	public <E> void printPermutation(int count) {

		ArrayList<E> newDeck = new ArrayList<E>();
		for (int i = 0; i < count; i++) {
			newDeck.add((E) new Card(i));
		}
		permutationOfCards(new ArrayList<E>(), newDeck);
		printArray(newDeck);
	}

	public static <E> void printArray(final ArrayList<E> array) {
		for (E c : array) {
			System.out.println(" ( " + c + " ) ");
		}
		System.out.println(" ");
	}

	public ArrayList<E> getCards() {
		return dataCollection;
	}

	
	public E removeRear() {
		E card = dataCollection.get(dataCollection.size() - 1);
		return card;
	}
}
