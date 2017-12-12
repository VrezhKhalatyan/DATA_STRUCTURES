package dataStructureMidterm;

import java.util.ArrayList;

public class Split {
	private static ArrayList<Integer> originalList = new ArrayList<Integer>(4);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			originalList.add(i);
		}

		split(originalList);
	}

	public static <E> void split(ArrayList<E> array) {
		ArrayList<E> firstArray;
		ArrayList<E> secondArray;

		if (array.size() == 1) {
			System.out.println(array);
		}
		if (array.size() % 2 == 1) {
			firstArray = new ArrayList<E>(array.size() / 2 + 1);
			secondArray = new ArrayList<E>(array.size() / 2);
		} else {
			firstArray = new ArrayList<E>(array.size() / 2);
			secondArray = new ArrayList<E>(array.size() / 2);
		}
		for (int i = 0; i < array.size(); i++) {
			if (i % 2 == 0) {
				firstArray.add(array.get(i));
			} else {
				secondArray.add(array.get(i));
			}
		}
		System.out.println("First List");
		for (E i : firstArray) {
			System.out.println("[" + i + "]");
		}
		System.out.println(" ");
		System.out.println("Second List");
		for (E i : secondArray) {
			System.out.println("[" + i + "]");
		}
		System.out.println(" ");
		if (firstArray.size() > array.size()/2) {
			split(firstArray);
		}
		if (secondArray.size() > array.size()/2) {
			split(secondArray);
		}

	}
}
