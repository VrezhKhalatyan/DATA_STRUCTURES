package quickSort;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		ArrayList<Integer> collection = new ArrayList<Integer>();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			collection.add(random.nextInt(10 * 100));
		}
		
		System.out.println(quickSort(collection));

	}

	private static ArrayList<Integer> quickSort(ArrayList<Integer> input) {
		if (input.size() <= 1) {
			return input;
		}
		int middle = (int) Math.ceil((double) input.size() / 2);
		int pivot = input.get(middle);

		ArrayList<Integer> low = new ArrayList<Integer>();
		ArrayList<Integer> high = new ArrayList<Integer>();

		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) <= pivot) {
				if (i == middle) {
					continue;
				}
				low.add(input.get(i));
			} else {
				high.add(input.get(i));
			}
		}
		return concat(quickSort(low), pivot, quickSort(high));
	}

	private static ArrayList<Integer> concat(ArrayList<Integer> low, int pivot, ArrayList<Integer> high) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < low.size(); i++) {
			list.add(low.get(i));
		}
		list.add(pivot);

		for (int i = 0; i < high.size(); i++) {
			list.add(high.get(i));
		}
		return list;

	}

}
