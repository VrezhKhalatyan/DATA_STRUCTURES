package homework2Revised;

import java.util.ArrayList;

public class Game {

	UniqueHand uniqueHand = new UniqueHand();
	UniqueHand repeats = new UniqueHand();
	int score = 0;
	ArrayList<String> events = new ArrayList<String>();

	public void playGame(int N, int K, int M) {
		int R = N * K * M;
		int round = 0;
		Deck<Card> superDeck = new Deck<Card>();

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < 52; k++) {
				superDeck.addCard(new Card(k));
			}
		}
		superDeck.shuffle();

		for(int i = 0; i < 5; i++){
			uniqueHand.addCard(superDeck.getCards().get(i));
		}
		superDeck.shuffle();
		System.out.println("Initial Hand: " + uniqueHand);

		int loopValue = 0;
		while (loopValue < R) {

			StringBuilder sb = new StringBuilder();

			Card dCard = superDeck.removeRear();

			Card discardCard = null;
			ArrayList<Card> drawnCards = new ArrayList<Card>();
			ArrayList<Card> discardedCards = new ArrayList<Card>();
			ArrayList<Card> repeats = new ArrayList<Card>();

			do {
				drawnCards.add(dCard);
				uniqueHand.addCard(dCard);
				while (uniqueHand.count() > 5) {
					discardCard = uniqueHand.findLeastCard();
					discardedCards.add(discardCard);
					uniqueHand.removeCard(discardCard);
				}
			} while (!uniqueHand.has(dCard));

			do {
				repeats.add(dCard);
				superDeck.insertFront(dCard);
			} while (uniqueHand.has(dCard));

			for (Card card : drawnCards) {
				sb.append("+" + card.toString() + " ");
			}
			for (Card card : discardedCards) {
				sb.append("-" + card.toString());
			}

			round = round + 1;

			System.out.println("Round#: " + round);
			System.out.print(" " + sb.toString() + "\n");
			System.out.println("  " + uniqueHand);
			System.out.println("   " + repeats);

		}
		int score = uniqueHand.calculateScore();
		System.out.println("Final Score: " + score);
	}

}
