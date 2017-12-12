package homework2Revised;

import java.util.ArrayList;

public class Game {

	protected final UniqueHand uniqueHand = new UniqueHand();
	protected final UniqueHand repeats = new UniqueHand();
	protected final int score = 0;

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

		for (int i = 0; i < 5; i++) {
			uniqueHand.addCard(superDeck.getCards().get(i));
		}
		superDeck.shuffle();
		System.out.println("Initial Hand: " + uniqueHand);
		System.out.println(" ");

		for (int i = 0; i < R; i++) {

			StringBuilder sb = new StringBuilder();

			ArrayList<Card> drawnCards = new ArrayList<Card>();
			ArrayList<Card> discardedCards = new ArrayList<Card>();
			Card discardCard = uniqueHand.findLeastCard();
			Card dCard = superDeck.removeRear();
			
			while (true){
				for(int j = 0; j < uniqueHand.count(); j++){
					if(uniqueHand.has(dCard)){
						superDeck.insertFront(dCard);
						repeats.addCard(dCard);
						continue;
					}
				}
				if(!uniqueHand.has(dCard)){
					drawnCards.add(dCard);
					uniqueHand.addCard(dCard);
					if (uniqueHand.count() > 5) {
						discardCard = uniqueHand.findLeastCard();
						discardedCards.add(discardCard);
						uniqueHand.removeCard(discardCard);
					}
					break;
				}
			}
			/*if (!uniqueHand.has(dCard)) {
				drawnCards.add(dCard);
				uniqueHand.addCard(dCard);
				
				if (uniqueHand.count() > 5) {
					discardCard = uniqueHand.findLeastCard();
					discardedCards.add(discardCard);
					uniqueHand.removeCard(discardCard);
				}
			}
			
			if (uniqueHand.has(dCard)) {
				superDeck.insertFront(dCard);
				repeats.addCard(dCard);
			}*/
			
			for (Card card : drawnCards) {
				sb.append("+" + card.toString() + " ");
			}
			for (Card card : discardedCards) {
				sb.append("-" + card.toString());
			}
			superDeck.shuffle();
			round = round + 1;

			System.out.println("Round#: " + round);
			System.out.print("Changes: " + " " + sb.toString() + "\n");
			System.out.println("Current Hand: " + "  " + uniqueHand);
			System.out.println("Repeats: " + "   " + repeats);
			System.out.println(" ");

		}
		int score = uniqueHand.calculateScore();
		System.out.println("Final Score: " + score);
	}

}
